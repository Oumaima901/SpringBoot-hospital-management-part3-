package tn.itbs.spring.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.itbs.spring.entities.Docteur;
import tn.itbs.spring.entities.Patient;
import tn.itbs.spring.entities.RendezVous;



public interface PatientRepository extends JpaRepository<Patient, Integer> {



	

	List<Patient> findAllByNom(String nom);

	Patient getById(int id);

	List<Patient> findAll();

}
