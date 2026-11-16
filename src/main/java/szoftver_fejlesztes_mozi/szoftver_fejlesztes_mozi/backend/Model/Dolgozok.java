package szoftver_fejlesztes_mozi.szoftver_fejlesztes_mozi.backend.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Dolgozok {
    @Id
    @GeneratedValue
    private Integer id;
    private String nev;
    private String munkakor;
}
