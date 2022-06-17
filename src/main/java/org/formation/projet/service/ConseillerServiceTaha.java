package org.formation.projet.service;

import java.util.List;
import java.util.Optional;

import org.formation.projet.entity.ConseillerTaha;
import org.formation.projet.repository.ConseillerRepositoryTaha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ConseillerServiceTaha {
	@Autowired
	ConseillerRepositoryTaha conseillerRepository;

	public void save(ConseillerTaha conseiller) {
		conseillerRepository.save(conseiller);
	}
	
	 public Iterable<ConseillerTaha> listConseillers(){
		 System.out.println(conseillerRepository.findAll());
		 return (conseillerRepository.findAll());
		 
	 }

	public void deleteById(Long id) {
		conseillerRepository.deleteById(id);
	}


	public boolean checkConseiller(Long id) {
		if (conseillerRepository.existsById(id)){
			return true;
		}
		return false;
	}

	public void editConseiller(long id,  ConseillerTaha conseiller) {
		
		conseillerRepository.findById(conseiller.getId()).get().setId(id);
		
		
		conseillerRepository.findById(id).get().setNom(conseiller.getNom());
		conseillerRepository.findById(id).get().setPrenom(conseiller.getPrenom());
		
	}
	
	

//		@Autowired
//	   ClientRepository clientRepository;
//
//	public ClientService(ClientRepository clientRepository) {
//		
//		this.clientRepository = clientRepository;
//	}
//
//	public void save(Client client) {
//		clientRepository.save(client);
//
//	}
//
//	public ClientService() {
//		super();
//	}
//	
//	

}
