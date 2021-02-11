package fr.adopteunchat.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.adopteunchat.model.Departement;

public interface IDepartementDao extends JpaRepository<Departement,Integer>{

}
