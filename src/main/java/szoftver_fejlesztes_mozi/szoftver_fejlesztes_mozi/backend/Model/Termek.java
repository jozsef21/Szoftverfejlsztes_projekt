package szoftver_fejlesztes_mozi.szoftver_fejlesztes_mozi.backend.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Termek {

    @Id
    @GeneratedValue
    private Integer ID;
    private String nev;
    private Integer sorok_szama;
    private Integer oszlopk_szama;
}
