package dao;

import model.Posicao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;


public class PosicaoDAO {
    private static PosicaoDAO instance = new PosicaoDAO();
    public static PosicaoDAO getInstance(){
        return instance;
    }
    private PosicaoDAO(){
        
    }

    public void save(Posicao posicao)  {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            if(posicao.getIdPosicao() != null){
                em.merge(posicao);
            }else{
            em.persist(posicao);
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
    public void remove(Posicao posicao) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.remove(em.getReference(Posicao.class, posicao.getIdPosicao()));
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

    public Posicao find(Long id) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Posicao posicao = null;
        try {
            tx.begin();
            posicao = em.find(Posicao.class, id);
            tx.commit();       
        } catch (Exception e) {
            if(tx != null && tx.isActive()){
                tx.rollback();
            }
            throw new RuntimeException(e);
        }finally{
            PersistenceUtil.close(em);
        }
        return posicao;
        
    }
    public List<Posicao> findAll(){
       EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Posicao> posicoes = null;
        try {
           tx.begin();
           TypedQuery<Posicao> query = em.createQuery("select p From posicao p", Posicao.class);
           posicoes = query.getResultList();
         tx.commit();       
        } catch (Exception e) {
            if(tx != null && tx.isActive()){
                tx.rollback();
            }
            throw new RuntimeException(e);
        }finally{
            PersistenceUtil.close(em);
        }
        return posicoes;
        
    }
    
}
