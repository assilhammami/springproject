package tn.esprit.tic.web.springprojrct.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.tic.web.springprojrct.entities.Bloc;
import tn.esprit.tic.web.springprojrct.entities.Universite;

import java.util.List;

public interface UniversiteRepository extends JpaRepository<Universite,Long> {
    Universite findByNomUniversite(String universite);
}
