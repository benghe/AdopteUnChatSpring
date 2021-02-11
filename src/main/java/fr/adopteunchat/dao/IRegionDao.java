package fr.adopteunchat.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.adopteunchat.model.Region;

public interface IRegionDao extends JpaRepository<Region,Integer>{
	
	public Region findBylibelle (String libelle);

}
