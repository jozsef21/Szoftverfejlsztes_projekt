package szoftver_fejlesztes_mozi.szoftver_fejlesztes_mozi.frontend.Alkalmazas.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import org.springframework.stereotype.Controller;

@Controller
public class ManagerController {

    @FXML
    private TableView<?> movieTable; // A felületi elemek

    @FXML
    public void initialize() {
        System.out.println("Manager felület sikeresen betöltődve a Spring kontextusból!");
    }
}
