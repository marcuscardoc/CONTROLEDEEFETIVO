package main.java.controller;

	import javax.persistence.EntityManager;
	import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.List;

	public class ObservacaoDAO {
	    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("esicontrol");

	    private EntityManager getEntityManager() {
	        return emf.createEntityManager();
	    }

	    // Método para salvar uma nova observação
	    public void salvarObs(Observacao observacao) {
	        EntityManager em = getEntityManager();
	        try {
	            em.getTransaction().begin();
	            em.persist(observacao);  // Salva a observação no banco de dados
	            em.getTransaction().commit();
	        } finally {
	            em.close();
	        }
	    }

	    // Método para buscar uma observação pelo ID
	    public Observacao BuscarObs(Integer id) {
	        EntityManager em = getEntityManager();
	        try {
	            return em.find(Observacao.class, id);
	        } finally {
	            em.close();
	        }
	    }

	    // Método para buscar todas as observações de um soldado
	    public List<Observacao> BuscarTodasObs(Soldado soldado) {
	        EntityManager em = getEntityManager();
	        try {
	            return em.createQuery("SELECT o FROM Observacao o WHERE o.soldado.id = :soldadoId", Observacao.class)
	                     .setParameter("soldadoId", soldado)
	                     .getResultList();
	        } finally {
	            em.close();
	        }
	    }

	    // Método para atualizar uma observação existente
	    public void AtualizarObs(Soldado observacao) {
	        EntityManager em = getEntityManager();
	        try {
	            em.getTransaction().begin();
	            em.merge(observacao);  // Atualiza a observação
	            em.getTransaction().commit();
	        } finally {
	            em.close();
	        }
	        }

	    public Observacao buscarObservacaoPorSoldadoEData(Soldado soldado, LocalDate data) {
	   	 EntityManagerFactory emf = Persistence.createEntityManagerFactory("esicontrol");
	        EntityManager em = emf.createEntityManager();
	        try {
	            TypedQuery<Observacao> query = em.createQuery(
	                "SELECT o FROM Observacao o WHERE o.soldado = :soldado AND o.data = :data", Observacao.class);
	            query.setParameter("soldado", soldado);
	            query.setParameter("data", data);
	            return query.getSingleResult();
	        } catch (NoResultException e) {
	            return null; // Sem observação para este dia
	        }
	    }
	   

}
