package tn.esprit.tic.web.springprojrct.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.*;
import tn.esprit.tic.web.springprojrct.entities.Foyer;
import tn.esprit.tic.web.springprojrct.entities.Universite;
import tn.esprit.tic.web.springprojrct.service.IUniversiteService;
import tn.esprit.tic.web.springprojrct.service.UniversiteService;


@RestController
@AllArgsConstructor
@RequestMapping("/universite")
public class UniversiteController {
    IUniversiteService universiteService;

    @PutMapping("/add-foyer/{idFoyer}/{nomUniversite}")
    public Universite   affecterFoyerToUniversite(@PathVariable ("idFoyer") long idFoyer,@PathVariable ("nomUniversite") String nomUniversite){
        return  universiteService.affecterFoyerUniversite( idFoyer,  nomUniversite);
    }
    @PutMapping("/remove-foyer/{idFoyer}")
    @ResponseBody
    public Universite desaffecterFoyerToUniversite(@PathVariable("idFoyer") long idFoyer) {
        return universiteService.desaffecterFoyerAUniversite(idFoyer);
    }




}
