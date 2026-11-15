package szoftver_fejlesztes_mozi.szoftver_fejlesztes_mozi.frontend.Web.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebViewController {

    @GetMapping("/")
    public String kezdoOldal() {
        return "startlap";
    }

    @GetMapping("/musor")
    public String musorOldal() {
        return "musor";
    }

    @GetMapping("/termek")
    public String termekOldal() {
        return "termek";
    }

    @GetMapping("/bufe")
    public String bufeOldal() {
        return "bufe";
    }

    @GetMapping("/login")
    public String loginOldal() {
        return "login";
    }
}