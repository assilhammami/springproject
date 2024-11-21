package tn.esprit.tic.web.springprojrct.service;

import tn.esprit.tic.web.springprojrct.entities.Foyer;

import java.util.List;

public interface IFoyerService
{
    List<Foyer> retrieveAmmFoyers();
    Foyer addFoyer(Foyer f);
    Foyer updateFoyer(Foyer f);
    Foyer retrieveFoyer(Long idFoyer);
    void removeFoyer(Long idFoyer);
    Foyer addFoyerWithBloc(Foyer f);
}
