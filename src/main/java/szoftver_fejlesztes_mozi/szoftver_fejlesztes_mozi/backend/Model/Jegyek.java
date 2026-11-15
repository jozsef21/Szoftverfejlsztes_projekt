package szoftver_fejlesztes_mozi.szoftver_fejlesztes_mozi.backend.Model;

import jakarta.persistence.*;

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
    public Vetitesek getVetites_id() { return vetites_id; }
    public void setVetites_id(Vetitesek vetites_id) { this.vetites_id = vetites_id; }
    public Felhasznalok getRegisztralt_nev() { return regisztralt_nev; }
    public void setRegisztralt_nev(Felhasznalok regisztralt_nev) { this.regisztralt_nev = regisztralt_nev; }
    public Kedvezmenyek getKedvezmeny_nev() { return kedvezmeny_nev; }
    public void setKedvezmeny_nev(Kedvezmenyek kedvezmeny_nev) { this.kedvezmeny_nev = kedvezmeny_nev; }
    public Integer getSorszam() { return sorszam; }
    public void setSorszam(Integer sorszam) { this.sorszam = sorszam; }
    public Integer getOszlopszam() { return oszlopszam; }
    public void setOszlopszam(Integer oszlopszam) { this.oszlopszam = oszlopszam; }
    public Integer getVégleges_ar() { return végleges_ar; }
    public void setVégleges_ar(Integer végleges_ar) { this.végleges_ar = végleges_ar; }

}
