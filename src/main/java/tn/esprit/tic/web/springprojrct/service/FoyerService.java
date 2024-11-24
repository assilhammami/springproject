package tn.esprit.tic.web.springprojrct.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tic.web.springprojrct.entities.Foyer;
import tn.esprit.tic.web.springprojrct.repositories.BlocRepository;
import tn.esprit.tic.web.springprojrct.repositories.FoyerRepository;

import java.util.List;
@AllArgsConstructor
@Service

public class FoyerService implements IFoyerService{



    FoyerRepository foyerRepository;
    BlocRepository blocRepository;


    @Override
    public List<Foyer> retrieveAmmFoyers() {
        return foyerRepository.findAll();
    }

    @Override
    public Foyer addFoyer(Foyer f) {
        return foyerRepository.save(f);
    }

    @Override
    public Foyer updateFoyer(Foyer f) {
        return foyerRepository.save(f);
    }

    @Override
    public Foyer retrieveFoyer(Long idFoyer) {
        return foyerRepository.findById(idFoyer).get();
    }

    @Override
    public void removeFoyer(Long idFoyer) {
   foyerRepository.deleteById(idFoyer);
    }
    @Override
    public Foyer addFoyerWithBloc(Foyer f) {
        if (f.getBlocs() != null) {
            // Associer chaque bloc au foyer
            f.getBlocs().forEach(bloc -> {
                        bloc.setFoyer(f);
                        blocRepository.save(bloc);
                    }


            );}


            System.out.println(f.getBlocs());
            // Sauvegarder le foyer (et ses blocs grâce au cascade)
            return foyerRepository.save(f);

        }
    }
