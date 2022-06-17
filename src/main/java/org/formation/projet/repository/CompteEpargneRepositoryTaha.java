package org.formation.projet.repository;

import org.formation.projet.entity.CompteCourantTaha;
import org.formation.projet.entity.CompteEpargneTaha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CompteEpargneRepositoryTaha extends JpaRepository<CompteEpargneTaha, Long> {

	@Query(value = "select * from compte_epargne_taha where id=:id", nativeQuery = true)
	CompteEpargneTaha findCompteEpargneById(Long id);
}
