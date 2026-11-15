package szoftver_fejlesztes_mozi.szoftver_fejlesztes_mozi.backend.Model;

import jakarta.persistence.*;

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

    public void setCim(String cim) { this.cim = cim; }
    public void setRendezo(String rendezo) { this.rendezo = rendezo; }
    public void setKiadas_ev(Integer kiadas_ev) { this.kiadas_ev = kiadas_ev; }
    public void setMufaj(String mufaj) { this.mufaj = mufaj; }
    public void setPlakat(String plakat) { this.plakat = plakat; }

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
