package szoftver_fejlesztes_mozi.szoftver_fejlesztes_mozi.backend.Model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Vetitesek {

    @Id
    @GeneratedValue
    private Integer ID;
    @ManyToOne
    @JoinColumn(name = "filmek_id")
    private Filmek filmek_id;
    @ManyToOne
    @JoinColumn(name = "termek_id")
    private Termek terem_id;
    private Date Kezdes_idopont;
    private Integer alapar;

    public Vetitesek()
    {


    }

    public Integer getID() { return ID; }
    public void setID(Integer ID) { this.ID = ID; }
    public Filmek getFilmek_id() { return filmek_id; }
    public void setFilmek_id(Filmek filmek_id) { this.filmek_id = filmek_id; }
    public Termek getTerem_id() { return terem_id; }
    public void setTerem_id(Termek terem_id) { this.terem_id = terem_id; }
    public void setAlapar(Integer alapar) { this.alapar = alapar; }
    public void setNyelv(String nyelv) { this.nyelv = nyelv; }

    public Date getKezdes_idopont() { return Kezdes_idopont;}

    public void setKezdes_idopont(Date kezdes_idopont) { Kezdes_idopont = kezdes_idopont;}

    public Integer getAlapar() { return alapar;}
}
