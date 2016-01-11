package entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Customer
 *
 */
@Entity

public class Customer implements Serializable {

	private List <BankAccount> bankAccounts;
	private List <DemandeCredit> demandeCredits;
	private List <Credit> credits;
	private Integer customerID;
	private Integer cin;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private boolean isDeleted;
	private static final long serialVersionUID = 1L;

	public Customer() {
		super();
	}  
	
	

	public Customer(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}



	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	public Integer getCustomerID() {
		return this.customerID;
	}

	public void setCustomerID(Integer customerID) {
		this.customerID = customerID;
	}   
	public Integer getCin() {
		return this.cin;
	}

	public void setCin(Integer cin) {
		this.cin = cin;
	}   
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}   
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}   
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}   
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}   
	public boolean getIsDeleted() {
		return this.isDeleted;
	}

	public void setIsDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	@OneToMany(mappedBy="customer")
	public List <BankAccount> getBankAccounts() {
		return bankAccounts;
	}
	public void setBankAccounts(List <BankAccount> bankAccounts) {
		this.bankAccounts = bankAccounts;
	}
	
	@OneToMany(mappedBy="client")
	public List <Credit> getCredits() {
		return credits;
	}
	public void setCredits(List <Credit> credits) {
		this.credits = credits;
	}
	@OneToMany(mappedBy="customer")
	public List <DemandeCredit> getDemandeCredits() {
		return demandeCredits;
	}
	public void setDemandeCredits(List <DemandeCredit> demandeCredits) {
		this.demandeCredits = demandeCredits;
	}
	
   
}
