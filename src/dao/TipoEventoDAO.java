package dao;

import model.TipoEvento;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;


public class TipoEventoDAO {
    private static TipoEventoDAO instance = new TipoEventoDAO();
    public static TipoEventoDAO getInstance(){
        return instance;
    }
    private TipoEventoDAO(){
        
    }

    public void save(TipoEvento tipoEvento)  {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            if(tipoEvento.getIdTipoEvento() != null){
                em.merge(tipoEvento);
            }else{
            em.persist(tipoEvento);
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
    public void remove(TipoEvento tipoEvento) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.remove(em.getReference(TipoEvento.class, tipoEvento.getIdTipoEvento()));
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

    public TipoEvento find(Long id) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        TipoEvento tipoEvento = null;
        try {
            tx.begin();
            tipoEvento = em.find(TipoEvento.class, id);
            tx.commit();       
        } catch (Exception e) {
            if(tx != null && tx.isActive()){
                tx.rollback();
            }
            throw new RuntimeException(e);
        }finally{
            PersistenceUtil.close(em);
        }
        return tipoEvento;
        
    }
    public List<TipoEvento> findAll(){
       EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<TipoEvento> tipoEventos = null;
        try {
           tx.begin();
           TypedQuery<TipoEvento> query = em.createQuery("select te From tipoEvento te", TipoEvento.class);
           tipoEventos = query.getResultList();
         tx.commit();       
        } catch (Exception e) {
            if(tx != null && tx.isActive()){
                tx.rollback();
            }
            throw new RuntimeException(e);
        }finally{
            PersistenceUtil.close(em);
        }
        return tipoEventos;
        
    }
    
}
