package szoftver_fejlesztes_mozi.szoftver_fejlesztes_mozi.backend.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import szoftver_fejlesztes_mozi.szoftver_fejlesztes_mozi.backend.Model.Dolgozok;
import szoftver_fejlesztes_mozi.szoftver_fejlesztes_mozi.backend.Repository.DolgozokRepository;

import java.util.List;

@RestController
@RequestMapping("/api/dolgozok")
public class DolgozokController {

    private final DolgozokRepository dolgozokRepository;

    public DolgozokController(DolgozokRepository dolgozokRepository) {
        this.dolgozokRepository = dolgozokRepository;
    }

    // Kilistázza az összes dolgozót
    @GetMapping
    public List<Dolgozok> kilistaz() {
        return dolgozokRepository.findAll();
    }
}