package szoftver_fejlesztes_mozi.szoftver_fejlesztes_mozi.frontend.Alkalmazas.Controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import org.springframework.stereotype.Component;
import szoftver_fejlesztes_mozi.szoftver_fejlesztes_mozi.backend.Model.Filmek;
import szoftver_fejlesztes_mozi.szoftver_fejlesztes_mozi.backend.Model.Termek;
import szoftver_fejlesztes_mozi.szoftver_fejlesztes_mozi.backend.Model.Vetitesek;
import szoftver_fejlesztes_mozi.szoftver_fejlesztes_mozi.backend.Repository.FilmekRepository;
import szoftver_fejlesztes_mozi.szoftver_fejlesztes_mozi.backend.Repository.TermekRepository;
import szoftver_fejlesztes_mozi.szoftver_fejlesztes_mozi.backend.Repository.VetitesekRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class VetitesekController {

    private final VetitesekRepository vetitesekRepository;
    private final FilmekRepository filmekRepository;
    private final TermekRepository termekRepository;
    @FXML private TableView<Vetitesek> tabla;
    @FXML private TableColumn<Vetitesek, String> filmOszlop;
    @FXML private TableColumn<Vetitesek, String> teremOszlop;
    @FXML private TableColumn<Vetitesek, String> idopontOszlop;

    private ObservableList<Vetitesek> vetitesekLista = FXCollections.observableArrayList();


    public VetitesekController(VetitesekRepository vetitesekRepository, FilmekRepository filmekRepository, TermekRepository termekRepository) {
        this.vetitesekRepository = vetitesekRepository;
        this.filmekRepository = filmekRepository;
        this.termekRepository = termekRepository;
    }
    @FXML
    private void initialize() {
        filmOszlop.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getFilmek_id() != null ? cellData.getValue().getFilmek_id().getCim() : "")
        );
        teremOszlop.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getTerem_id() != null ? cellData.getValue().getTerem_id().getNev() : "")
        );
        idopontOszlop.setCellValueFactory(new PropertyValueFactory<>("kezdes_idopont"));
        tabla.setItems(vetitesekLista);

        adatokBetolteseAdatbazisbol();
    }

    private void adatokBetolteseAdatbazisbol() {
        List<Vetitesek> adatok = vetitesekRepository.findAll();
        vetitesekLista.setAll(adatok);
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
            Filmek filmEntity = filmekRepository.findById(film.getText().trim()).orElse(null);
            Integer teremID = Integer.parseInt(terem.getText().trim());
            Termek teremEntity = termekRepository.findById(teremID).orElse(null);
            Vetitesek uj = Vetitesek.builder()
                    .filmek_id(filmEntity)
                    .terem_id(teremEntity)
                    .Kezdes_idopont(LocalDateTime.parse(idopont.getText().trim()))
                    .alapar(3000)
                    .build();
            vetitesekRepository.save(uj);
            adatokBetolteseAdatbazisbol();
        }
    }

    @FXML
    private void vetitesEltavolitas() {
        Vetitesek kivalasztott = tabla.getSelectionModel().getSelectedItem();
        if (kivalasztott == null) {
            new Alert(Alert.AlertType.WARNING, "Válassz ki egy vetítést a listából!").showAndWait();
            return;
        }
        vetitesekRepository.delete(kivalasztott);
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
