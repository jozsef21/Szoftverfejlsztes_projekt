package szoftver_fejlesztes_mozi.szoftver_fejlesztes_mozi.backend.Model;

import jakarta.persistence.*;

@Entity
public class Felhasznalok {

    private String nev;
    @Id
    private String regisztralt_nev;
    private String jelszo;

    public Felhasznalok()
    {

    }

    public void setNev(String nev) { this.nev = nev; }
    public void setRegisztralt_nev(String regisztralt_nev) { this.regisztralt_nev = regisztralt_nev; }
    public String getJelszo() { return jelszo; }
    public void setJelszo(String jelszo) { this.jelszo = jelszo; }

    public String getNev() {
        return nev;
    }

    public String getRegisztralt_nev() {
        return regisztralt_nev;
    }
}
