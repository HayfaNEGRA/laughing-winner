package entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Demandecheque
 *
 */
@Entity

public class Demandecheque implements Serializable {

	   
	
	private int idDemandecheque;
	private Customer customer;
	private Date DateDemande;
	private int nombreCheque;
	private static final long serialVersionUID = 1L;

	public Demandecheque() {
		super();
	} 
	
	public Demandecheque(int idDemandecheque, Customer customer,
			Date dateDemande, int nombreCheque) {
		super();
		this.idDemandecheque = idDemandecheque;
		this.customer = customer;
		DateDemande = dateDemande;
		this.nombreCheque = nombreCheque;
	}

	@Id    
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getIdDemandecheque() {
		return this.idDemandecheque;
	}

	public void setIdDemandecheque(int idDemandecheque) {
		this.idDemandecheque = idDemandecheque;
	}   
	public Date getDateDemande() {
		return this.DateDemande;
	}

	public void setDateDemande(Date DateDemande) {
		this.DateDemande = DateDemande;
	}   
	public int getNombreCheque() {
		return this.nombreCheque;
	}

	public void setNombreCheque(int nombreCheque) {
		this.nombreCheque = nombreCheque;
	}
	@ManyToOne
	@JoinColumn(name="customerId")
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
   
}
