package szoftver_fejlesztes_mozi.szoftver_fejlesztes_mozi.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import szoftver_fejlesztes_mozi.szoftver_fejlesztes_mozi.frontend.Alkalmazas.Controller.Navigator;

@SpringBootApplication(scanBasePackages = "szoftver_fejlesztes_mozi.szoftver_fejlesztes_mozi")
public class MoziSzerverApplication {

    public static void main(String[] args) {
        // 1. Elindítjuk a Spring Bootot és elmentjük a kontextust
        ConfigurableApplicationContext context = SpringApplication.run(MoziSzerverApplication.class, args);

        // 2. Beállítjuk a Navigatornek, hogy a JavaFX is el tudja kérni a kontrollereket a Springtől
        Navigator.setApplicationContext(context);
    }
}
