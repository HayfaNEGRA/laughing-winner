package entities;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: DemandeCreditCard
 *
 */
@Entity
@Table(name="DemandeCreditCard")

public class DemandeCreditCard implements Serializable {

	   
	
	private int idCard;
	private Customer customer;
	private String typeCard;
	private Date DateDemande;
	private static final long serialVersionUID = 1L;

	public DemandeCreditCard() {
		super();
	}  
	@Id    
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getIdCard() {
		return this.idCard;
	}

	public void setIdCard(int idCard) {
		this.idCard = idCard;
	}   
	public String getTypeCard() {
		return this.typeCard;
	}

	public void setTypeCard(String typeCard) {
		this.typeCard = typeCard;
	}   
	public Date getDateDemande() {
		return this.DateDemande;
	}

	public void setDateDemande(Date DateDemande) {
		this.DateDemande = DateDemande;
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
