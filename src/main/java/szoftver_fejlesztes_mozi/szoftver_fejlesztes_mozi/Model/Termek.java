package szoftver_fejlesztes_mozi.szoftver_fejlesztes_mozi.Model;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

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
