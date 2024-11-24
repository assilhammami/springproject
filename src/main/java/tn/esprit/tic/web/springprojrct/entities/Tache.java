package tn.esprit.tic.web.springprojrct.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="tache")
public class Tache {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTache;
    private LocalDate dateTache ;
    private Integer  duree;
    private float tarifHoraire;
    private TypeTache typeTache;
    @ManyToOne
    Etudiant etudiant;
    @OneToOne(mappedBy = "tache")
    private Etudiant etudiant2;


}
