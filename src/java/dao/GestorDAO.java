package dao;

import model.Gestor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;


public class GestorDAO {
    private static GestorDAO instance = new GestorDAO();
    public static GestorDAO getInstance(){
        return instance;
    }
    private GestorDAO(){
        
    }

    public void save(Gestor gestor)  {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            if(gestor.getIdUsuario() != null){
                em.merge(gestor);
            }else{
            em.persist(gestor);
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
    public void remove(Gestor gestor) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.remove(em.getReference(Gestor.class, gestor.getIdUsuario()));
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

    public Gestor find(Long id) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Gestor gestor = null;
        try {
            tx.begin();
            gestor = em.find(Gestor.class, id);
            tx.commit();       
        } catch (Exception e) {
            if(tx != null && tx.isActive()){
                tx.rollback();
            }
            throw new RuntimeException(e);
        }finally{
            PersistenceUtil.close(em);
        }
        return gestor;
        
    }
    public List<Gestor> findAll(){
       EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Gestor> gestores = null;
        try {
           tx.begin();
           TypedQuery<Gestor> query = em.createQuery("select g From gestor g", Gestor.class);
           gestores = query.getResultList();
         tx.commit();       
        } catch (Exception e) {
            if(tx != null && tx.isActive()){
                tx.rollback();
            }
            throw new RuntimeException(e);
        }finally{
            PersistenceUtil.close(em);
        }
        return gestores;
        
    }
    
}
