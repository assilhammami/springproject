package tn.esprit.tic.web.springprojrct.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.tic.web.springprojrct.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {

}
