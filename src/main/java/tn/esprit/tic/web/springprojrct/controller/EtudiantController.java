package tn.esprit.tic.web.springprojrct.controller;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tic.web.springprojrct.entities.Etudiant;
import tn.esprit.tic.web.springprojrct.service.IEtudiantService;

import java.util.HashMap;
import java.util.List;

@AllArgsConstructor
@RestController

@RequestMapping("/etudiant")
public class EtudiantController {
    IEtudiantService etudiantService;

    @GetMapping("/retrieve-all-etudiants")
    public List<Etudiant> getEtudiants() {
        List<Etudiant> listEtudiants = etudiantService.retrieveAllEtudiant();
        return listEtudiants;
    }

    @GetMapping("/retrieve-etudiant/{etudiant-id}")
    public Etudiant retrieveEtudiant(@PathVariable("etudiant-id") Long etudiantId) {
        return etudiantService.retrieveEtudiant(etudiantId);
    }

    @PostMapping("/add-etudiant")
    public Etudiant addEtudiant(@RequestBody Etudiant e) {
        Etudiant etudiant = etudiantService.addEtudiant(e);
        return etudiant;
    }

    @DeleteMapping("/remove-etudiant/{etudiant-id}")
    public void removeEtudiant(@PathVariable("etudiant-id") Long etudiantId) {
        etudiantService.removeEtudiant(etudiantId);
    }

    @PutMapping("/update-etudiant")
    public Etudiant updateEtudiant(@RequestBody Etudiant e) {
        Etudiant etudiant= etudiantService.updateEtudiant(e);
        return etudiant;
    }
    @PutMapping("/affecter/{nomEt}/{prenomEt}/{idReservation}")
    public Etudiant affecterEtudiantAReservation(@PathVariable String nomEt, @PathVariable String prenomEt,@PathVariable Long idReservation){
        return etudiantService.affecterEtudiantAReservation(nomEt,prenomEt,idReservation);
    }
    @PostMapping("/calcul")
    public HashMap<String, Float> calculNouveauMontantInscriptionDesEtudiants(){

        return etudiantService.calculNouveauMontantInscriptionDesEtudiants();
    }

}



