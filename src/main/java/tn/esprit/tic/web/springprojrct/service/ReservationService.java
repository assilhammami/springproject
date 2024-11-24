package tn.esprit.tic.web.springprojrct.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tic.web.springprojrct.entities.Reservation;
import tn.esprit.tic.web.springprojrct.repositories.ReservationRepository;

import java.util.Date;
import java.util.List;
@Service
@AllArgsConstructor
public class ReservationService implements IReservationService {
    ReservationRepository reservationRepository;
    public List<Reservation> getReservationParAnneeUniversitaire(Date dateDebut, Date dateFin) {
        return reservationRepository.findReservationsByAnneeUniversitaire(dateDebut, dateFin);
}

}
