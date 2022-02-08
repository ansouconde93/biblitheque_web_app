package soa.gestion.membre.modele;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import soa.gestion.membre.entities.AppUsers;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class UserWithRoles {
    private AppUsers appUser;
    private List<String> rolesName;
}
