package beans;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;




import javax.faces.bean.SessionScoped;

import services.interfaces.DemandeCreditCardServicesRemote;
import entities.DemandeCreditCard;

@ManagedBean
@SessionScoped
public class DemandeCreditCardBean {
	private DemandeCreditCard demandeCard = new DemandeCreditCard();
	private List<DemandeCreditCard> demandes;
	
	@ManagedProperty("#{loginCustomerBean}") 
	private LoginCustomerBean login; 
	@EJB
	private DemandeCreditCardServicesRemote demandeCreditCardServiceRemote;
	public DemandeCreditCardBean(){
		
	}
	
	public String doAddDemandeCredit() {
		demandeCard.setDateDemande( new Date());
		//demandeCard.setCustomer(login.getCustomerLoggedIn());
		demandeCreditCardServiceRemote.adddemandecredit(demandeCard);
		
		return null;

	}
	

	public LoginCustomerBean getLogin() {
		return login;
	}
	public void setLogin(LoginCustomerBean login) {
		this.login = login;
		}
	public DemandeCreditCard getDemandeCard() {
		return demandeCard;
	}
	public void setDemandeCard(DemandeCreditCard demandeCard) {
		this.demandeCard = demandeCard;
	}
	public List<DemandeCreditCard> getDemandes() {
		return demandes;
	}
	public void setDemandes(List<DemandeCreditCard> demandes) {
		this.demandes = demandes;
	}
}
