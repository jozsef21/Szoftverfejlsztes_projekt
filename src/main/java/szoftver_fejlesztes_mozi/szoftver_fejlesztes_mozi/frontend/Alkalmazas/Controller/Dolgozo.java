package szoftver_fejlesztes_mozi.szoftver_fejlesztes_mozi.frontend.Alkalmazas.Controller;

public class Dolgozo {
    private final String nev;
    private final String beosztas;

    public Dolgozo(String nev, String beosztas) {
        this.nev = nev;
        this.beosztas = beosztas;
    }

    public String getNev() { return nev; }
    public String getBeosztas() { return beosztas; }
}
