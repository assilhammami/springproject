package tn.esprit.tic.web.springprojrct.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.tic.web.springprojrct.entities.Foyer;

public interface FoyerRepository extends JpaRepository<Foyer,Long> {
    Foyer findByNomFoyerAndCapaciteFoyer(String nomFoyer , Long capacite);

}
