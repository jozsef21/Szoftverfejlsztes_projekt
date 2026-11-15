package szoftver_fejlesztes_mozi.szoftver_fejlesztes_mozi.backend.Model;

import jakarta.persistence.*;

@Entity
public class Termek {

    @Id
    private Integer ID;
    private String nev;
    private Integer sorok_szama;
    private Integer oszlopk_szama;

    public Termek()
    {

    }

    public void setID(Integer ID) { this.ID = ID; }
    public void setNev(String nev) { this.nev = nev; }
    public void setSorok_szama(Integer sorok_szama) { this.sorok_szama = sorok_szama; }
    public void setOszlopk_szama(Integer oszlopk_szama) { this.oszlopk_szama = oszlopk_szama; }

    public Integer getID() {
        return ID;
    }

    public String getNev() {
        return nev;
    }

    public Integer getSorok_szama() {
        return sorok_szama;
    }

    public Integer getOszlopk_szama() {
        return oszlopk_szama;
    }
}
