package tn.itbs.spring.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.itbs.spring.entities.Patient;
import tn.itbs.spring.entities.RendezVous;


public interface RendezvousRepository  extends JpaRepository<RendezVous, Integer> {

	List<RendezVous> findAllById(int id);

	

	List<RendezVous> findAllByDate(String date);



	RendezVous getById(int id);




}
