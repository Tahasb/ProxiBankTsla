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
import org.formation.projet.entity.Credit;
import org.formation.projet.entity.Virement;
import org.formation.projet.repository.ClientRepositoryTaha;
import org.formation.projet.repository.CompteCourantRepository;
import org.formation.projet.repository.CompteCourantRepositoryTaha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpTaha implements ClientServiceTaha {

	ClientRepositoryTaha clientRepository;

	@Autowired
	CompteCourantRepositoryTaha compteCourantRepositoryTaha;

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
			cr.setNumeroCompte(generateUID());

			if (cr.getSolde() != null) {

			} else {
				cr.setSolde(0D);
			}
			cr.setVip(false);

			client.setCompteCourant(cr);
		}

		if (clientDto.getCompteEpargne()) {

			CompteEpargneTaha ce = new CompteEpargneTaha();
			ce.setDateOuverture(clientDto.getDate());
			ce.setTauxRem(3D);

			ce.setNumeroCompte(generateUID());

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

	@Override
	public void virement(Virement virement) {
		double solde_debi = compteCourantRepositoryTaha.findByNumeroCompte(virement.getNumeroCompteDebit()).getSolde();
		double new_solde = solde_debi - virement.getMontant();
		System.err.println("Le montant du compte debiteur est" + new_solde);
		compteCourantRepositoryTaha.findByNumeroCompte(virement.getNumeroCompteDebit()).setSolde(new_solde);

		compteCourantRepositoryTaha
				.save(compteCourantRepositoryTaha.findByNumeroCompte(virement.getNumeroCompteDebit()));

		System.err.println("Le num de compte débité"
				+ compteCourantRepositoryTaha.findByNumeroCompte(virement.getNumeroCompteDebit()).getSolde());

		double solde_credit = compteCourantRepositoryTaha.findByNumeroCompte(virement.getNumeroCompteCredit())
				.getSolde();
		new_solde = solde_credit + virement.getMontant();

		compteCourantRepositoryTaha.findByNumeroCompte(virement.getNumeroCompteCredit()).setSolde(new_solde);
		compteCourantRepositoryTaha
				.save(compteCourantRepositoryTaha.findByNumeroCompte(virement.getNumeroCompteCredit()));

		System.err.println("Le solde de compte credité"
				+ compteCourantRepositoryTaha.findByNumeroCompte(virement.getNumeroCompteCredit()).getSolde());

	}

	private static Long generateUID() {
		return Long.valueOf(Math.round(Math.random() * 10000));

	}

	@Override
	public double calculerMensualiterCredit(Credit credit) {
		double t = credit.getTaux() / 100;
		double t1 = credit.getMontant() * t / 12;
		double t2 = 1 - Math.pow(1 + t / 12, -credit.getDuree());
		double mensualite = t1 / t2;
		return mensualite;
	}

}
