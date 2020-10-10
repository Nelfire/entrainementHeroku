package dev.controller.dto;

import java.util.ArrayList;
import java.util.List;

import dev.entites.Competence;
import dev.entites.Role;

/**
 * Structure modélisant un collègue servant à communiquer avec 
 * l'extérieur (WEB API).
 *
 * @author KOMINIARZ Anaïs, SAGAN Jonathan, BATIGNES Pierre, GIRARD Vincent.
 *
 */
public class CollegueInfoDto {

	// Déclarations
	private String email;
	private String nom;
	private String prenom;
	private List<Role> roles = new ArrayList<>();
	private String urlPhoto;	
	private List<Competence> competences;

	/**
	 * Constructeur
	 * 
	 * @param email
	 * @param nom
	 * @param prenom
	 * @param roles
	 */
	public CollegueInfoDto(String email, String nom, String prenom, String urlPhoto, List<Competence> competences) {
		this.email = email;
		this.nom = nom;
		this.prenom = prenom;
		this.urlPhoto = urlPhoto;
		this.competences = competences;
	}

	/**
	 * Constructeur vide
	 */
	public CollegueInfoDto() {
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	/** Getter
	 * @return the urlPhoto
	 */
	public String getUrlPhoto() {
		return urlPhoto;
	}

	/** Setter
	 * @param urlPhoto the urlPhoto to set
	 */
	public void setUrlPhoto(String urlPhoto) {
		this.urlPhoto = urlPhoto;
	}

	public List<Competence> getCompetences() {
		return competences;
	}

	public void setCompetences(List<Competence> competences) {
		this.competences = competences;
	}


	
	
}
