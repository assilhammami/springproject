package tn.esprit.tic.web.springprojrct.service;

import lombok.AllArgsConstructor;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;
import tn.esprit.tic.web.springprojrct.entities.Etudiant;
import tn.esprit.tic.web.springprojrct.entities.Tache;
import tn.esprit.tic.web.springprojrct.repositories.EtudiantRepository;
import tn.esprit.tic.web.springprojrct.repositories.TacheRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class TacheService implements ITacheService{
    TacheRepository tacheRepository;
    EtudiantRepository etudiantRepository;
    @Override
    public List<Tache> retrieveAllTache() {
        return tacheRepository.findAll();
    }

    @Override
    public Tache addTache(Tache tache) {
        return tacheRepository.save(tache);
    }

    @Override
    public Tache updateTache(Tache tache) {
        return tacheRepository.save(tache);
    }

    @Override
    public Tache retrieveTache(Long idTache) {
        return tacheRepository.findById(idTache).get();
    }

    @Override
    public void removeTache(Long idTache) {
        tacheRepository.deleteById(idTache);
    }

    @Override
    public List<Tache> addTasksAndAffectToEtudiant(List<Tache> tasks, String nomEt, String prenomEt) {
        Etudiant etudiant = etudiantRepository.findByNomEtudiantAndPrenomEtudiant(nomEt, prenomEt);

        // Associer chaque tâche à l'étudiant
        tasks.forEach(task -> {
            task.setEtudiant(etudiant);
        });
        System.out.println(etudiant.getTaches());

        return tacheRepository.saveAll(tasks);
    }

}