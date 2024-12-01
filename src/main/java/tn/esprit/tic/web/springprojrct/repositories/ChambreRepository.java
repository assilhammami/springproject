package tn.esprit.tic.web.springprojrct.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.tic.web.springprojrct.entities.Chambre;
import tn.esprit.tic.web.springprojrct.entities.TypeChambre;

import java.util.List;

public interface ChambreRepository  extends JpaRepository<Chambre, Long> {
    List<Chambre> findByBlocNomBlocAndTypeC(String nom, TypeChambre D);
    List<Chambre> findByReservationsEstValide(Boolean valid);
    List<Chambre> findByBlocIdBlocAndBlocCapaciteBlocGreaterThan(Long blocId, Long capacite);

    List<Chambre> findByNumeroChambreIn(List<Long> numChambre);

    @Query("select c from Chambre c where c.bloc.nomBloc=:nomBloc and c.typeC=:typeC")
    List<Chambre> findByNomBloc(@Param("nomBloc") String nomBloc, @Param("typeC") TypeChambre typeC);


    @Query("SELECT ch FROM Chambre ch join ch.reservations cr     WHERE cr.estValide=:valid  ")
    List<Chambre> retrieveChambresByReservation(@Param("valid")  Boolean valid  );

    @Query("SELECT ch FROM Chambre ch   WHERE  ch.bloc.capaciteBloc>:capacite  and ch.bloc.nomBloc=:nom")
    List<Chambre> retrieveChambresByNomBLocAndCapacite(@Param("capacite")  Long capacite,@Param("nom") String nom);


    @Query("SELECT COUNT(c) FROM Chambre c WHERE c.typeC = :typeChambre AND c.bloc.idBloc = :idBloc")
    Long countChambresByTypeAndBloc(@Param("typeChambre") TypeChambre typeChambre, @Param("idBloc") Long idBloc);



    @Query("SELECT COUNT(c) FROM Chambre c WHERE c.typeC = :typeChambre")
    Integer nbChambreParType(@Param("typeChambre") TypeChambre typeChambre);
    @Query("SELECT COUNT(r) " +
            "FROM Chambre c " +
            "LEFT JOIN c.reservations r " +
            "WHERE c.idChambre = :idChambre " +
            "AND FUNCTION('YEAR', r.anneeUniversitaire) = FUNCTION('YEAR', CURRENT_DATE)")
    Integer findReservationCountForCurrentYearByChambreId(@Param("idChambre") Long idChambre);


}
