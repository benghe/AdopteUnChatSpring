package fr.adopteunchat.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.adopteunchat.model.Color;

//public interface IColorDao extends IDao<Color>{
//
//}

public interface IColorDao extends JpaRepository<Color,Integer>{
	
}
