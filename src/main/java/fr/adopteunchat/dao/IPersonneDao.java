package fr.adopteunchat.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.adopteunchat.model.Personne;

//public interface IPersonneDao extends IDao<Personne>{
//
//	public Personne findByEmail(String email);
//
//}
public interface IPersonneDao extends JpaRepository<Personne,Integer>{
	
	public Personne findBymail(String email);
	public Personne findByid(int id);
	
}
