package szoftver_fejlesztes_mozi.szoftver_fejlesztes_mozi.Model;

import javax.persistence.*;

@Entity
public class Dolgozok {
    @Id
    private Integer id;
    private String nev;
    private String munkakor;

    public Dolgozok()
    {

    }

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
