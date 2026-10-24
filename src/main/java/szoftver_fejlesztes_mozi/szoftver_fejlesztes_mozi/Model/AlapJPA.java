package szoftver_fejlesztes_mozi.szoftver_fejlesztes_mozi.Model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class AlapJPA implements AutoCloseable {

    protected final EntityManagerFactory entityManagerFactory;
    protected final EntityManager entityManager;

    public AlapJPA() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("br.com.fredericci.pu");
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    public void close() {
        if (entityManager != null) {
            entityManager.close();
        }
        if (entityManagerFactory != null) {
            entityManagerFactory.close();
        }
    }
}