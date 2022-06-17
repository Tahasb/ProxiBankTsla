package org.formation.projet.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.formation.projet.DTO.ClientDTOTaha;
import org.formation.projet.entity.ClientTaha;
import org.formation.projet.entity.CompteCourantTaha;
import org.formation.projet.entity.CompteEpargneTaha;
import org.formation.projet.repository.ClientRepositoryTaha;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpTaha implements ClientServiceTaha {

	ClientRepositoryTaha clientRepository;

	public ClientServiceImpTaha(ClientRepositoryTaha clientRepository) {

		this.clientRepository = clientRepository;
	}

	@Override
	public ClientTaha findClientById(Long id) {

		Optional<ClientTaha> optionalClient = clientRepository.findById(id);
		if (optionalClient.isPresent()) {
			return optionalClient.get();
		}
		return null;
	}

	@Override
	public void addClient(ClientTaha client) {
		clientRepository.save(client);

	}

	@Override
	public List<ClientTaha> findAll() {
		return clientRepository.findAll();
	}

	@Override
	public void deleteClientById(Long id) {
		clientRepository.deleteById(id);
	}

	@Override
	public ClientTaha convertClientDToToClient(ClientDTOTaha clientDto) throws ParseException {
		ClientTaha client = new ClientTaha();
		client.setAdresse(clientDto.getAdresse());
		client.setNom(clientDto.getNom());
		client.setEmail(clientDto.getEmail());
		client.setPrenom(clientDto.getPrenom());

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = formatter.parse(clientDto.getDate());
		client.setDate(date);

		if (clientDto.getCompteCourant()) {

			CompteCourantTaha cr = new CompteCourantTaha();
			cr.setDateOuverture(clientDto.getDate());
			cr.setDecouvert(50000D);
			cr.setNumeroCompte(423432L);
			cr.setSolde(0D);
			cr.setVip(false);

			client.setCompteCourant(cr);
		}

		if (clientDto.getCompteEpargne()) {

			CompteEpargneTaha ce = new CompteEpargneTaha();
			ce.setDateOuverture(clientDto.getDate());
			ce.setTauxRem(3D);
			ce.setNumeroCompte(423432L);
			ce.setSolde(0D);
			ce.setVip(false);

			client.setCompteEpargne(ce);
		}

		return client;
	}

	@Override
	public ClientDTOTaha convertClientToClientDto(ClientTaha client) {
		ClientDTOTaha clientDto = new ClientDTOTaha();
		clientDto.setAdresse(client.getAdresse());
		clientDto.setEmail(client.getEmail());
		clientDto.setNom(client.getNom());
		clientDto.setPrenom(client.getPrenom());
		clientDto.setId(client.getId());
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String strDate = dateFormat.format(client.getDate());
		clientDto.setDate(strDate);

		if (client.getCompteCourant() != null) {
			clientDto.setCompteCourant(true);
		}
		if (client.getCompteEpargne() != null) {
			clientDto.setCompteEpargne(true);

		}

		return clientDto;

	}

}
