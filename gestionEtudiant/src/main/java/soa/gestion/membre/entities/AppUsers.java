package soa.gestion.membre.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class AppUsers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String matricule;
    private String nom;
    private String prenom;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String password;
    @Column(unique = true)
    private String telephone;
    private String section;
}
