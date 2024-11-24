package tn.esprit.tic.web.springprojrct.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Table(name="etudiant")
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEtudiant;
    private String nomEtudiant;
    private String prenomEtudiant;
    private Long cin;
    private String ecole;
    private Date dateNaissance;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="etudiant")
    private Set<Tache> taches;
    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Reservation> reservations;
    @OneToOne
    private Tache tache;
    private Long montantInscription;

}




