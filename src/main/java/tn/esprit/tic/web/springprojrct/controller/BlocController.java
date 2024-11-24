package tn.esprit.tic.web.springprojrct.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tic.web.springprojrct.entities.Bloc;
import tn.esprit.tic.web.springprojrct.service.IBlocService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/bloc")
public class BlocController {

    IBlocService blocService;

    @PostMapping("/addbloc")
    public ResponseEntity<Bloc> createbloc(@RequestBody Bloc bloc) {
        Bloc blocSaved = blocService.addBloc(bloc);
        return new ResponseEntity<>(blocSaved, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Bloc>> getAllBloc() {
        List<Bloc> blocs = blocService.retrieveAllBlocs();
        return new ResponseEntity<>(blocs, HttpStatus.OK);
    }

    @PutMapping("update")
    public ResponseEntity<Bloc> updateblocs(@RequestBody Bloc bloc) {
        Bloc blocupdated = blocService.updateBloc(bloc);
        return new ResponseEntity<>(blocupdated, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public void deletBloc(@PathVariable Long id) {
        blocService.removeBloc(id);
    }

    @GetMapping("/getBlocByUniversite/{nomUniversite}")
    public List<Bloc> getBlocByUniversite(@PathVariable("nomUniversite") String nomUniversite) {
        List<Bloc> blocs = blocService.findByFoyerUniversiteNomUniversite(nomUniversite);
        return blocs;
    }

    @GetMapping("/gett-bloc/{nomUniversite}")
    public List<Bloc> retrieveBlocByUniversite(@PathVariable("nomUniversite") String nomUniversite) {
        return blocService. retrieveBlocByUniversite(nomUniversite);

    }
    @PutMapping("/affecter/{numChambre}/{nomBloc}")
    public Bloc affecterChambresABloc(@PathVariable List<Long> numChambre, @PathVariable String nomBloc) {
        return blocService.affecterChambresABloc(numChambre,nomBloc);
    }

}


