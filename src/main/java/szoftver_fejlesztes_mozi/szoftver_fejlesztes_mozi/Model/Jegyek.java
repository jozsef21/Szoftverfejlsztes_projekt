package szoftver_fejlesztes_mozi.szoftver_fejlesztes_mozi.Model;

import javax.persistence.*;

@Entity
public class Jegyek {
    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "vetites_id")
    private Vetitesek vetites_id;
    @ManyToOne
    @JoinColumn(name = "regisztralt_nev")
    private Felhasznalok regisztralt_nev;
    @ManyToOne
    @JoinColumn(name = "nev")
    private Kedvezmenyek kedvezmeny_nev;
    private Integer sorszam;
    private Integer oszlopszam;
    private Integer végleges_ar;

    public Jegyek()
    {

    }

    public Integer getId() {
        return id;
    }


}
