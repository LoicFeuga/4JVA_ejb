package com.supinfo.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="certification")
public class Certification implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String libelle;
	private String descritpion;
	private Date dateCetif;
	
	@ManyToOne
	@JoinColumn(name="idUser")
	private User user;
	@ManyToOne
	@JoinColumn(name="idCours")
	private Cours cours;
	
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
	public Date getDateCetif() {
		return dateCetif;
	}
	public void setDateCetif(Date dateCetif) {
		this.dateCetif = dateCetif;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Cours getCours() {
		return cours;
	}
	public void setCours(Cours cours) {
		this.cours = cours;
	}
	public Certification() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Certification(String libelle, String descritpion, Date dateCetif) {
		super();
		this.libelle = libelle;
		this.descritpion = descritpion;
		this.dateCetif = dateCetif;
	}
	
	

}
