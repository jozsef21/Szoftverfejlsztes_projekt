package szoftver_fejlesztes_mozi.szoftver_fejlesztes_mozi.backend.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import szoftver_fejlesztes_mozi.szoftver_fejlesztes_mozi.backend.Model.Vetitesek;
import szoftver_fejlesztes_mozi.szoftver_fejlesztes_mozi.backend.Repository.VetitesekRepository;

import java.util.List;

@RestController
@RequestMapping("/api/vetitesek")
public class VetitesekController {

    private final VetitesekRepository vetitesekRepository;

    public VetitesekController(VetitesekRepository vetitesekRepository) {
        this.vetitesekRepository = vetitesekRepository;
    }

    // Kilistázza az összes vetítést
    @GetMapping
    public List<Vetitesek> kilistaz() {
        return vetitesekRepository.findAll();
    }
}