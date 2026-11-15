package szoftver_fejlesztes_mozi.szoftver_fejlesztes_mozi.backend;

public class Titkosito {

    private static final int ELTOLAS = 8;

    public static String titkosit(String szoveg) {
        return eltol(szoveg, ELTOLAS);
    }

    public static String visszafejt(String szoveg) {
        return eltol(szoveg, -ELTOLAS);
    }

    private static String eltol(String szoveg, int n) {
        StringBuilder sb = new StringBuilder();
        for (char c : szoveg.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                sb.append((char) ('a' + (c - 'a' + n % 26 + 26) % 26));
            } else if (c >= 'A' && c <= 'Z') {
                sb.append((char) ('A' + (c - 'A' + n % 26 + 26) % 26));
            } else {
                sb.append(c); // számok és egyéb karakterek változatlanok
            }
        }
        return sb.toString();
    }
}