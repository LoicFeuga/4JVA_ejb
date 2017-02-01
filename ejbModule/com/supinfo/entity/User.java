package com.supinfo.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="user")
public class User implements Serializable{
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable=true)
	private String nom;
	
	@Column(nullable=true)
	private String prenom;
	
	@Column(nullable=false)
    @NotNull(message="login needed")
	private String login;
	
	@Column(nullable=false)
    @NotNull(message="mdp needed")
	private String mdp;

	@Column(nullable=true)
	private String token;
	
	@ManyToMany
	@JoinTable(name="user_has_cours",joinColumns=@JoinColumn(name="user_id",referencedColumnName="id"),
    	inverseJoinColumns=@JoinColumn(name="cours_id",referencedColumnName="id"))
	private Collection<Cours> cours;

	@OneToMany(mappedBy="user")
	private Collection<Certification> certifications;
	
	public User(){
		
	}
	
	public User(String login, String mdp, String nom, String prenom){
		this.login = login;
		this.mdp = mdp;
		this.nom = nom;
		this.prenom = prenom;
	}
	
	public int getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getLogin() {
		return login;
	}

	public String getMdp() {
		return mdp;
	}

	public String getToken() {
		return token;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Collection<Cours> getCours() {
		return cours;
	}

	public Collection<Certification> getCertifications() {
		return certifications;
	}

	public void setCours(Collection<Cours> cours) {
		this.cours = cours;
	}

	public void setCertifications(Collection<Certification> certifications) {
		this.certifications = certifications;
	}

}
