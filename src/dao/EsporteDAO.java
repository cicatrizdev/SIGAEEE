package dao;

import model.Esporte;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;


public class EsporteDAO {
    private static EsporteDAO instance = new EsporteDAO();
    public static EsporteDAO getInstance(){
        return instance;
    }
    private EsporteDAO(){
        
    }

    public void save(Esporte esporte)  {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            System.out.println(esporte.getIdEsporte());
            if(esporte.getIdEsporte() != null){
                em.merge(esporte);
            }else{
            em.persist(esporte);
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
    public void remove(Esporte esporte) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.remove(em.getReference(Esporte.class, esporte.getIdEsporte()));
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

    public Esporte find(Long id) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Esporte esporte = null;
        try {
            tx.begin();
            esporte = em.find(Esporte.class, id);
            tx.commit();       
        } catch (Exception e) {
            if(tx != null && tx.isActive()){
                tx.rollback();
            }
            throw new RuntimeException(e);
        }finally{
            PersistenceUtil.close(em);
        }
        return esporte;
        
    }
    public List<Esporte> findAll(){
       EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Esporte> esportes = null;
        try {
           tx.begin();
           TypedQuery<Esporte> query = em.createQuery("select e From esporte e", Esporte.class);
           esportes = query.getResultList();
         tx.commit();       
        } catch (Exception e) {
            if(tx != null && tx.isActive()){
                tx.rollback();
            }
            throw new RuntimeException(e);
        }finally{
            PersistenceUtil.close(em);
        }
        return esportes;
        
    }
    
}
