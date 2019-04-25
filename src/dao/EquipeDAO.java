package dao;

import model.Equipe;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;


public class EquipeDAO {
    private static EquipeDAO instance = new EquipeDAO();
    public static EquipeDAO getInstance(){
        return instance;
    }
    private EquipeDAO(){
        
    }

    public void save(Equipe equipe)  {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            if(equipe.getIdEquipe() != null){
                em.merge(equipe);
            }else{
            em.persist(equipe);
        }
         tx.commit();       
        } catch (Exception e) {
            if(tx != null && tx.isActive()){
                tx.rollback();
            }
            throw new RuntimeException(e);
        }finally{
            PersistenceUtil.close(em);
        }
       
    }
    public void remove(Equipe equipe) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.remove(em.getReference(Equipe.class, equipe.getIdEquipe()));
            tx.commit();       
        } catch (Exception e) {
            if(tx != null && tx.isActive()){
                tx.rollback();
            }
            throw new RuntimeException(e);
        }finally{
            PersistenceUtil.close(em);
        }
    }

    public Equipe find(Long id) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Equipe equipe = null;
        try {
            tx.begin();
            equipe = em.find(Equipe.class, id);
            tx.commit();       
        } catch (Exception e) {
            if(tx != null && tx.isActive()){
                tx.rollback();
            }
            throw new RuntimeException(e);
        }finally{
            PersistenceUtil.close(em);
        }
        return equipe;
        
    }
    public List<Equipe> findAll(){
       EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Equipe> equipes = null;
        try {
           tx.begin();
           TypedQuery<Equipe> query = em.createQuery("select e From equipe e", Equipe.class);
           equipes = query.getResultList();
         tx.commit();       
        } catch (Exception e) {
            if(tx != null && tx.isActive()){
                tx.rollback();
            }
            throw new RuntimeException(e);
        }finally{
            PersistenceUtil.close(em);
        }
        return equipes;
        
    }
    
}
