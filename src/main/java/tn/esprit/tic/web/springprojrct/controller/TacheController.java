package tn.esprit.tic.web.springprojrct.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tic.web.springprojrct.entities.Tache;
import tn.esprit.tic.web.springprojrct.service.IEtudiantService;
import tn.esprit.tic.web.springprojrct.service.ITacheService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/tache")
public class TacheController {
    ITacheService tacheService;
    IEtudiantService etudiantService;
    @PostMapping("/add-tasks/{nomEt}/{prenomEt}")
    public ResponseEntity<List<Tache>> addTasksToEtudiant(@RequestBody List<Tache> tasks, @PathVariable String nomEt, @PathVariable String prenomEt) {
        List<Tache> savedTasks = tacheService.addTasksAndAffectToEtudiant(tasks, nomEt, prenomEt);
        return ResponseEntity.ok(savedTasks);
    }


}
