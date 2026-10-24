package szoftver_fejlesztes_mozi.szoftver_fejlesztes_mozi.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Vetitesek {

    @Id
    @GeneratedValue
    private Integer ID;
    @OneToOne
    @JoinColumn(name = "filmek_id")
    private Filmek filmek_id;
    @OneToOne
    @JoinColumn(name = "termek_id")
    private Termek terem_id;
    private Date Kezdes_idopont;
    private Integer alapar;
    private String nyelv;

    public Vetitesek()
    {

    }

    public Date getKezdes_idopont() { return Kezdes_idopont;}

    public void setKezdes_idopont(Date kezdes_idopont) { Kezdes_idopont = kezdes_idopont;}

    public Integer getAlapar() { return alapar;}

    public String getNyelv() { return nyelv;}
}
