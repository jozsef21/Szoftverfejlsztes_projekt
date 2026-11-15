package szoftver_fejlesztes_mozi.szoftver_fejlesztes_mozi.frontend.Alkalmazas.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;

import java.util.Optional;

public class DolgozokController {

    @FXML private TableView<Dolgozo> tabla;
    @FXML private TableColumn<Dolgozo, String> nevOszlop;
    @FXML private TableColumn<Dolgozo, String> beosztasOszlop;

    @FXML
    private void initialize() {
        nevOszlop.setCellValueFactory(new PropertyValueFactory<>("nev"));
        beosztasOszlop.setCellValueFactory(new PropertyValueFactory<>("beosztas"));
        tabla.setItems(Adatok.DOLGOZOK);
    }

    @FXML
    private void dolgozoHozzaadas() {
        TextField nev = new TextField();
        nev.setPromptText("Név");
        TextField beosztas = new TextField();
        beosztas.setPromptText("Beosztás");

        GridPane racs = new GridPane();
        racs.setHgap(10);
        racs.setVgap(10);
        racs.addRow(0, new Label("Név:"), nev);
        racs.addRow(1, new Label("Beosztás:"), beosztas);

        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setTitle("Dolgozó hozzáadása");
        dialog.getDialogPane().setContent(racs);
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

        Optional<ButtonType> eredmeny = dialog.showAndWait();
        if (eredmeny.isPresent() && eredmeny.get() == ButtonType.OK
                && !nev.getText().trim().isEmpty() && !beosztas.getText().trim().isEmpty()) {
            Adatok.DOLGOZOK.add(new Dolgozo(nev.getText().trim(), beosztas.getText().trim()));
        }
    }

    @FXML
    private void dolgozoEltavolitas() {
        Dolgozo kivalasztott = tabla.getSelectionModel().getSelectedItem();
        if (kivalasztott == null) {
            new Alert(Alert.AlertType.WARNING, "Válassz ki egy dolgozót a listából!").showAndWait();
            return;
        }
        Adatok.DOLGOZOK.remove(kivalasztott);
    }

    @FXML
    private void vissza() {
        Navigator.goTo("Kezdolap.fxml", tabla);
    }

    @FXML
    private void kijelentkezes() {
        Navigator.goTo("Bejelentkezes.fxml", tabla);
    }
}
