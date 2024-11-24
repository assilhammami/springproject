package tn.esprit.tic.web.springprojrct.service;



import tn.esprit.tic.web.springprojrct.entities.Universite;

import java.util.List;
import java.util.Optional;

public interface IUniversiteService {
    List<Universite> retrieveAllUniversite();
    Universite updateUniversite(Universite u);
    Optional<Universite> retrieveUniversite(Long idBloc);
    void removeUniversite(Long idBloc);
    Universite affecterFoyerUniversite(long idFoyer, String nomUniversite);
    Universite desaffecterFoyerAUniversite(long idFoyer);
}
