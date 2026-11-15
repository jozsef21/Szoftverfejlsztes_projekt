package szoftver_fejlesztes_mozi.szoftver_fejlesztes_mozi.backend.Model;

import jakarta.persistence.*;

@Entity
public class Kedvezmenyek {

    @Id
    private String elnevezes;
    private Integer szazalek;

    public Kedvezmenyek()
    {

    }

    public void setElnevezes(String elnevezes) { this.elnevezes = elnevezes; }
    public void setSzazalek(Integer szazalek) { this.szazalek = szazalek; }


    public String getElnevezes() {
        return elnevezes;
    }

    public Integer getSzazalek() {
        return szazalek;
    }
}
