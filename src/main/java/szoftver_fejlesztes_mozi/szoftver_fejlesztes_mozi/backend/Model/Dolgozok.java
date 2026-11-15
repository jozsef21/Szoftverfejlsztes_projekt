package szoftver_fejlesztes_mozi.szoftver_fejlesztes_mozi.backend.Model;

import jakarta.persistence.*;

@Entity
public class Dolgozok {
    @Id
    private Integer id;
    private String nev;
    private String munkakor;

    public Dolgozok()
    {

    }

    public void setId(Integer id) { this.id = id; }
    public void setNev(String nev) { this.nev = nev; }

    public Integer getId() {
        return id;
    }


    public String getNev() {
        return nev;
    }

    public String getMunkakor() {
        return munkakor;
    }

    public void setMunkakor(String munkakor) {
        this.munkakor = munkakor;
    }
}
