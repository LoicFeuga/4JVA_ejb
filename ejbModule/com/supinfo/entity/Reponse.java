package com.supinfo.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="reponse")
public class Reponse implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String libelle;
	private String descritpion;
	private Boolean reponse;
	
	@ManyToOne
	@JoinColumn(name="idQuestion")
	private Question question;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getDescritpion() {
		return descritpion;
	}

	public void setDescritpion(String descritpion) {
		this.descritpion = descritpion;
	}

	public Boolean getReponse() {
		return reponse;
	}

	

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Reponse(String libelle, String descritpion) {
		super();
		this.libelle = libelle;
		this.descritpion = descritpion;
	}

	public Reponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
