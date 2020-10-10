package dev.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import dev.controller.dto.CollegueDto;
import dev.controller.dto.CollegueInfoDto;
import dev.entites.Collegue;
import dev.exceptions.AbsenceByIdNotFound;
import dev.repository.CollegueRepo;

/**
 * 
 * @author KOMINIARZ Anaïs, SAGAN Jonathan, BATIGNES Pierre, GIRARD Vincent.
 *
 */
@Service
public class CollegueService {

	// Déclarations
	private CollegueRepo collegueRepo;

	/**
	 * Constructeur
	 *
	 * @param absenceRepository
	 */
	public CollegueService(CollegueRepo collegueRepo) {
		this.collegueRepo = collegueRepo;
	}

	/**
	 * Lister tous les collegues
	 * 
	 * @return
	 */
	public List<CollegueDto> getAllCollegues() {
		List<CollegueDto> listeCollegues = new ArrayList<>();

		for (Collegue collegue : collegueRepo.findAll()) {

			CollegueDto collegueDto = new CollegueDto();
			collegueDto.setEmail(collegue.getEmail());
			collegueDto.setNom(collegue.getNom());
			collegueDto.setPrenom(collegue.getPrenom());
			listeCollegues.add(collegueDto);

		}
		return listeCollegues;
	}

	
	public List<CollegueInfoDto> getAllInfoCollegues() {
		List<CollegueInfoDto> listeCollegues = new ArrayList<>();

		for (Collegue collegue : collegueRepo.findAll()) {

			CollegueInfoDto collegueDto = new CollegueInfoDto();
			collegueDto.setEmail(collegue.getEmail());
			collegueDto.setNom(collegue.getNom());
			collegueDto.setPrenom(collegue.getPrenom());
			collegueDto.setUrlPhoto(collegue.getUrlPhoto());
			listeCollegues.add(collegueDto);

		}
		return listeCollegues;
	}
	
	public CollegueInfoDto getInfoCollegueEmail(String email) {
		Collegue coll = collegueRepo.findByEmail(email).orElseThrow(() -> new AbsenceByIdNotFound("Erreur."));
		System.out.println(coll.getCompetences());
		CollegueInfoDto col = new CollegueInfoDto(email, coll.getNom(), coll.getPrenom(), coll.getUrlPhoto(), coll.getCompetences());
		return col;
	}
}
