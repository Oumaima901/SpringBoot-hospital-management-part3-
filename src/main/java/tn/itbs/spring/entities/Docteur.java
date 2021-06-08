package tn.itbs.spring.entities;

import java.io.Serializable;
import java.util.ArrayList;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="docteur")
public class Docteur implements Serializable {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	@NotNull
	@Column
	private String nom;
	@NotNull
	@Column
	private String prenom;
	@NotNull
	@Column
	private String email;
	@NotNull
	@Column
	private String specialisation ;
	@NotNull
	@Column
	private String numero;
	@NotNull
	@Column
	private String adresse;
	
	@OneToMany(mappedBy="docteur")
	private List<Patient> listPat = new ArrayList<Patient>();
	public void ajouterpatient (Patient p) {
	p.setDocteur(this);
	listPat.add(p);
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSpecialisation() {
		return specialisation;
	}

	public void setSpecialisation(String specialisation) {
		this.specialisation = specialisation;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public List<Patient> getListPat() {
		return listPat;
	}

	public void setListPat(List<Patient> listPat) {
		this.listPat = listPat;
	}
	
	
	}
