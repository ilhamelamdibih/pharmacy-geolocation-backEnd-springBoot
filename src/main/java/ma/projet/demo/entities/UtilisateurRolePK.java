package ma.projet.demo.entities;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class UtilisateurRolePK implements Serializable   {
	private int utilisateur;
	private int role;
	public UtilisateurRolePK() {
		super();
	}
	public int getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(int utilisateur) {
		this.utilisateur = utilisateur;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	
}
