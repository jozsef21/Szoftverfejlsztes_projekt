package szoftver_fejlesztes_mozi.szoftver_fejlesztes_mozi.backend.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Filmek {

    @Id
    private String cim;
    private String rendezo;
    private Integer kiadas_ev;
    private String mufaj;
    private String plakat;
}
