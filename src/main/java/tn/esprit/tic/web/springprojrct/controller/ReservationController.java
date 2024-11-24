package tn.esprit.tic.web.springprojrct.controller;

import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tic.web.springprojrct.entities.Reservation;
import tn.esprit.tic.web.springprojrct.service.ReservationService;

import java.util.Date;
import java.util.List;


    @RestController
    @AllArgsConstructor
    @RequestMapping("/reservations")
    public class ReservationController {


        ReservationService reservationService;

        @GetMapping("/between/{dateDebut}/{dateFin}")
        public List<Reservation> getReservationsBetweenDates(
                @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateDebut,
                @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateFin) {
            return reservationService.getReservationParAnneeUniversitaire(dateDebut, dateFin);
        }

}
