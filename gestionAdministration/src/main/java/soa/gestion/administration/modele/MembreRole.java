package soa.gestion.administration.modele;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class MembreRole {
    private Long idMembre;
    private Long idRole;
}
