/**
 * 
 */
package dev.controller.dto;

import java.time.LocalDate;

import dev.entites.Collegue;

public class MessageAjoutDto {

	// Déclarations
	private LocalDate datePublication;
	private String emailCollegue;
	private String contenu;

	/** Getter
	 * @return the datePublication
	 */
	public LocalDate getDatePublication() {
		return datePublication;
	}
	/** Setter
	 * @param datePublication the datePublication to set
	 */
	public void setDatePublication(LocalDate datePublication) {
		this.datePublication = datePublication;
	}

	/** Getter
	 * @return the contenu
	 */
	public String getContenu() {
		return contenu;
	}
	/** Setter
	 * @param contenu the contenu to set
	 */
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	/** Getter
	 * @return the collegueId
	 */
	public String getEmailCollegue() {
		return emailCollegue;
	}
	public void setEmailCollegue(String emailCollegue) {
		this.emailCollegue = emailCollegue;
	}
	public MessageAjoutDto(LocalDate datePublication, String emailCollegue, String contenu) {
		super();
		this.datePublication = datePublication;
		this.emailCollegue = emailCollegue;
		this.contenu = contenu;
	}
	
	public MessageAjoutDto() {
	}

	



	

	
}
