package beans;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import entities.Demandecheque;
import services.interfaces.DemandeChequeServicesRemote;

@ManagedBean
@SessionScoped
public class DemandeChequeBean {

	private Demandecheque demandeCheque = new Demandecheque();
	private List<Demandecheque> demandes;
	
	@ManagedProperty("#{loginCustomerBean}") 
	private LoginCustomerBean login; 
	@EJB
	private DemandeChequeServicesRemote demandeChequeServiceRemote;
	public DemandeChequeBean(){
		
	}
	
	public String doAddDemandeCredit() {
		demandeCheque.setDateDemande( new Date());
		//demandeCard.setCustomer(login.getCustomerLoggedIn());
		demandeChequeServiceRemote.adddemandecredit(demandeCheque);
		
		return null;

	}

	public List<Demandecheque> getDemandes() {
		return demandes;
	}

	public void setDemandes(List<Demandecheque> demandes) {
		this.demandes = demandes;
	}

	public Demandecheque getDemandeCheque() {
		return demandeCheque;
	}

	public void setDemandeCheque(Demandecheque demandeCheque) {
		this.demandeCheque = demandeCheque;
	}
	public LoginCustomerBean getLogin() {
		return login;
	}
	public void setLogin(LoginCustomerBean login) {
		this.login = login;
		}

}
