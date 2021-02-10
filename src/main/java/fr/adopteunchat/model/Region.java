package fr.adopteunchat.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity //Obigatoire
@Table(name="region") //Pas obligatoire
public class Region {
	@Id //OBLIGATOIRE UNE FOIS ET UNE SEULE DANS UNE CLASSE ENTITY
	@GeneratedValue(strategy = GenerationType.IDENTITY) //STRATEGIE D'AUTO-INCREMENT SUR CET ID
	@Column(name="REGION_ID") // OPTIONNEL SI LE NOM DU CHAMP = LE NOM DE L'ATTRIBUT
//	@Column(name="REGION_ID",nullable=false)
	private int id;
	
	@Column(name="REGION_LIBELLE", length=50,nullable=false)
	private String libelle;
	
	@OneToMany(mappedBy = "region") //(car s'appelle "region" dans Departement)
	private List<Departement> departements;

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

	public List<Departement> getDepartements() {
		return departements;
	}
	
	public void setDepartements(List<Departement> departements) {
		this.departements = departements;
	}
	
	/**
	 * @param id
	 * @param libelle
	 */
	public Region(int id, String libelle) {
		this.id = id;
		this.libelle = libelle;
	}
	
	

	/**
	 	 * @param libelle
	 */
	public Region(String libelle) {
		this.libelle = libelle;
	}
	
	public Region() {
	}
	
	
}
