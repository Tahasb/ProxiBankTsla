package org.formation.projet.repository;

import org.formation.projet.entity.ClientTaha;
import org.formation.projet.entity.CompteCourantTaha;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepositoryTaha extends JpaRepository<ClientTaha, Long> {
	

}
