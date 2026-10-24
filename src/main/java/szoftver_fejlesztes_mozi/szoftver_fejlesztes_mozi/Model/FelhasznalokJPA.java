package szoftver_fejlesztes_mozi.szoftver_fejlesztes_mozi.Model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FelhasznalokJPA extends AlapJPA implements FelhasznalokDAO{

    private final EntityManagerFactory entityManagerFactory;
    private final EntityManager entityManager;

    public FelhasznalokJPA() {
        entityManagerFactory = Persistence.createEntityManagerFactory("br.com.fredericci.pu");
        entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    public void saveFelhasznalok(Felhasznalok a) {
        entityManager.getTransaction().begin();
        entityManager.persist(a);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteFelhasznalok(Felhasznalok a) {
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.contains(a) ? a : entityManager.merge(a));
        entityManager.getTransaction().commit();
    }
}
