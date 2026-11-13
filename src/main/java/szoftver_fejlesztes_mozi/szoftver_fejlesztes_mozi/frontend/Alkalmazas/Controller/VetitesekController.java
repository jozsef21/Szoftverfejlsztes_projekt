package szoftver_fejlesztes_mozi.szoftver_fejlesztes_mozi.frontend.Alkalmazas.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;

import java.util.Optional;

public class VetitesekController {

    @FXML private TableView<Vetites> tabla;
    @FXML private TableColumn<Vetites, String> filmOszlop;
    @FXML private TableColumn<Vetites, String> teremOszlop;
    @FXML private TableColumn<Vetites, String> idopontOszlop;

    @FXML
    private void initialize() {
        filmOszlop.setCellValueFactory(new PropertyValueFactory<>("film"));
        teremOszlop.setCellValueFactory(new PropertyValueFactory<>("terem"));
        idopontOszlop.setCellValueFactory(new PropertyValueFactory<>("idopont"));
        tabla.setItems(Adatok.VETITESEK);
    }

    @FXML
    private void vetitesHozzaadas() {
        TextField film = new TextField();
        film.setPromptText("Film címe");
        TextField terem = new TextField();
        terem.setPromptText("pl. 1-es terem");
        TextField idopont = new TextField();
        idopont.setPromptText("pl. 2026-11-15 19:00");

        GridPane racs = new GridPane();
        racs.setHgap(10);
        racs.setVgap(10);
        racs.addRow(0, new Label("Film:"), film);
        racs.addRow(1, new Label("Terem:"), terem);
        racs.addRow(2, new Label("Időpont:"), idopont);

        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setTitle("Vetítés hozzáadása");
        dialog.getDialogPane().setContent(racs);
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

        Optional<ButtonType> eredmeny = dialog.showAndWait();
        if (eredmeny.isPresent() && eredmeny.get() == ButtonType.OK
                && !film.getText().trim().isEmpty() && !terem.getText().trim().isEmpty() && !idopont.getText().trim().isEmpty()) {
            Adatok.VETITESEK.add(new Vetites(film.getText().trim(), terem.getText().trim(), idopont.getText().trim()));
        }
    }

    @FXML
    private void vetitesEltavolitas() {
        Vetites kivalasztott = tabla.getSelectionModel().getSelectedItem();
        if (kivalasztott == null) {
            new Alert(Alert.AlertType.WARNING, "Válassz ki egy vetítést a listából!").showAndWait();
            return;
        }
        Adatok.VETITESEK.remove(kivalasztott);
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
