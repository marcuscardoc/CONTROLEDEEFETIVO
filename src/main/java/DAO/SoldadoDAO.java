package main.java.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import main.java.model.Soldado;

public class SoldadoDAO {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("esicontrol");

	public void criarSoldado(Soldado soldado) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(soldado);
		em.getTransaction().commit();
		em.close();
	}

	public void salvarModificacoes(Soldado soldado) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = null;
		try {
			transaction = em.getTransaction();
			transaction.begin();

			em.merge(soldado);

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();

		}
	}

	public void excluirSoldado(Soldado soldado) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = null;
		try {
			transaction = em.getTransaction();
			transaction.begin();

			Soldado soldadoToDelete = em.find(Soldado.class, soldado.getId());
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

	public List<Soldado> buscarPorNome(String nome) {
		EntityManager em = emf.createEntityManager();

		try {
			// Consultar o banco de dados para buscar soldados pelo nome
			TypedQuery<Soldado> query = em.createQuery("SELECT s FROM Soldado s WHERE s.nome LIKE :nome",
					Soldado.class);
			query.setParameter("nome", "%" + nome + "%");
			return query.getResultList();
		} finally {
			em.close();
		}
	}

	public List<Soldado> buscarSoldados() {
		EntityManager em = emf.createEntityManager();
		List<Soldado> soldados = null;
		try {
			soldados = em.createQuery("FROM Soldado", Soldado.class).getResultList();
		} finally {
			em.close();
		}
		return soldados;
	}

}
