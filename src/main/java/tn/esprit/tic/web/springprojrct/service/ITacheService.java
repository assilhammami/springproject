package tn.esprit.tic.web.springprojrct.service;


import tn.esprit.tic.web.springprojrct.entities.Chambre;
import tn.esprit.tic.web.springprojrct.entities.Tache;

import java.util.List;

public interface ITacheService {
    List<Tache> retrieveAllTache();
    Tache addTache(Tache tache);
    Tache updateTache(Tache tache);
    Tache retrieveTache(Long idTache);
    void removeTache(Long idTache);
    List<Tache> addTasksAndAffectToEtudiant (List<Tache> tasks, String nomEt, String prenomEt ) ;
}
