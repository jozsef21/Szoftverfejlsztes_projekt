package szoftver_fejlesztes_mozi.szoftver_fejlesztes_mozi.frontend.Alkalmazas.Controller;

public class Vetites {
    private final String film;
    private final String terem;
    private final String idopont;

    public Vetites(String film, String terem, String idopont) {
        this.film = film;
        this.terem = terem;
        this.idopont = idopont;
    }

    public String getFilm() { return film; }
    public String getTerem() { return terem; }
    public String getIdopont() { return idopont; }
}
