package dev.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.controller.dto.AbsenceVisualisationDto;
import dev.controller.dto.CompetenceDto;
import dev.controller.dto.JourFermeVisualisationDto;
import dev.controller.dto.CompetenceDto;
import dev.entites.Absence;
import dev.entites.Collegue;
import dev.entites.Competence;
import dev.entites.JourFerme;
import dev.entites.Statut;
import dev.entites.TypeJourFerme;
import dev.exceptions.AbsenceByIdNotFound;
import dev.exceptions.CollegueAuthentifieNonRecupereException;
import dev.exceptions.CommentaireManquantJourFerieException;
import dev.exceptions.CompetenceByIdNotFound;
import dev.exceptions.DateDansLePasseException;
import dev.exceptions.RttEmployeurUnWeekEndException;
import dev.exceptions.SaisieJourFerieUnJourDejaFerieException;
import dev.repository.CollegueRepo;
import dev.repository.CompetenceRepo;

@Service
public class CompetenceService {

	// Déclarations
	private CompetenceRepo competenceRepository;
	private CollegueRepo collegueRepository;


	public CompetenceService(CompetenceRepo competenceRepository, CollegueRepo collegueRepository) {
		this.competenceRepository = competenceRepository;
		this.collegueRepository = collegueRepository;
	}

	/**
	 * LISTE DES COMPETENCES
	 */
	public List<CompetenceDto> listerCompetences() {

		List<CompetenceDto> listeCompetences = new ArrayList<>();

		for (Competence competence : competenceRepository.findAll()) {

				CompetenceDto competenceDto = new CompetenceDto(competence.getId(), competence.getAdresseIcone(), competence.getLibelle(), competence.getDescription());

				listeCompetences.add(competenceDto);
			
		}
		return listeCompetences;
	}
	
	/**
	 * 
	 * DETAIL COMPETENCE PAR ID
	 */
	
	public CompetenceDto getCompetenceParId(Integer id) {
		Competence competence = competenceRepository.findById(id).orElseThrow(() -> new CompetenceByIdNotFound("Aucune competence ne correspond à cet id."));
		
		CompetenceDto cpt = new CompetenceDto(id, competence.getAdresseIcone(), competence.getLibelle(), competence.getDescription());
		
		return cpt;
	}
	
	
	@Transactional
	public CompetenceDto postCompetence(@Valid CompetenceDto competenceDto) {

		Competence competence = new Competence(competenceDto.getAdresseIcone(), competenceDto.getLibelle(), competenceDto.getDescription());
		this.competenceRepository.save(competence);
		return new CompetenceDto(competenceDto.getId(),competenceDto.getAdresseIcone(), competenceDto.getLibelle(), competenceDto.getDescription());
		
	}
	
	/**
	 * MODIFIER COMPETENCE
	 * 
	 */
	public CompetenceDto putCompetence(@Valid CompetenceDto competenceDto, Integer id) {
		CompetenceDto competence = this.getCompetenceParId(id);

		competence.setAdresseIcone(competenceDto.getAdresseIcone());
		competence.setLibelle(competenceDto.getLibelle());
		competence.setDescription(competenceDto.getDescription());

		Competence comp = new Competence(competence.getAdresseIcone(), competence.getLibelle(), competence.getDescription());
		comp.setId(competence.getId());

		this.competenceRepository.save(comp);
		return competence;
	}

}
