package szoftver_fejlesztes_mozi.szoftver_fejlesztes_mozi.frontend.Alkalmazas.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class KezdolapController {

    @FXML private Button dolgozokGomb;

    @FXML
    private void dolgozok() {
        Navigator.goTo("Dolgozok.fxml", dolgozokGomb);
    }

    @FXML
    private void vetitesek() {
        Navigator.goTo("Vetitesek.fxml", dolgozokGomb);
    }

    @FXML
    private void kijelentkezes() {
        Navigator.goTo("Bejelentkezes.fxml", dolgozokGomb);
    }
}
