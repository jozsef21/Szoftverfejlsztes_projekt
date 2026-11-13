package szoftver_fejlesztes_mozi.szoftver_fejlesztes_mozi.frontend.Alkalmazas.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Adatok {

    public static final ObservableList<Dolgozo> DOLGOZOK = FXCollections.observableArrayList(
            new Dolgozo("Kiss Péter", "Jegyellenőr"),
            new Dolgozo("Nagy Anna", "Pénztáros")
    );

    public static final ObservableList<Vetites> VETITESEK = FXCollections.observableArrayList(
            new Vetites("Dűne", "1-es terem", "2026-11-14 18:00"),
            new Vetites("Interstellar", "2-es terem", "2026-11-14 20:30")
    );
}
