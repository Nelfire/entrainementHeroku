package dev.entites;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Entité collègue
 * 
 * @author KOMINIARZ Anaïs, SAGAN Jonathan, BATIGNES Pierre, GIRARD Vincent.
 *
 */
@Entity
public class Collegue {

	// Déclarations
    /** id du collegue **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /** nom du collegue **/
    private String nom;

    /** prenom du collegue **/
    private String prenom;

    /** email du collegue **/
    private String email;

	/** mot de passe du collegue **/
    private String motDePasse;
    
    private String urlPhoto;

    /** roles du collegue **/
    @OneToMany(mappedBy = "collegue", cascade = CascadeType.PERSIST)
    private List<RoleCollegue> roles;
    
    /** soldes du collegue **/
    @OneToMany(mappedBy = "collegue", cascade = CascadeType.PERSIST)
	private List<Solde> soldes;
    
    /** messages du collegue **/
    @OneToMany(mappedBy = "collegue", cascade = CascadeType.PERSIST)
	private List<Message> messages;
    
    
    /** absences du collegue **/
    @OneToMany(mappedBy = "collegue", cascade = CascadeType.PERSIST)
	private List<Absence> absences;
    
    /** competences du collegue **/
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "COL_COM",
    	    joinColumns = @JoinColumn(name ="ID_COL", referencedColumnName = "ID"),
    	    inverseJoinColumns = @JoinColumn(name ="ID_COM", referencedColumnName = "ID")
    )
	private List<Competence> competences;
    
    
    /** manager de plusieurs collegues **/
    @ManyToOne
    private Collegue manager; 
    
    /** subordonnes d'un manager **/
    @OneToMany(mappedBy = "manager")
    List<Collegue> subordonnes;
    
    /** Constructeur
     *
     */
    public Collegue() {
    	
    }
    
    /** Constructeur
	 *
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param roles
	 * @param soldes
	 * @param absences
	 */
	public Collegue(String nom, String prenom, String email, List<RoleCollegue> roles, List<Solde> soldes,
			List<Absence> absences, String urlPhoto, List<Competence> competences) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.roles = roles;
		this.soldes = soldes;
		this.absences = absences;
		this.urlPhoto = urlPhoto;
		this.competences = competences;
	}
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public List<RoleCollegue> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleCollegue> roles) {
        this.roles = roles;
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

	/** Getter
	 *
	 * @return soldes
	 */
	public List<Solde> getSoldes() {
		return soldes;
	}

	/** Setter
	 *
	 * @param soldes to set
	 */
	public void setSoldes(List<Solde> soldes) {
		this.soldes = soldes;
	}

	/** Getter
	 *
	 * @return absences
	 */
	public List<Absence> getAbsences() {
		return absences;
	}

	/** Setter
	 *
	 * @param absences to set
	 */
	public void setAbsences(List<Absence> absences) {
		this.absences = absences;
	}

	/** Getter
	 *
	 * @return manager
	 */
	public Collegue getManager() {
		return manager;
	}

	/** Setter
	 *
	 * @param manager to set
	 */
	public void setManager(Collegue manager) {
		this.manager = manager;
	}

	/** Getter
	 *
	 * @return subordonnes
	 */
	public List<Collegue> getSubordonnes() {
		return subordonnes;
	}

	/** Setter
	 *
	 * @param subordonnes to set
	 */
	public void setSubordonnes(List<Collegue> subordonnes) {
		this.subordonnes = subordonnes;
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

	/** Getter
	 * @return the messages
	 */
	public List<Message> getMessages() {
		return messages;
	}

	/** Setter
	 * @param messages the messages to set
	 */
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}



	public List<Competence> getCompetences() {
		return competences;
	}

	public void setCompetences(List<Competence> competences) {
		this.competences = competences;
	}

	@Override
	public String toString() {
		return "Collegue [nom=" + nom + ", prenom=" + prenom + ", roles=" + roles + ", competences=" + competences
				+ "]";
	}

	
}
