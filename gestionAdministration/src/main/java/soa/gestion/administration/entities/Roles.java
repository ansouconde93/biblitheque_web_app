package soa.gestion.administration.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String role;
    private boolean susppendu = false; // = true si le role est susppendu et false sinon

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Autorisations> autorisations = new ArrayList<>();
}
