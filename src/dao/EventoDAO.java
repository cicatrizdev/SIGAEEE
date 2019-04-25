package dao;

import model.Evento;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;


public class EventoDAO {
    private static EventoDAO instance = new EventoDAO();
    public static EventoDAO getInstance(){
        return instance;
    }
    private EventoDAO(){
        
    }

    public void save(Evento evento)  {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            if(evento.getIdEvento() != null){
                em.merge(evento);
            }else{
            em.persist(evento);
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
    public void remove(Evento evento) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.remove(em.getReference(Evento.class, evento.getIdEvento()));
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

    public Evento find(Long id) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Evento evento = null;
        try {
            tx.begin();
            evento = em.find(Evento.class, id);
            tx.commit();       
        } catch (Exception e) {
            if(tx != null && tx.isActive()){
                tx.rollback();
            }
            throw new RuntimeException(e);
        }finally{
            PersistenceUtil.close(em);
        }
        return evento;
        
    }
    public List<Evento> findAll(){
       EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Evento> eventos = null;
        try {
           tx.begin();
           TypedQuery<Evento> query = em.createQuery("select e From evento e", Evento.class);
           eventos = query.getResultList();
         tx.commit();       
        } catch (Exception e) {
            if(tx != null && tx.isActive()){
                tx.rollback();
            }
            throw new RuntimeException(e);
        }finally{
            PersistenceUtil.close(em);
        }
        return eventos;
        
    }
    
}
