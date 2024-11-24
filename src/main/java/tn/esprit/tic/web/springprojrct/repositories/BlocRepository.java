package tn.esprit.tic.web.springprojrct.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import tn.esprit.tic.web.springprojrct.entities.Bloc;

import java.util.List;

public interface BlocRepository extends JpaRepository<Bloc,Long> {


List<Bloc> findByFoyerUniversiteNomUniversite(String universite);

    @Query("SELECT  b FROM Bloc b   WHERE b.foyer.universite.nomUniversite =:nom   ")
    List<Bloc> retrieveBlocByUniversite(@Param("nom") String nom);
    Bloc findBlocByNomBloc(String nomBloc);
}
