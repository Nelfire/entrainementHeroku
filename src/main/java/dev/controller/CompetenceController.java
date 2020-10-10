/**
 * 
 */
package dev.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.controller.dto.CompetenceDto;
import dev.controller.dto.JourFermeVisualisationDto;
import dev.controller.dto.MessageAjoutDto;
import dev.controller.dto.MessageDto;
import dev.services.CompetenceService;

@RestController
@RequestMapping("competences")
public class CompetenceController {

	// Déclarations
	private CompetenceService competenceService;


	public CompetenceController(CompetenceService competenceService) {
		this.competenceService = competenceService;
	}

	/**
	 * LISTER COMPETENCES
	 */
	@GetMapping
	public List<CompetenceDto> listerCompetences() {
		return competenceService.listerCompetences();
	}
	
	@GetMapping("/id")
	public CompetenceDto getCompetenceParId(@RequestParam("id") Integer id) {
		return this.competenceService.getCompetenceParId(id);
	}
	
	@PostMapping
	public CompetenceDto postCompetence(@RequestBody @Valid CompetenceDto competenceDto) {
		System.out.println("Boup");
		return this.competenceService.postCompetence(competenceDto);
	}
	
	/**
	 * MODIFICATION COMPETENCE
	 * 
	 * @return
	 */
	@PutMapping("/modification")
	public CompetenceDto putCompetence(@RequestBody @Valid CompetenceDto competenceDto, @RequestParam("id") Integer id) {
		return this.competenceService.putCompetence(competenceDto, id);
	}


}
