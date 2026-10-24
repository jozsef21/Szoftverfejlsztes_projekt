package szoftver_fejlesztes_mozi.szoftver_fejlesztes_mozi.Model;

import javax.persistence.*;

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
