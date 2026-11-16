package szoftver_fejlesztes_mozi.szoftver_fejlesztes_mozi.backend.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Kedvezmenyek {

    @Id
    private String elnevezes;
    private Integer szazalek;
}
