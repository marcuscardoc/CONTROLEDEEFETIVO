package main.java.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import main.java.model.Soldado;
import main.java.model.SoldadoDispMedica;

public class SoldadoDispMedicaDAO {
 
EntityManagerFactory emf = Persistence.createEntityManagerFactory("esicontrol");
	
public void criarSoldadoDispMedica(SoldadoDispMedica soldadoDispMedica) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(soldadoDispMedica);
		em.getTransaction().commit();
		em.close();
	}
	
public void salvarModificacoes(SoldadoDispMedica soldadoDispMedica) {
		EntityManager em = emf.createEntityManager();
	    EntityTransaction transaction = null;
	    try {
	        transaction = em.getTransaction();
	        transaction.begin();

	       
	        em.merge(soldadoDispMedica);

	        transaction.commit();
	    } catch (Exception e) {
	        if (transaction != null && transaction.isActive()) {
	            transaction.rollback();
	        }
	        e.printStackTrace();
	        
	    }
	}

	
public void excluirSoldado(SoldadoDispMedica soldadoDispMedica) {
		EntityManager em = emf.createEntityManager();
	    EntityTransaction transaction = null;
	    try {
			transaction = em.getTransaction();
	        transaction.begin();

	        
	        Soldado soldadoToDelete = em.find(Soldado.class, soldadoDispMedica.getId());
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
	
public List<SoldadoDispMedica> buscarPorNome(String nome) {
        EntityManager em = emf.createEntityManager();

        try {
            // Consultar o banco de dados para buscar soldados pelo nome
            TypedQuery<SoldadoDispMedica> query = em.createQuery("SELECT s FROM SoldadoDispMedica s WHERE s.nome LIKE :nome", SoldadoDispMedica.class);
            query.setParameter("nome", "%" + nome + "%");
            return query.getResultList();
        } finally {
            em.close();
        }
    }

	
public List<SoldadoDispMedica> buscarSoldados(){
		EntityManager em = emf.createEntityManager();
		List<SoldadoDispMedica> soldadosDispMedica = null;
		try {
			soldadosDispMedica = em.createQuery("FROM SoldadoDispMedica", SoldadoDispMedica.class).getResultList();
		} finally {
			em.close();
		}
		return soldadosDispMedica;
	}
	
	
}
