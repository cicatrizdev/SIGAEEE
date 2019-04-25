package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceUtil {
    private static EntityManagerFactory emf = null;

    public PersistenceUtil() {
    }

    public static EntityManager getEntityManager() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("SIGAEEEPU");
        }
        return emf.createEntityManager();
    }

    public static void close(EntityManager em) {
        if (em != null) {
            em.close();
        }
    }
}
