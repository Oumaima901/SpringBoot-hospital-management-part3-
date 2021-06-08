package tn.itbs.spring.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="patient")

public class Patient implements Serializable 
{
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
	@Column
    private String nom;
	@Column
    private String prenom;
	@Column
    private String email;
	@Column
    private String numero;
	@Column
    private String adresse;
	@ManyToOne
	@JoinColumn
	(name="id_doc")
	private Docteur docteur;
	


	@OneToMany(mappedBy="patient")
	private List<RendezVous> listRDV = new ArrayList<RendezVous>();

	public void ajouterRendezvous (RendezVous rdv) {
		rdv.setPatient(this);
		listRDV.add(rdv);}


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



	public Docteur getDocteur() {
		return docteur;
	}



	public void setDocteur(Docteur docteur) {
		this.docteur = docteur;
	}



	public List<RendezVous> getListRDV() {
		return listRDV;
	}



	public void setListRDV(List<RendezVous> listRDV) {
		this.listRDV = listRDV;
	}

	

	
	

	
	
	
}
