module szoftver_fejlesztes_mozi.szoftver_fejlesztes_mozi {
    requires javafx.controls;
    requires javafx.fxml;


    opens szoftver_fejlesztes_mozi.szoftver_fejlesztes_mozi to javafx.fxml;
    exports szoftver_fejlesztes_mozi.szoftver_fejlesztes_mozi;
}