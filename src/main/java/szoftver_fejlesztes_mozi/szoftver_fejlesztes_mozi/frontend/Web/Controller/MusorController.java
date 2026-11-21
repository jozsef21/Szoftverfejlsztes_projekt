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
        // 1. Lekérjük az összes vetítést
        List<Vetitesek> osszesVetites = vetitesekRepository.findAll();

        // 2. Filmek szerint csoportosítjuk őket (kulcs: Film, érték: Vetítések listája)
        Map<Filmek, List<Vetitesek>> filmenkentCsoportositva = osszesVetites.stream()
                .collect(Collectors.groupingBy(Vetitesek::getFilmek_id));

        // 3. Átadjuk a modellnek a HTML felé
        model.addAttribute("musorLista", filmenkentCsoportositva);

        return "musor"; // Ez a musor.html fájl a templates mappában
    }
}