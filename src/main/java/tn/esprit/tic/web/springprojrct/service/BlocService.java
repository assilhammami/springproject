package tn.esprit.tic.web.springprojrct.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tic.web.springprojrct.entities.Bloc;
import tn.esprit.tic.web.springprojrct.entities.Chambre;
import tn.esprit.tic.web.springprojrct.repositories.BlocRepository;
import tn.esprit.tic.web.springprojrct.repositories.ChambreRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class BlocService  implements IBlocService{
    BlocRepository br ;
    ChambreRepository chambreRepository ;
    @Override
    public List<Bloc> retrieveAllBlocs() {
        return br.findAll();
    }

    @Override
    public Bloc addBloc(Bloc b) {
        return br.save(b);
    }

    @Override
    public Bloc updateBloc(Bloc b) {
        return br.save(b);
    }

    @Override
    public Bloc retrieveBloc(Long idBloc) {
        return br.findById(idBloc).get();
    }

    @Override
    public void removeBloc(Long idBloc) {
        br.deleteById(idBloc);
    }

    @Override
    public List<Bloc> findByFoyerUniversiteNomUniversite(String universite) {
        return br.findByFoyerUniversiteNomUniversite(universite);
    }

    @Override
    public List<Bloc> retrieveBlocByUniversite(String nom) {
        return br.retrieveBlocByUniversite(nom);
    }

    @Override
    public Bloc affecterChambresABloc(List<Long> numChambre, String nomBloc) {
        Bloc bloc = br.findBlocByNomBloc(nomBloc);
        List<Chambre> chambres = chambreRepository.findByNumeroChambreIn(numChambre);
        for (Chambre chambre : chambres) {
            chambre.setBloc(bloc);
        }
        chambreRepository.saveAll(chambres);
        return bloc;
    }
}
