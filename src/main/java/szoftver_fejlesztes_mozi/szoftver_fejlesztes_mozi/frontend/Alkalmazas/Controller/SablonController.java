package szoftver_fejlesztes_mozi.szoftver_fejlesztes_mozi.frontend.Alkalmazas.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class SablonController {

    @FXML
    private Label helloLabel;

    public void kiir(ActionEvent actionEvent) {
        if (helloLabel.getText().equals("Helló"))
        {
            helloLabel.setText("Megválétozott szöveg");
        }
        else
            helloLabel.setText("Helló");
    }

    public void change(ActionEvent actionEvent) throws IOException {
            Parent root = FXMLLoader.load(SablonController.class.getClassLoader().getResource("szoftver_fejlesztes_mozi/szoftver_fejlesztes_mozi/Manager_felulet.fxml"));
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
    }
}