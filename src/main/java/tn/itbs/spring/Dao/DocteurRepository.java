package tn.itbs.spring.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tn.itbs.spring.entities.Docteur;

public interface DocteurRepository extends JpaRepository<Docteur, Integer>{

	
	List<Docteur> findAll();
	List<Docteur> findAllById(Docteur docteur);

	List<Docteur> findAllById(int id);

	List<Docteur> findAllBynom(String nom);

	Docteur getById(int id);


	



	



}
