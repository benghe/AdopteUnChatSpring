package fr.adopteunchat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="personne")
public class Personne {
	
	@Id //OBLIGATOIRE UNE FOIS ET UNE SEULE DANS UNE CLASSE ENTITY
	@GeneratedValue(strategy = GenerationType.IDENTITY) //STRATEGIE D'AUTO-INCREMENT SUR CET ID
	@Column(name="PER_ID") // OPTIONNEL SI LE NOM DU CHAMP = LE NOM DE L'ATTRIBUT
	private int id;
	
	@Column(name="PER_NOM", length = 50, nullable=false)
	private String nom;
	
	@Column(name="PER_PRENOM", length = 50, nullable=false)
	private String prenom;
	
	@Column(name="PER_MAIL", length = 150, nullable=false)
	private String mail;
	
	@Column(name="PER_TELEPHONE", length = 20, nullable=false)
	private String telephone;
	
	@Column(name="PER_ADRESSE", length = 150, nullable=false)
	private String adresse;
	
	@Column(name="PER_PASSWORD", length = 300)
	private String password;
	
	@Column(name="PER_DATE_NAISSANCE")
	private String dateNaissance;
	// private Date dateNaissance;
	
	@Column(name = "PER_TYPE")
	private String type;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @param nom
	 * @param prenom
	 * @param mail
	 * @param telephone
	 * @param adresse
	 * @param password
	 * @param dateNaissance
	 * @param type
	 */
	public Personne(String nom, String prenom, String mail, String telephone, String adresse, String password,
			String dateNaissance, String type) {

		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.telephone = telephone;
		this.adresse = adresse;
		this.password = password;
		this.dateNaissance = dateNaissance;
		this.type = type;
	}

	/**
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param mail
	 * @param telephone
	 * @param adresse
	 * @param password
	 * @param dateNaissance
	 * @param type
	 */
	public Personne(int id, String nom, String prenom, String mail, String telephone, String adresse, String password,
			String dateNaissance, String type) {
		
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.telephone = telephone;
		this.adresse = adresse;
		this.password = password;
		this.dateNaissance = dateNaissance;
		this.type = type;
	}

	public Personne() {
	}

	@Override
	public String toString() {
		return "Personne [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", mail=" + mail + ", telephone="
				+ telephone + ", adresse=" + adresse + ", password=" + password + ", dateNaissance=" + dateNaissance
				+ ", type=" + type + "]";
	}

}
