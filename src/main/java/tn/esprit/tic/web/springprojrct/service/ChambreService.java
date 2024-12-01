package tn.esprit.tic.web.springprojrct.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.tic.web.springprojrct.entities.Bloc;
import tn.esprit.tic.web.springprojrct.entities.Chambre;
import tn.esprit.tic.web.springprojrct.entities.TypeChambre;
import tn.esprit.tic.web.springprojrct.repositories.BlocRepository;
import tn.esprit.tic.web.springprojrct.repositories.ChambreRepository;

import java.util.Arrays;
import java.util.List;
@AllArgsConstructor
@Service
@Slf4j

public class ChambreService implements IChambreService {

    ChambreRepository cr;
    BlocRepository blocRepository;
    @Override
    public List<Chambre> retrieveAmmChambres() {
        return cr.findAll();
    }

    @Override
    public Chambre addChambre(Chambre ch) {
        return cr.save(ch);
    }

    @Override
    public Chambre updateChambre(Chambre ch) {
        return cr.save(ch);
    }

    @Override
    public Chambre retrieveChambre(Long idChambre) {
        return cr.findById(idChambre).get();
    }

    @Override
    public void removeChambre(Long idChambre) {
cr.deleteById(idChambre);
    }

    @Override
    public List<Chambre> findByNomBloc(String nomBloc, TypeChambre typeC) {
        return cr.findByNomBloc(nomBloc, typeC);
    }

    @Override
    public List<Chambre> findByBlocNomBlocAndTypeC(String nom, TypeChambre D) {
        return cr.findByBlocNomBlocAndTypeC(nom, D);    }

    @Override
    public List<Chambre> findByReservationsEstValide(Boolean valid) {
        return cr.findByReservationsEstValide(valid);
    }

    @Override
    public List<Chambre> findByBlocIdBlocAndBlocCapaciteBlocGreaterThan(Long blocId, Long capacity) {
        return cr.findByBlocIdBlocAndBlocCapaciteBlocGreaterThan(blocId, capacity);
    }

    @Override
    public List<Chambre> retrieveChambresByNomBLocAndCapacite(Long capacite, String nom) {
        return cr.retrieveChambresByNomBLocAndCapacite(capacite, nom);
    }

    @Override
    public List<Chambre> retrieveChambresByReservation(Boolean valid) {
        return cr.retrieveChambresByReservation(valid);
    }
    @Override
    public long nbChambreParTypeEtBloc(TypeChambre type, long idBloc) {
        return cr.countChambresByTypeAndBloc(type,idBloc);
    }




    @Scheduled(fixedRate = 60000)
    @Override
    public void listeChambreParBloc() {

        List<Bloc>blocs=blocRepository.findAll();
        blocs.forEach(bloc -> {
            log.info(bloc.getNomBloc()+"ayant capacité"+bloc.getCapaciteBloc());
            log.info("liste des chambre du bloc "+bloc.getNomBloc());

            bloc.getChambres().forEach(chambre -> {
                log.info("chabmbre numero"+chambre.getNumeroChambre()+" de type"+chambre.getTypeC());
            });

        });


    }
    @Override
    public void pourcentageChambreParTypeChambre() {
        Integer nbTotalDesChambres = cr.findAll().size();
        log.info("nombre des chambres" + nbTotalDesChambres);
        Arrays.stream(TypeChambre.values()).forEach(typeChambre -> {
            Integer nbChambreParType = cr.nbChambreParType(typeChambre);
            Double PourcentageParType = (nbChambreParType.doubleValue() / nbTotalDesChambres) * 100;
            log.info("le pourcentage des chambres par type : " + typeChambre + " est " + nbChambreParType);
        });
    }
        @Scheduled(fixedRate = 60000)
    @Override
    public void nbPlacesDisponiblesParChambreAnneeEnCours() {
        List<Chambre>chambres=cr.findAll();
        chambres.forEach(chambre -> {
            if (chambre.getTypeC().equals(TypeChambre.TRIPLE)){
                log.info("les restante en 2024 pour la chambre"+chambre.getNumeroChambre()+" est egale a "
                        +(3-cr.findReservationCountForCurrentYearByChambreId(chambre.getIdChambre())));}
            else if (chambre.getTypeC().equals(TypeChambre.DOUBLE)) {
                log.info("les restante en 2024 pour la chambre"+chambre.getNumeroChambre()+" est egale a "
                        +(2-cr.findReservationCountForCurrentYearByChambreId(chambre.getIdChambre())));}
            else log.info("les restante en 2024 pour la chambre"+chambre.getNumeroChambre()+" est egale a "
                        +(1-cr.findReservationCountForCurrentYearByChambreId(chambre.getIdChambre())));


        });

    }}


