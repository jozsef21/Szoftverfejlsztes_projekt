package szoftver_fejlesztes_mozi.szoftver_fejlesztes_mozi.backend.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Felhasznalok {

    @Id
    private String regisztralt_nev;
    private String nev;
    private String jelszo;
}
