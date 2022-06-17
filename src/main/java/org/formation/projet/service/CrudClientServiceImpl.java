package org.formation.projet.service;

import java.util.Optional;

import org.formation.projet.entity.Client;
import org.formation.projet.entity.Virement;
import org.formation.projet.repository.ClientRepository;
import org.formation.projet.repository.CompteCourantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CrudClientServiceImpl implements ICrudServiceClient {

	@Autowired
	ClientRepository ClientRepository;

	@Autowired
	CompteCourantRepository compteCourantRepository;

	@Override
	public void save(Client client) {
		if (client.getCompteCourant() != null) {
			client.getCompteCourant().setNumeroCompte("CCP" + generateUID());
		}
		if (client.getCompteEpargne() != null) {
			client.getCompteEpargne().setNumeroCompte("CEP" + generateUID());

		}
		ClientRepository.save(client);
	}

	@Override
	public Iterable<Client> listClients() {
		return (ClientRepository.findAll());

	}

	@Override
	public void deleteById(Long id) {
		ClientRepository.deleteById(id);
	}

	@Override
	public boolean checkClient(Long id) {
		if (ClientRepository.existsById(id)) {
			return true;
		}
		return false;
	}

	@Override
	public void editClient(long id, Client client) {

		ClientRepository.findById(client.getId()).get().setId(id);

		ClientRepository.findById(id).get().setNom(client.getNom());
		ClientRepository.findById(id).get().setPrenom(client.getPrenom());

	}

	@Override
	public Optional<Client> getClientbyId(Long id) {
		return ClientRepository.findById(id);

	}

	private static String generateUID() {
		return String.valueOf(Math.round(Math.random() * 10000));

	}

	@Override
	public void virement(Virement virement) {
		double solde_debi = compteCourantRepository.findByNumeroCompte(virement.getNumeroCompteDebit()).getSolde();
		double new_solde = solde_debi - virement.getMontant();
		System.err.println("Le montant du compte debiteur est" + new_solde);
		compteCourantRepository.findByNumeroCompte(virement.getNumeroCompteDebit()).setSolde(new_solde);

		System.err.println("Le num de compte débité"
				+ compteCourantRepository.findByNumeroCompte(virement.getNumeroCompteDebit()).getSolde());

		double solde_credit = compteCourantRepository.findByNumeroCompte(virement.getNumeroCompteCredit()).getSolde();
		new_solde = solde_credit + virement.getMontant();
		compteCourantRepository.findByNumeroCompte(virement.getNumeroCompteCredit()).setSolde(new_solde);
		System.err.println("Le solde de compte credité"
				+ compteCourantRepository.findByNumeroCompte(virement.getNumeroCompteCredit()).getSolde());

	}

}
