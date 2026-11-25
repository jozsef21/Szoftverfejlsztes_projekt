package szoftver_fejlesztes_mozi.szoftver_fejlesztes_mozi.backend.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Dolgozok {
    @Id
    @GeneratedValue
    private Integer id;
    private String nev;
    private String munkakor;
}
