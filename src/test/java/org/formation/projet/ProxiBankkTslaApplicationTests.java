package org.formation.projet;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.formation.projet.entity.CompteCourant;
import org.formation.projet.repository.CompteCourantRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;


@SpringBootTest
class ProxiBankkTslaApplicationTests {

	@Autowired
	private CompteCourantRepository  compteCourantRepository; 
	
	@Test
	void contextLoads() {
		CompteCourant compteCourant = compteCourantRepository.findByNumeroCompte("CCP2754");
		
		assertNotNull(compteCourant);
	}
	


}
