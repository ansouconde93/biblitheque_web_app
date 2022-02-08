package soa.gestion.livre.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Livre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String code;
    private String titre;
    private int nombrePage;
    private String dateedition;
    private int nombreexemplaire = 1;
    @OneToMany
    private List<Type> types = new ArrayList<>();
    @OneToMany
    private List<EtatLivre> etatLivres = new ArrayList<>();
}
