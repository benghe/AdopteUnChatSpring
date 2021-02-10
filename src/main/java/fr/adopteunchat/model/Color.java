package fr.adopteunchat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //Obigatoire
@Table(name="color") //Pas obligatoire
public class Color {
	
	@Id //OBLIGATOIRE UNE FOIS ET UNE SEULE DANS UNE CLASSE ENTITY
	@GeneratedValue(strategy = GenerationType.IDENTITY) //STRATEGIE D'AUTO-INCREMENT SUR CET ID
	@Column(name="COLOR_ID") // OPTIONNEL SI LE NOM DU CHAMP = LE NOM DE L'ATTRIBUT
	private int id;
	
	@Column(name="COLOR_LIBELLE", length=50,nullable=false)
	private String libelle;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * @param libelle
	 */
	public Color(String libelle) {
		this.libelle = libelle;
	}
	
	public Color() {
	}
	
	
}
