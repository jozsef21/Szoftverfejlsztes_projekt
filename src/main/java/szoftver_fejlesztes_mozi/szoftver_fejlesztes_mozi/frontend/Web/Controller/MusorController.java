package szoftver_fejlesztes_mozi.szoftver_fejlesztes_mozi.frontend.Web.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import szoftver_fejlesztes_mozi.szoftver_fejlesztes_mozi.backend.Model.Filmek;
import szoftver_fejlesztes_mozi.szoftver_fejlesztes_mozi.backend.Model.Vetitesek;
import szoftver_fejlesztes_mozi.szoftver_fejlesztes_mozi.backend.Repository.VetitesekRepository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class MusorController {

    private final VetitesekRepository vetitesekRepository;

    @Autowired
    public MusorController(VetitesekRepository vetitesekRepository) {
        this.vetitesekRepository = vetitesekRepository;
    }


    @GetMapping("/musor")
    public String musorMegjelenitese(Model model) {
        List<Vetitesek> osszesVetites = vetitesekRepository.findAll();
        Map<Filmek, List<Vetitesek>> filmenkentCsoportositva = osszesVetites.stream()
                .collect(Collectors.groupingBy(Vetitesek::getFilmek_id));
        model.addAttribute("musorLista", filmenkentCsoportositva);
        return "musor";
    }
}