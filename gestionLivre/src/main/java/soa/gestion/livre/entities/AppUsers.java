package soa.gestion.livre.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class AppUsers {
    @Id
    private Long id;

    @OneToMany
    private List<Emprunt> emprunts = new ArrayList<>();
}
