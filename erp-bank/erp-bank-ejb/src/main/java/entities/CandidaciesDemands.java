package entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: CandidaciesDemands
 *
 */
@Entity
@Table(name="T_CandidaciesDemands")

public class CandidaciesDemands implements Serializable {

	
	private Integer IdDemand;
	private String Lastname;
	private String Firstname;
	private String Email;
	private String Motivation;
	private String Phone;
	private Boolean isDeleted=false;
	private static final long serialVersionUID = 1L;
	private HumanRessourceManager humanressourcemanager;

	public CandidaciesDemands() {
		super();
	}   
	@Id   
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getIdDemand() {
		return this.IdDemand;
	}

	public void setIdDemand(Integer IdDemand) {
		this.IdDemand = IdDemand;
	}   
	public String getLastname() {
		return this.Lastname;
	}

	public void setLastname(String Lastname) {
		this.Lastname = Lastname;
	}   
	public String getFirstname() {
		return this.Firstname;
	}

	public void setFirstname(String Firstname) {
		this.Firstname = Firstname;
	}   
	public String getEmail() {
		return this.Email;
	}

	public void setEmail(String Email) {
		this.Email = Email;
	}   
	public String getMotivation() {
		return this.Motivation;
	}

	public void setMotivation(String Motivation) {
		this.Motivation = Motivation;
	}   
	public String getPhone() {
		return this.Phone;
	}

	public void setPhone(String Phone) {
		this.Phone = Phone;
	}
	@ManyToOne
	public HumanRessourceManager getHumanressourcemanager() {
		return humanressourcemanager;
	}
	public void setHumanressourcemanager(HumanRessourceManager humanressourcemanager) {
		this.humanressourcemanager = humanressourcemanager;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Email == null) ? 0 : Email.hashCode());
		result = prime * result
				+ ((Firstname == null) ? 0 : Firstname.hashCode());
		result = prime * result
				+ ((IdDemand == null) ? 0 : IdDemand.hashCode());
		result = prime * result
				+ ((Lastname == null) ? 0 : Lastname.hashCode());
		result = prime * result
				+ ((Motivation == null) ? 0 : Motivation.hashCode());
		result = prime * result + ((Phone == null) ? 0 : Phone.hashCode());
		result = prime
				* result
				+ ((humanressourcemanager == null) ? 0 : humanressourcemanager
						.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CandidaciesDemands other = (CandidaciesDemands) obj;
		if (Email == null) {
			if (other.Email != null)
				return false;
		} else if (!Email.equals(other.Email))
			return false;
		if (Firstname == null) {
			if (other.Firstname != null)
				return false;
		} else if (!Firstname.equals(other.Firstname))
			return false;
		if (IdDemand == null) {
			if (other.IdDemand != null)
				return false;
		} else if (!IdDemand.equals(other.IdDemand))
			return false;
		if (Lastname == null) {
			if (other.Lastname != null)
				return false;
		} else if (!Lastname.equals(other.Lastname))
			return false;
		if (Motivation == null) {
			if (other.Motivation != null)
				return false;
		} else if (!Motivation.equals(other.Motivation))
			return false;
		if (Phone == null) {
			if (other.Phone != null)
				return false;
		} else if (!Phone.equals(other.Phone))
			return false;
		if (humanressourcemanager == null) {
			if (other.humanressourcemanager != null)
				return false;
		} else if (!humanressourcemanager.equals(other.humanressourcemanager))
			return false;
		return true;
	}
	public Boolean getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	
	
   
	
}
