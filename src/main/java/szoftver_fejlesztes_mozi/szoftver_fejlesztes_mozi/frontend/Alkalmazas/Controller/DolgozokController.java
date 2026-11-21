package szoftver_fejlesztes_mozi.szoftver_fejlesztes_mozi.frontend.Alkalmazas.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import org.springframework.stereotype.Component;
import szoftver_fejlesztes_mozi.szoftver_fejlesztes_mozi.backend.Model.Dolgozok;
import szoftver_fejlesztes_mozi.szoftver_fejlesztes_mozi.backend.Repository.DolgozokRepository;

import java.util.List;
import java.util.Optional;

@Component
public class DolgozokController {

    private final DolgozokRepository dolgozokRepository;

    @FXML private TableView<Dolgozok> tabla;
    @FXML private TableColumn<Dolgozok, String> nevOszlop;
    @FXML private TableColumn<Dolgozok, String> beosztasOszlop;

    private ObservableList<Dolgozok> dolgozokLista = FXCollections.observableArrayList();

    // Konstruktor alapú injekció közvetlenül a Springtől
    public DolgozokController(DolgozokRepository dolgozokRepository) {
        this.dolgozokRepository = dolgozokRepository;
    }

    @FXML
    private void initialize() {
        // Oszlopok összekötése a Dolgozok entitás mezőivel
        nevOszlop.setCellValueFactory(new PropertyValueFactory<>("nev"));
        beosztasOszlop.setCellValueFactory(new PropertyValueFactory<>("munkakor"));

        tabla.setItems(dolgozokLista);

        // Adatok lekérése az adatbázisból és betöltése a táblázatba
        adatokBetolteseAdatbazisbol();
    }

    private void adatokBetolteseAdatbazisbol() {
        List<Dolgozok> adatok = dolgozokRepository.findAll();
        dolgozokLista.setAll(adatok);
    }

    @FXML
    private void dolgozoHozzaadas() {
        TextField nev = new TextField();
        nev.setPromptText("Név");
        TextField beosztas = new TextField();
        beosztas.setPromptText("munkakor");

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
            // 1. Létrehozzuk az új entitást
            Dolgozok uj = new Dolgozok();
            uj.setNev(nev.getText().trim());
            uj.setMunkakor(beosztas.getText().trim());

            // 2. Elmentjük az adatbázisba a Repository-n keresztül
            dolgozokRepository.save(uj);

            // 3. Frissítjük a táblázatot az adatbázis tartalmával
            adatokBetolteseAdatbazisbol();
        }
    }

    @FXML
    private void dolgozoEltavolitas() {
        Dolgozok kivalasztott = tabla.getSelectionModel().getSelectedItem();
        if (kivalasztott == null) {
            new Alert(Alert.AlertType.WARNING, "Válassz ki egy dolgozót a listából!").showAndWait();
            return;
        }
        // Törlés az adatbázisból a Repository segítségével
        dolgozokRepository.delete(kivalasztott);

        // Táblázat frissítése
        adatokBetolteseAdatbazisbol();
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