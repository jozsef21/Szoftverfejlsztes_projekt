package szoftver_fejlesztes_mozi.szoftver_fejlesztes_mozi.Model;

public interface DolgozokDAO extends AutoCloseable{
    void saveDolgozok(Dolgozok a);
    void deleteDolgozok(Dolgozok a);
}
