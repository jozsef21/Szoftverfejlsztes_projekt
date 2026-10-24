package szoftver_fejlesztes_mozi.szoftver_fejlesztes_mozi.Model;

import javax.persistence.*;

@Entity
public class Felhasznalok {

    private String nev;
    @Id
    private String regisztralt_nev;
    private String jelszo;

    public Felhasznalok()
    {

    }

    public String getNev() {
        return nev;
    }

    public String getRegisztralt_nev() {
        return regisztralt_nev;
    }
}
