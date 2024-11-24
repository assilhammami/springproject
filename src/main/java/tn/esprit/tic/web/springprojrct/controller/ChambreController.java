package tn.esprit.tic.web.springprojrct.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.tic.web.springprojrct.entities.Chambre;
import tn.esprit.tic.web.springprojrct.entities.TypeChambre;
import tn.esprit.tic.web.springprojrct.service.IChambreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping ("/chambre")
public class ChambreController {
    IChambreService chambreService;

    @GetMapping("/gett-chambre/{nomBloc}/{TypeC}")
    public List<Chambre> findByNomBloc(@PathVariable("nomBloc") String nomBloc, @PathVariable("TypeC") TypeChambre TypeC) {
        return chambreService.findByNomBloc(nomBloc, TypeC);

    }

    @GetMapping("/get-chambre/{nomBloc}/{TypeC}")
    public List<Chambre> getchambreBynombloc(@PathVariable("nomBloc") String nomBloc, @PathVariable("TypeC") TypeChambre TypeC) {
        List<Chambre> chambres = chambreService.findByBlocNomBlocAndTypeC(nomBloc, TypeC);
        return chambres;
    }

    @GetMapping("/get-valid/{valid}")
    public List<Chambre> getchambreByreservation(@PathVariable("valid") boolean valide) {
        List<Chambre> chambres = chambreService.findByReservationsEstValide(valide);
        return chambres;
    }

    @GetMapping("/get-nombloc/{blocid}/{capacite}")
    public List<Chambre> getchambreBynombloc(@PathVariable("blocid") Long blocid, @PathVariable("capacite") Long capacite) {
        List<Chambre> chambres = chambreService.findByBlocIdBlocAndBlocCapaciteBlocGreaterThan(blocid, capacite);
        return chambres;

    }
    @GetMapping("/gett-chambrevalid/{valid}")
    public List<Chambre> findByreservation(@PathVariable("valid") boolean valid) {
        return chambreService.retrieveChambresByReservation(valid);

    }
    @GetMapping("/gett-chambrecap/{capacite}/{nom}")
    public List<Chambre> findchByidBloc(@PathVariable("capacite") Long capacite, @PathVariable("nom") String nom) {
        return chambreService.retrieveChambresByNomBLocAndCapacite(capacite,nom);

    }

    @GetMapping("/getByBlocIdBlocAndBlocCapaciteBlocGreaterThan/{idBloc}/{capacite}")
    public List<Chambre> getByBlocIdBlocAndBlocCapaciteBlocGreaterThan(@PathVariable("idBloc") Long idBloc,@PathVariable("capacite") Long capacite){
        List<Chambre> chambres=chambreService.findByBlocIdBlocAndBlocCapaciteBlocGreaterThan(idBloc,capacite);
        return chambres;
    }
    @GetMapping("/nbChambreParTypeEtBloc/{type}/{idBloc}")
    public long nbChambreParTypeEtBloc(@PathVariable TypeChambre type, @PathVariable long idBloc){
        return  chambreService.nbChambreParTypeEtBloc(type,idBloc);
    }


}
