package org.formation.projet.repository;

import org.formation.projet.entity.CompteEpargne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteEpargneRepository extends JpaRepository<CompteEpargne, Long> {

	CompteEpargne findByNumeroCompte(String numeroCompte);

}
