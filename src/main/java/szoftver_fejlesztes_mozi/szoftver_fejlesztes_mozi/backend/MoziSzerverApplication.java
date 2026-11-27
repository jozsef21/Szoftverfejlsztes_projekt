package szoftver_fejlesztes_mozi.szoftver_fejlesztes_mozi.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import szoftver_fejlesztes_mozi.szoftver_fejlesztes_mozi.frontend.Alkalmazas.Controller.Navigator;

@SpringBootApplication(scanBasePackages = "szoftver_fejlesztes_mozi.szoftver_fejlesztes_mozi")
public class MoziSzerverApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(MoziSzerverApplication.class, args);
        Navigator.setApplicationContext(context);
    }
}
