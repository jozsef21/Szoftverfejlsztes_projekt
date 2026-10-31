module szoftver_fejlesztes_mozi.szoftver_fejlesztes_mozi {
    requires javafx.controls;
    requires javafx.fxml;

    requires java.persistence;
    requires java.sql;

    opens szoftver_fejlesztes_mozi.szoftver_fejlesztes_mozi to javafx.fxml;
    exports szoftver_fejlesztes_mozi.szoftver_fejlesztes_mozi;
}