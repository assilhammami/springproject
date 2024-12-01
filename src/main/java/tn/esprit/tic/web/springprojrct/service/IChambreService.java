package tn.esprit.tic.web.springprojrct.service;

import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Scheduled;
import tn.esprit.tic.web.springprojrct.entities.Chambre;
import tn.esprit.tic.web.springprojrct.entities.TypeChambre;

import java.util.List;

public interface IChambreService {




        List<Chambre> retrieveAmmChambres();
        Chambre addChambre(Chambre ch);
        Chambre updateChambre(Chambre ch);
        Chambre retrieveChambre(Long idChambre);
        void removeChambre(Long idChambre);
        List<Chambre> findByNomBloc(@Param("nomBloc") String nomBloc, @Param("typeC") TypeChambre typeC);
        List<Chambre> findByBlocNomBlocAndTypeC(String nom, TypeChambre D);
        List<Chambre> findByReservationsEstValide(Boolean valid);
        List<Chambre> findByBlocIdBlocAndBlocCapaciteBlocGreaterThan(Long blocId, Long capacite);
        List<Chambre> retrieveChambresByNomBLocAndCapacite(@Param("capacite")  Long capacite,@Param("nom") String nom);
        List<Chambre> retrieveChambresByReservation(@Param("valid")  Boolean valid  );
        long nbChambreParTypeEtBloc(TypeChambre type, long idBloc);

        void pourcentageChambreParTypeChambre();

        @Scheduled(fixedRate = 60000)
    void listeChambreParBloc();

        @Scheduled(fixedRate = 60000)
        void nbPlacesDisponiblesParChambreAnneeEnCours();

}



