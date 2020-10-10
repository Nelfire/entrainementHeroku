package dev.entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.List;

@Entity
public class Competence {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	private String adresseIcone;
	private String libelle;
	private String description;
	
	/** date de fin de l'absence **/
	@ManyToMany (mappedBy = "competences")
	private List<Collegue> collegue;
	
	// GETTERS ET SETTERS
	public Integer getId() {
		return Id;
	}
	
	public void setId(Integer id) {
		Id = id;
	}
	
	public String getAdresseIcone() {
		return adresseIcone;
	}

	public void setAdresseIcone(String adresseIcone) {
		this.adresseIcone = adresseIcone;
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


	// CONSTRUCTEUR
	public Competence(String adresseIcone, String libelle, String description) {
		this.adresseIcone = adresseIcone;
		this.libelle = libelle;
		this.description = description;
	}
	
	// CONSTRUCTEUR VIDE
	public Competence() {
	}

	

}
