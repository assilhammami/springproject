package tn.esprit.tic.web.springprojrct.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tic.web.springprojrct.entities.Foyer;
import tn.esprit.tic.web.springprojrct.entities.Universite;
import tn.esprit.tic.web.springprojrct.repositories.FoyerRepository;
import tn.esprit.tic.web.springprojrct.repositories.UniversiteRepository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service

public class UniversiteService implements IUniversiteService {
    UniversiteRepository universiteRepository;
    FoyerRepository fr;
    IFoyerService frService;
    @Override
    public List<Universite> retrieveAllUniversite() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite updateUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Optional<Universite> retrieveUniversite(Long idBloc) {
        return universiteRepository.findById(idBloc);
    }

    @Override
    public void removeUniversite(Long idBloc) {
        universiteRepository.deleteById(idBloc);
    }

    @Override
    public Universite affecterFoyerUniversite(long idFoyer, String nomUniversite) {
        Universite universite = universiteRepository.findByNomUniversite(nomUniversite);
        Foyer foyer = frService.retrieveFoyer(idFoyer);
        foyer.setUniversite(universite);
        fr.save(foyer);

        return universite;
    }
    @Override
    public Universite desaffecterFoyerAUniversite(long idFoyer) {
        Foyer foyer = frService.retrieveFoyer(idFoyer);
        foyer.setUniversite(null);
        fr.save(foyer);
        return foyer.getUniversite();
    }


}
