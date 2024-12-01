package tn.esprit.tic.web.springprojrct.service;

import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.tic.web.springprojrct.entities.Etudiant;
import tn.esprit.tic.web.springprojrct.entities.Reservation;
import tn.esprit.tic.web.springprojrct.repositories.EtudiantRepository;
import tn.esprit.tic.web.springprojrct.repositories.ReservationRepository;
import tn.esprit.tic.web.springprojrct.repositories.TacheRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@AllArgsConstructor
@Service
public class EtudiantService implements IEtudiantService {
    EtudiantRepository etr;
    ReservationRepository reservationRepository;
    TacheRepository tacheRepository;
    @Override
    public List<Etudiant> retrieveAllEtudiant() {
        return etr.findAll();
    }

    @Override
    public Etudiant addEtudiant(Etudiant et) {
        return  etr.save(et);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant et) {
        return etr.save(et);
    }

    @Override
    public Etudiant retrieveEtudiant(Long idEtudiant) {
        return etr.findById(idEtudiant).get();
    }

    @Override
    public void removeEtudiant(Long idEtudiant) {
etr.deleteById(idEtudiant);
    }
    @Override
    public Etudiant affecterEtudiantAReservation(String nomEt, String prenomEt, Long idReservation) {
        Reservation reservation=reservationRepository.findById(idReservation).get();
        Etudiant etudiant=etr.findByNomEtudiantAndPrenomEtudiant(nomEt,prenomEt);
        List<Reservation> reservations=new ArrayList<>();
        if(etudiant.getReservations()!=null){
            reservations=etudiant.getReservations();
        }
        reservations.add(reservation);
        etudiant.setReservations(reservations);
        etr.save(etudiant);
        return etudiant;
    }
    @Override
    public HashMap<String, Float> calculNouveauMontantInscriptionDesEtudiants() {
        List<Etudiant> etudidants = etr.findAll();
        HashMap<String,Float> result=new HashMap<>();
        etudidants.forEach(etudiant -> {
            String nom = etudiant.getNomEtudiant();
            String prenom = etudiant.getPrenomEtudiant();
            LocalDate datedebut = LocalDate.of(LocalDate.now().getYear(), 1, 1);
            LocalDate datefin = LocalDate.of(LocalDate.now().getYear(), 12,31);
            float tarif=   tacheRepository.calculateTotalTarifHoraireBetweenDates(datedebut,datefin,etudiant.getIdEtudiant());
            result.put(nom+prenom,etudiant.getMontantInscription()-tarif);

        });
        return result;
    }

    @Override
    public HashMap<String, Float> calculNouveauMontantInscriptionDesEtudiantss() {
        List<Etudiant> etudidants = etr.findAll();
        HashMap<String,Float> result=new HashMap<>();
        etudidants.forEach(etudiant -> {
            String nom = etudiant.getNomEtudiant();
            String prenom = etudiant.getPrenomEtudiant();
            LocalDate datedebut = LocalDate.of(2024, 6, 6);
            LocalDate datefin = LocalDate.of(2025, 6, 6);
            float tarif=   tacheRepository.calculateTotalTarifHoraireBetweenDates(datedebut,datefin,etudiant.getIdEtudiant());
            result.put(nom+prenom,etudiant.getMontantInscription()-tarif);
            etudiant.setMontantInscription((long) (etudiant.getMontantInscription()-tarif));
            etr.save(etudiant);

        });

        return result;
    }


}
