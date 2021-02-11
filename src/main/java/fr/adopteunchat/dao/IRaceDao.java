package fr.adopteunchat.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.adopteunchat.model.Race;

public interface IRaceDao extends JpaRepository<Race, Integer>{

}
