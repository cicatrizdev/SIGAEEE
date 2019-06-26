package dao;

import java.lang.reflect.Method;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

public class DAO {

    private static DAO instance = new DAO();

    public static DAO getInstance() {
        return instance;
    }

    private DAO() {

    }

    public void save(Object objeto) throws NoSuchMethodException {

        Method metodo = objeto.getClass().getMethod("getId", null);
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            if (metodo.invoke(objeto) != null) {
                em.merge(objeto);
            } else {
                em.persist(objeto);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
    }

    public void remove(Object objeto) throws NoSuchMethodException {
        Method metodo = objeto.getClass().getMethod("getId", null);
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.remove(em.getReference(objeto.getClass(), metodo.invoke(objeto)));
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
    }

    public Object find(Long id) throws ClassNotFoundException {

        StackTraceElement[] ste = new Throwable().getStackTrace();
        String nomeClasse = ste[1].getClassName();
        Class classe = Class.forName(nomeClasse);

        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Object objeto = null;
        try {
            tx.begin();
            objeto = em.find(classe, id);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return objeto;
    }

    public List<Object> findAll() throws ClassNotFoundException {

        StackTraceElement[] ste = new Throwable().getStackTrace();
        String nomeClasse = ste[1].getClassName();
        Class classe = Class.forName(nomeClasse);
        String nomeTabela = nomeClasse.replace("model.", "");

        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Object> objetos = null;
        try {
            tx.begin();
            TypedQuery<Object> query
                    = em.createQuery("select x from " + nomeTabela + " x", classe);
            objetos = query.getResultList();
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return objetos;
    }

}