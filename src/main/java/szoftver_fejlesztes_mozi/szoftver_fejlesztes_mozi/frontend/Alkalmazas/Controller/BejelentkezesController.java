package szoftver_fejlesztes_mozi.szoftver_fejlesztes_mozi.frontend.Alkalmazas.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class BejelentkezesController {

    // temp
    private static final String FELHASZNALO = "manager";
    private static final String JELSZO = "jelszo";

    @FXML private TextField felhasznaloMezo;
    @FXML private PasswordField jelszoMezo;
    @FXML private Label hibaCimke;

    @FXML
    private void belepes() {
        if (FELHASZNALO.equals(felhasznaloMezo.getText()) && JELSZO.equals(jelszoMezo.getText())) {
            Navigator.goTo("Kezdolap.fxml", felhasznaloMezo);
        } else {
            hibaCimke.setText("Hibás felhasználónév vagy jelszó!");
        }
    }
}
