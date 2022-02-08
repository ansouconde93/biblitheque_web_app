package soa.gestion.administration.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Membre {
    @Id
    private Long id;

    @ManyToMany
    private List<Roles> roles = new ArrayList<>();
}
