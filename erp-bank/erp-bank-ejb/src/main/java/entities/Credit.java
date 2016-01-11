package entities;

import entities.Customer;

import java.io.Serializable;
import java.lang.Float;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Credit
 *
 */
@Entity

public class Credit implements Serializable {

	
	private Integer idCredit;
	private Customer client;
	private Float montantRestant;
	private String typeCrédit;
	private Date dateFin;
	private static final long serialVersionUID = 1L;

	public Credit() {
		super();
	}   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getIdCredit() {
		return this.idCredit;
	}

	public void setIdCredit(Integer idCredit) {
		this.idCredit = idCredit;
	}   
	@ManyToOne
	public Customer getClient() {
		return this.client;
	}

	public void setClient(Customer client) {
		this.client = client;
	}   
	public Float getMontantRestant() {
		return this.montantRestant;
	}

	public void setMontantRestant(Float montantRestant) {
		this.montantRestant = montantRestant;
	}   
	public String getTypeCrédit() {
		return this.typeCrédit;
	}

	public void setTypeCrédit(String typeCrédit) {
		this.typeCrédit = typeCrédit;
	}   
	public Date getDateFin() {
		return this.dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
   
}
