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


    public String getElnevezes() {
        return elnevezes;
    }

    public Integer getSzazalek() {
        return szazalek;
    }
}
