package szoftver_fejlesztes_mozi.szoftver_fejlesztes_mozi.Model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class VetitesekJPA extends AlapJPA implements VetitesekDAO{

    private final EntityManagerFactory entityManagerFactory;
    private final EntityManager entityManager;

    public VetitesekJPA() {
        entityManagerFactory = Persistence.createEntityManagerFactory("br.com.fredericci.pu");
        entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    public void saveVetitesek(Vetitesek a) {
        entityManager.getTransaction().begin();
        entityManager.persist(a);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteVetitesek(Vetitesek a) {
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.contains(a) ? a : entityManager.merge(a));
        entityManager.getTransaction().commit();
    }
}
