package szoftver_fejlesztes_mozi.szoftver_fejlesztes_mozi.frontend.Alkalmazas.Controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Navigator {

    public static void goTo(String fxmlNev, Node forras) {
        try {
            Stage stage = (Stage) forras.getScene().getWindow();
            Parent root = FXMLLoader.load(Navigator.class.getResource("/szoftver_fejlesztes_mozi/szoftver_fejlesztes_mozi/" + fxmlNev));
            Scene scene = new Scene(root);
            scene.getStylesheets().add(Navigator.class.getResource("/static/css/manager.css").toExternalForm());
            stage.setScene(scene);
        } catch (IOException e) {
            throw new RuntimeException("Nem sikerült betölteni: " + fxmlNev, e);
        }
    }
}
