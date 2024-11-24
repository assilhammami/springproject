package tn.esprit.tic.web.springprojrct.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.tic.web.springprojrct.entities.Reservation;

import java.util.Date;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {
    @Query("SELECT r FROM Reservation r WHERE r.anneeUniversitaire BETWEEN :dateDebut AND :dateFin")
    List<Reservation> findReservationsByAnneeUniversitaire(Date dateDebut, Date dateFin);
}
