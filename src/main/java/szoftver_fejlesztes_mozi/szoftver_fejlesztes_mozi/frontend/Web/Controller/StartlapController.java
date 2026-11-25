package szoftver_fejlesztes_mozi.szoftver_fejlesztes_mozi.frontend.Web.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import szoftver_fejlesztes_mozi.szoftver_fejlesztes_mozi.backend.Model.Filmek;
import szoftver_fejlesztes_mozi.szoftver_fejlesztes_mozi.backend.Repository.FilmekRepository;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class StartlapController {

    @Autowired
    private FilmekRepository filmekRepository;

    @GetMapping("/")
    public String Startlap(Model model)
    {
        List<Filmek> filmek = filmekRepository.findAll();

        Collections.shuffle(filmek);

        List<Filmek> randomFilmek = filmek.stream().limit(10).collect(Collectors.toList());

        model.addAttribute("randomFilmek",randomFilmek);
        return "startlap";
    }
}
