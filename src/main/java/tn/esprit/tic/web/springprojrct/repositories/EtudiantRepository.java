package tn.esprit.tic.web.springprojrct.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.tic.web.springprojrct.entities.Etudiant;

public interface EtudiantRepository  extends JpaRepository<Etudiant,Long> {
    Etudiant findByNomEtudiantAndPrenomEtudiant(String nomEt,String prenomEt);

}
