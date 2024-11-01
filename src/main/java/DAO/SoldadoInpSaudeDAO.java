package main.java.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import main.java.model.Soldado;
import main.java.model.SoldadoInpSaude;

public class SoldadoInpSaudeDAO {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("esicontrol");

	public void atualizarSoldado(SoldadoInpSaude soldadoInpSaude) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(soldadoInpSaude);
		em.getTransaction().commit();
		em.close();
	}

	public void salvarModificacoes(SoldadoInpSaude soldadoInpSaude) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = null;
		try {
			transaction = em.getTransaction();
			transaction.begin();

			em.merge(soldadoInpSaude);

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();

		}
	}

	public List<SoldadoInpSaude> buscarPorNome(String nome) {
		EntityManager em = emf.createEntityManager();

		try {
			// Consultar o banco de dados para buscar soldados pelo nome
			TypedQuery<SoldadoInpSaude> query = em
					.createQuery("SELECT s FROM SoldadoInpSaude s WHERE s.nome LIKE :nome", SoldadoInpSaude.class);
			query.setParameter("nome", "%" + nome + "%");
			return query.getResultList();
		} finally {
			em.close();
		}
	}

	public List<SoldadoInpSaude> buscarSoldados() {
		EntityManager em = emf.createEntityManager();
		List<SoldadoInpSaude> soldadosSaude = null;
		try {
			soldadosSaude = em.createQuery("FROM SoldadoInpSaude", SoldadoInpSaude.class).getResultList();
		} finally {
			em.close();
		}
		return soldadosSaude;
	}

	public void excluirSoldado(SoldadoInpSaude soldadoInpSaude) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = null;
		try {
			transaction = em.getTransaction();
			transaction.begin();

			Soldado soldadoToDelete = em.find(Soldado.class, soldadoInpSaude.getId());
			if (soldadoToDelete != null) {
				em.remove(soldadoToDelete);
			}

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
}
