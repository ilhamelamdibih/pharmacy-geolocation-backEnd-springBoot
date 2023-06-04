package ma.projet.demo.entities;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Embeddable
public class PharmacieGardePK implements Serializable  {
	private int pharmacie;
	private int garde;
	@Temporal(TemporalType.DATE)
	private Date dateDebut;
	public PharmacieGardePK() {
		super();
	}
	public int getPharmacie() {
		return pharmacie;
	}
	public void setPharmacie(int pharmacie) {
		this.pharmacie = pharmacie;
	}
	public int getGarde() {
		return garde;
	}
	public void setGarde(int garde) {
		this.garde = garde;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	
	
}
