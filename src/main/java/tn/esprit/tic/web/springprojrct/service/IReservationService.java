package tn.esprit.tic.web.springprojrct.service;

import tn.esprit.tic.web.springprojrct.entities.Reservation;

import java.util.Date;
import java.util.List;

public interface IReservationService {
     List<Reservation> getReservationParAnneeUniversitaire(Date dateDebut, Date dateFin);
}
