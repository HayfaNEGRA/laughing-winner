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
   
	
}
