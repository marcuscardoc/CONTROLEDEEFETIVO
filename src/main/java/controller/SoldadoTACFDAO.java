package main.java.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class SoldadoTACFDAO {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("esicontrol");

	public void salvarModificacoes(SoldadoTACF soldadoTACF) {
		EntityManager em = emf.createEntityManager();
	    EntityTransaction transaction = null;
	    
	    try {
	        transaction = em.getTransaction();
	        transaction.begin();
	       
	        em.merge(soldadoTACF);

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
            TypedQuery<Soldado> query = em.createQuery("SELECT s FROM Soldado s WHERE s.nome LIKE :nome", Soldado.class);
            query.setParameter("nome", "%" + nome + "%");
            return query.getResultList();
        } finally {
            em.close();
        }
    }
	
	public List<SoldadoTACF> buscarSoldados(){
		EntityManager em = emf.createEntityManager();
		List<SoldadoTACF> soldadosTACF = null;
		try {
			soldadosTACF = em.createQuery("FROM SoldadoTACF", SoldadoTACF.class).getResultList();
		} finally {
			em.close();
		}
		return soldadosTACF;
	}
	
	
}
