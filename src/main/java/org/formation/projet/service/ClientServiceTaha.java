package org.formation.projet.service;

import java.text.ParseException;
import java.util.List;

import org.formation.projet.DTO.ClientDTOTaha;
import org.formation.projet.entity.ClientTaha;
import org.formation.projet.entity.CompteCourant;
import org.formation.projet.entity.Credit;
import org.formation.projet.entity.Virement;
import org.springframework.stereotype.Service;


public interface ClientServiceTaha {

	ClientTaha findClientById(Long id);

	void addClient(ClientTaha client);

	List<ClientTaha> findAll();
	void deleteClientById(Long id);

	ClientTaha convertClientDToToClient(ClientDTOTaha clientDto) throws ParseException;

	ClientDTOTaha convertClientToClientDto(ClientTaha client);
	
	public void virement(Virement virement);

	double calculerMensualiterCredit(Credit credit);

}
