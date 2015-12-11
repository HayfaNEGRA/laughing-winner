package entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: AccountCreationRequest
 *
 */
@Entity

public class AccountCreationRequest implements Serializable {

	
	private Integer accountCreationRequestID;
	private Integer cin;
	private String email;
	private String firstName;
	private String lastName;
	private String password;
	private Cashier approuvedBy;
	private String accountType;
	private Date requestDate;
	private String IdentityProofUrl ;
	
	private boolean IsTreated;
	private static final long serialVersionUID = 1L;

	public AccountCreationRequest() {
		super();
	}   
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getAccountCreationRequestID() {
		return this.accountCreationRequestID;
	}

	public void setAccountCreationRequestID(Integer accountCreationRequestID) {
		this.accountCreationRequestID = accountCreationRequestID;
	}   
	public Integer getCin() {
		return this.cin;
	}

	public void setCin(Integer cin) {
		this.cin = cin;
	}   
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
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
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public Cashier getApprouvedBy() {
		return approuvedBy;
	}
	public void setApprouvedBy(Cashier approuvedBy) {
		this.approuvedBy = approuvedBy;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public Date getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}
	public String getIdentityProofUrl() {
		return IdentityProofUrl;
	}
	public void setIdentityProofUrl(String identityProofUrl) {
		IdentityProofUrl = identityProofUrl;
	}
	public boolean getIsTreated() {
		return IsTreated;
	}
	public void setIsTreated(boolean isTreated) {
		IsTreated = isTreated;
	}
   
}
