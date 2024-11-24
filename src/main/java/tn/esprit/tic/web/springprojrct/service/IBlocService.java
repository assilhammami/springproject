package tn.esprit.tic.web.springprojrct.service;

import org.springframework.data.repository.query.Param;
import tn.esprit.tic.web.springprojrct.entities.Bloc;

import java.util.List;

public interface IBlocService {

        List<Bloc> retrieveAllBlocs();
        Bloc addBloc(Bloc b);
        Bloc updateBloc(Bloc b);
        Bloc retrieveBloc(Long idBloc);
        void removeBloc(Long idBloc);
List<Bloc> findByFoyerUniversiteNomUniversite(String universite);
       List<Bloc>  retrieveBlocByUniversite(@Param("nom") String nom );
    Bloc affecterChambresABloc(List<Long> numChambre, String nomBloc);
    }


