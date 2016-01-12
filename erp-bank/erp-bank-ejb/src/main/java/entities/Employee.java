package entities;

import java.io.Serializable;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Employee
 *
 */
@Entity

public class Employee implements Serializable {

	
	private Integer IdEmployee;
	private String CIN;
	private String FirstName;
	private String LastName;
	private String Email;
	private String birthDate;
	private String adress;
	private int phoneNumber;
	private String sexe;
	private String civilState;
	private int kidsNumber;
	private String Password;
	private Payslip payslip;
	private Boolean IsDeleted;
	private static final long serialVersionUID = 1L;

	public Employee() {
		super();
	}   
	@Id    
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	public Integer getIdEmployee() {
		return this.IdEmployee;
	}

	public void setIdEmployee(Integer IdEmployee) {
		this.IdEmployee = IdEmployee;
	}   
	public String getFirstName() {
		return this.FirstName;
	}
	@ManyToOne
	public Payslip getPayslip() {
		return payslip;
	}
	public void setPayslip(Payslip payslip) {
		this.payslip = payslip;
	}
	public void setFirstName(String FirstName) {
		this.FirstName = FirstName;
	}   
	public String getLastName() {
		return this.LastName;
	}

	public void setLastName(String LastName) {
		this.LastName = LastName;
	}   
	public String getEmail() {
		return this.Email;
	}

	public void setEmail(String Email) {
		this.Email = Email;
	}   
	public String getPassword() {
		return this.Password;
	}

	public void setPassword(String Password) {
		this.Password = Password;
	}   
	public Boolean getIsDeleted() {
		return this.IsDeleted;
	}

	public void setIsDeleted(Boolean IsDeleted) {
		this.IsDeleted = IsDeleted;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public String getCivilState() {
		return civilState;
	}
	public void setCivilState(String civilState) {
		this.civilState = civilState;
	}
	public int getKidsNumber() {
		return kidsNumber;
	}
	public void setKidsNumber(int kidsNumber) {
		this.kidsNumber = kidsNumber;
	}
	public String getCIN() {
		return CIN;
	}
	public void setCIN(String cIN) {
		CIN = cIN;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CIN == null) ? 0 : CIN.hashCode());
		result = prime * result + ((Email == null) ? 0 : Email.hashCode());
		result = prime * result
				+ ((FirstName == null) ? 0 : FirstName.hashCode());
		result = prime * result
				+ ((IdEmployee == null) ? 0 : IdEmployee.hashCode());
		result = prime * result
				+ ((IsDeleted == null) ? 0 : IsDeleted.hashCode());
		result = prime * result
				+ ((LastName == null) ? 0 : LastName.hashCode());
		result = prime * result
				+ ((Password == null) ? 0 : Password.hashCode());
		result = prime * result + ((adress == null) ? 0 : adress.hashCode());
		result = prime * result
				+ ((birthDate == null) ? 0 : birthDate.hashCode());
		result = prime * result
				+ ((civilState == null) ? 0 : civilState.hashCode());
		result = prime * result + kidsNumber;
		result = prime * result + phoneNumber;
		result = prime * result + ((sexe == null) ? 0 : sexe.hashCode());
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
		Employee other = (Employee) obj;
		if (CIN == null) {
			if (other.CIN != null)
				return false;
		} else if (!CIN.equals(other.CIN))
			return false;
		if (Email == null) {
			if (other.Email != null)
				return false;
		} else if (!Email.equals(other.Email))
			return false;
		if (FirstName == null) {
			if (other.FirstName != null)
				return false;
		} else if (!FirstName.equals(other.FirstName))
			return false;
		if (IdEmployee == null) {
			if (other.IdEmployee != null)
				return false;
		} else if (!IdEmployee.equals(other.IdEmployee))
			return false;
		if (IsDeleted == null) {
			if (other.IsDeleted != null)
				return false;
		} else if (!IsDeleted.equals(other.IsDeleted))
			return false;
		if (LastName == null) {
			if (other.LastName != null)
				return false;
		} else if (!LastName.equals(other.LastName))
			return false;
		if (Password == null) {
			if (other.Password != null)
				return false;
		} else if (!Password.equals(other.Password))
			return false;
		if (adress == null) {
			if (other.adress != null)
				return false;
		} else if (!adress.equals(other.adress))
			return false;
		if (birthDate == null) {
			if (other.birthDate != null)
				return false;
		} else if (!birthDate.equals(other.birthDate))
			return false;
		if (civilState == null) {
			if (other.civilState != null)
				return false;
		} else if (!civilState.equals(other.civilState))
			return false;
		if (kidsNumber != other.kidsNumber)
			return false;
		if (phoneNumber != other.phoneNumber)
			return false;
		if (sexe == null) {
			if (other.sexe != null)
				return false;
		} else if (!sexe.equals(other.sexe))
			return false;
		return true;
	}
	
	
   
}
