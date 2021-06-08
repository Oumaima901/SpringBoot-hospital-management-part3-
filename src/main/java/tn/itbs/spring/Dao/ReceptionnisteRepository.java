package tn.itbs.spring.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.itbs.spring.entities.Receptionniste;



public interface ReceptionnisteRepository extends JpaRepository<Receptionniste, Integer>{

	

	List<Receptionniste> findAllByNom(String nom);

	List<Receptionniste> findAllById(int id);

	Receptionniste getById(int id);


}
