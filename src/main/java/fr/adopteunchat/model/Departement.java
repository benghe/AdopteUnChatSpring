package fr.adopteunchat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity //Obigatoire
@Table(name="dpt") //Pas obligatoire
public class Departement {
	
	@Id //OBLIGATOIRE UNE FOIS ET UNE SEULE DANS UNE CLASSE ENTITY
	@GeneratedValue(strategy = GenerationType.IDENTITY) //STRATEGIE D'AUTO-INCREMENT SUR CET ID
	@Column(name="DPT_ID") // OPTIONNEL SI LE NOM DU CHAMP = LE NOM DE L'ATTRIBUT
//	@Column(name="DPT_ID",nullable=false)
	private int id;
	
	@Column(name="DPT_LIBELLE", length=50,nullable=false)
	private String libelle;
	
//	@Column(name="DPT_REGION",nullable=false)
//	private int region_id;
	
	@ManyToOne
	@JoinColumn(name ="DPT_REGION")
	private Region region;

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

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	/**
	 * @param libelle
	 * @param region
	 */
	public Departement(String libelle, Region region) {
		this.libelle = libelle;
		this.region = region;
	}
	
	public Departement() {
	}

	
}
