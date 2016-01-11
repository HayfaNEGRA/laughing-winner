package entities;

import entities.Customer;

import java.io.File;
import java.io.Serializable;
import java.lang.Float;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: DemandeCredit
 *
 */
@Entity

public class DemandeCredit implements Serializable {

	
	private int IdDemande;
	private Customer customer;
	private Date DateDemande;
	private String Type;
	private Float Montant;
	private String Description;
	private String file;
	private static final long serialVersionUID = 1L;

	public DemandeCredit() {
		super();
	}   
	
	public DemandeCredit(int idDemande, Customer customer, Date dateDemande,
			String type, Float montant, String description, String file) {
		super();
		IdDemande = idDemande;
		this.customer = customer;
		DateDemande = dateDemande;
		Type = type;
		Montant = montant;
		Description = description;
		this.file = file;
	}

	public DemandeCredit(Customer customer, String type, Float montant,
			String description) {
		super();
		this.customer = customer;
		Type = type;
		Montant = montant;
		Description = description;
	}

	@Id    
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getIdDemande() {
		return this.IdDemande;
	}

	public void setIdDemande(int IdDemande) {
		this.IdDemande = IdDemande;
	}   
	
	public Date getDateDemande() {
		return this.DateDemande;
	}

	public void setDateDemande(Date DateDemande) {
		this.DateDemande = DateDemande;
	}   
	public Float getMontant() {
		return this.Montant;
	}

	public void setMontant(Float Montant) {
		this.Montant = Montant;
	}   
	public String getDescription() {
		return this.Description;
	}

	public void setDescription(String Description) {
		this.Description = Description;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	
	@ManyToOne
	@JoinColumn(name="customerId")
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}
   
}
