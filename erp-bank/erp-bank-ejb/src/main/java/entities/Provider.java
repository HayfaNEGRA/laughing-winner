package entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Provider
 *
 */
@Entity
@Table(name="t_provider")

public class Provider extends Employee implements Serializable {

	

	private static final long serialVersionUID = 1L;
	private List<CallOffer> calloffers;
	public Provider() {
		super();
	}   
	
	
	@OneToMany(mappedBy="provider")
	public List<CallOffer> getCalloffers() {
		return calloffers;
	}
	public void setCalloffers(List<CallOffer> calloffers) {
		this.calloffers = calloffers;
	}
   
}
