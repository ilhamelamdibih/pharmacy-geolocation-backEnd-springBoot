package ma.projet.demo.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class UtilisateurRole {
	@EmbeddedId
	private UtilisateurRolePK pk;
	@ManyToOne
	@JoinColumn(name = "utilisateur", insertable = false, updatable = false)
	private Utilisateur utilisateur;
	@ManyToOne
	@JoinColumn(name = "role", insertable = false, updatable = false)
	private Role role;
	public UtilisateurRole() {
		super();
	}
	public UtilisateurRolePK getPk() {
		return pk;
	}
	public void setPk(UtilisateurRolePK pk) {
		this.pk = pk;
	}
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
	
}
