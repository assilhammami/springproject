package tn.esprit.tic.web.springprojrct.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.tic.web.springprojrct.entities.Tache;

import java.time.LocalDate;

public interface TacheRepository extends JpaRepository<Tache,Long> {
    @Query("SELECT SUM(t.tarifHoraire*t.duree) FROM Tache t WHERE t.dateTache BETWEEN :startDate AND :endDate and t.etudiant.idEtudiant= :idEtu")
    float calculateTotalTarifHoraireBetweenDates(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate, @Param("idEtu")Long idEtu);
}
