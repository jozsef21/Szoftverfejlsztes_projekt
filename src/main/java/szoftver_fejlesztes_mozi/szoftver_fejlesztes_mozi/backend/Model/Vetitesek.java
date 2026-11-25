package szoftver_fejlesztes_mozi.szoftver_fejlesztes_mozi.backend.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
