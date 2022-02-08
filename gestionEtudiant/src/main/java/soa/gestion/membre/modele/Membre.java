package soa.gestion.membre.modele;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Membre {
    private Long id;
    private String username;
    private String password;
}
