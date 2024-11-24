package tn.esprit.tic.web.springprojrct.service;


import tn.esprit.tic.web.springprojrct.entities.Etudiant;

import java.util.HashMap;
import java.util.List;

public interface IEtudiantService {

    List<Etudiant> retrieveAllEtudiant();
    Etudiant addEtudiant(Etudiant et);
    Etudiant updateEtudiant(Etudiant et);
    Etudiant retrieveEtudiant(Long idEtudiant);
    void removeEtudiant(Long idEtudiant);
     Etudiant affecterEtudiantAReservation(String nomEt, String prenomEt, Long idReservation);
    HashMap<String,Float > calculNouveauMontantInscriptionDesEtudiants() ;

}
