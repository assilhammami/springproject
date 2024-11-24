package tn.esprit.tic.web.springprojrct.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tic.web.springprojrct.entities.Chambre;
import tn.esprit.tic.web.springprojrct.entities.TypeChambre;
import tn.esprit.tic.web.springprojrct.repositories.ChambreRepository;

import java.util.List;
@AllArgsConstructor
@Service

public class ChambreService implements IChambreService {

    ChambreRepository cr;
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



}
