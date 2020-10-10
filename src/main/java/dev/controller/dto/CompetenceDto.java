package dev.controller.dto;

public class CompetenceDto {

	private Integer id;
	private String adresseIcone;
	private String libelle;
	private String description;

	// -- GETTERS ET SETTERS
	
	public Integer getId() {
		return id;
	}

	public String getAdresseIcone() {
		return adresseIcone;
	}

	public void setAdresseIcone(String adresseIcone) {
		this.adresseIcone = adresseIcone;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	// CONSTRUCTEUR VIDE
	public CompetenceDto() {

	}
	
	// CONSTRUCTEUR
	public CompetenceDto(Integer id, String adresseIcone, String libelle, String description) {
		super();
		this.id = id;
		this.adresseIcone = adresseIcone;
		this.libelle = libelle;
		this.description = description;
	}
}
