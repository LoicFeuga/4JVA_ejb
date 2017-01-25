package com.supinfo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cours")
public class Cours implements Serializable{

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable=false)
	private String libelle;
	
	@Column(nullable=true)
	private String description;
	
	@Column(nullable=true)
	private String type;

	public Cours(){
		libelle = "";
		description ="";
		type ="";
	}
	
	public Cours(String libelle, String description, String type){
		this.libelle = libelle;
		this.description = description;
		this.type = type;
	}
	
	public int getId() {
		return id;
	}

	public String getLibelle() {
		return libelle;
	}

	public String getDescription() {
		return description;
	}

	public String getType() {
		return type;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setType(String type) {
		this.type = type;
	}
	

}
