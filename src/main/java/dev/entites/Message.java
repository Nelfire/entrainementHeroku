package dev.entites;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Message {

	// Déclarations
	/** id du message **/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/** date de publication du message **/
	private LocalDate datePublication;
	
	/** date de fin de l'absence **/
	@ManyToOne
	@JoinColumn(name = "collegue_id")
	private Collegue collegue;

	/** contenu du message **/
	private String contenu;

	/** Getter
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/** Setter
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

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
	 * @return the emetteur
	 */
	public Collegue getCollegue() {
		return collegue;
	}

	/** Setter
	 * @param emetteur the emetteur to set
	 */
	public void setCollegue(Collegue collegue) {
		this.collegue = collegue;
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

	/** Constructeur
	 * @param id
	 * @param datePublication
	 * @param emetteur
	 * @param contenu
	 */
	public Message(LocalDate datePublication, Collegue collegue, String contenu) {
		super();
		this.datePublication = datePublication;
		this.collegue = collegue;
		this.contenu = contenu;
	} 
	
	public Message() {

	}

}
