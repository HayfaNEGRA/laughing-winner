package entities;

import entities.CallOffer;
import entities.Provider;

import java.io.Serializable;
import java.lang.Integer;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Bid
 *
 */
@Entity

public class Bid implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String providerEmail;
	private String callOfferName;
	private Provider provider;
	private CallOffer calloffer;
	private String discription;
	private String contactEmail;
	private Boolean accepted;
	private static final long serialVersionUID = 1L;

	public Bid() {
		super();
	}   
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public Provider getProvider() {
		return this.provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}   
	public CallOffer getCalloffer() {
		return this.calloffer;
	}

	public void setCalloffer(CallOffer calloffer) {
		this.calloffer = calloffer;
	}
	public String getProviderEmail() {
		return providerEmail;
	}
	public void setProviderEmail(String providerEmail) {
		this.providerEmail = providerEmail;
	}
	
	public String getCallOfferName() {
		return callOfferName;
	}
	public void setCallOfferName(String callOfferName) {
		this.callOfferName = callOfferName;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	public String getContactEmail() {
		return contactEmail;
	}
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}
	public Boolean getAccepted() {
		return accepted;
	}
	public void setAccepted(Boolean accepted) {
		this.accepted = accepted;
	}
   
}
