package ma.projet.demo.entities;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class PharmacieGarde {
	
	@EmbeddedId
	private PharmacieGardePK pk;
	@Temporal(TemporalType.DATE)
	private Date dateFin;
	
	@ManyToOne
	@JoinColumn(name = "pharmacie", insertable = false, updatable = false)
	private Pharmacie pharmacie;
	@ManyToOne
	@JoinColumn(name = "garde", insertable = false, updatable = false)
	private Garde garde;
	public PharmacieGarde() {
		super();
	}
	public PharmacieGardePK getPk() {
		return pk;
	}
	public void setPk(PharmacieGardePK pk) {
		this.pk = pk;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	public Pharmacie getPharmacie() {
		return pharmacie;
	}
	public void setPharmacie(Pharmacie pharmacie) {
		this.pharmacie = pharmacie;
	}
	public Garde getGarde() {
		return garde;
	}
	public void setGarde(Garde garde) {
		this.garde = garde;
	}
	
}
