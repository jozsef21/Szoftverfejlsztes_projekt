package szoftver_fejlesztes_mozi.szoftver_fejlesztes_mozi.Model;

import javax.persistence.*;

@Entity
public class Filmek {

    @Id
    private String cim;
    private String rendezo;
    private Integer kiadas_ev;
    private String mufaj;
    private String plakat;

    public Filmek() {

    }

    public String getCim() {
        return cim;
    }

    public String getRendezo() {
        return rendezo;
    }

    public Integer getKiadas_ev() {
        return kiadas_ev;
    }

    public String getMufaj() {
        return mufaj;
    }

    public String getPlakat() { return plakat; }
}
