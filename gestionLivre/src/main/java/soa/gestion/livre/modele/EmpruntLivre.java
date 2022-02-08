package soa.gestion.livre.modele;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class EmpruntLivre {
    private Long idappuser;
    private Long idlivre;
}
