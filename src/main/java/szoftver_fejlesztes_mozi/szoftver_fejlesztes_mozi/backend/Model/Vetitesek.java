package szoftver_fejlesztes_mozi.szoftver_fejlesztes_mozi.backend.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
public class Vetitesek {
    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "filmek_id")
    private Filmek filmek_id;
    @ManyToOne
    @JoinColumn(name = "termek_id")
    private Termek terem_id;
    private LocalDateTime Kezdes_idopont;
    private Integer alapar;
}
