package org.formation.projet.repository;

import org.formation.projet.entity.CompteCourant;
import org.formation.projet.entity.CompteCourantTaha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CompteCourantRepositoryTaha extends JpaRepository<CompteCourantTaha, Long> {

	@Query(value = "select * from compte_courant_taha where id=:id", nativeQuery = true)
	CompteCourantTaha findCompteCourantById(Long id);
	CompteCourantTaha findByNumeroCompte(Long numeroCompte);
}