package szoftver_fejlesztes_mozi.szoftver_fejlesztes_mozi.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import szoftver_fejlesztes_mozi.szoftver_fejlesztes_mozi.backend.Model.Dolgozok;

@Repository
public interface DolgozokRepository extends JpaRepository<Dolgozok, Long> {

}
