package beans;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import services.interfaces.CallOfferServicesLocal;
import services.interfaces.ProviderServicesLocal;
import utilities.Email;
import entities.CallOffer;
import entities.Provider;

@ManagedBean
@SessionScoped
public class CallOfferBean {

	// models
	private List<CallOffer> callOffers;
	private CallOffer callOffer;
	private CallOffer callOfferSelected;
	private CallOffer filtredCallOffer;
	private List<CallOffer> callOffersFeltred;
	private String password;
	private String text;
	private String description;
	private Boolean test=false;
	@Email(message = "must be a valid email")
	private String email;
	// injection of the proxy
	@EJB
	private CallOfferServicesLocal callOfferServicesLocal;
	@ManagedProperty(value = "#{loginBean}")
	private LoginBean customerBean;

	// Methods
	public List<CallOffer> getCallOffers() {

		return callOffers = callOfferServicesLocal.findAllCallOffer();

	}

	public String doselect() {
		//?faces-redirect=true
		String navigateTo = "CallOfferSelected";
		return navigateTo;
	}
	public void doDEleteCallOffer(String email)
	{
		callOfferServicesLocal.deleteBidByname(email);
	}

	public String doBind() {
		String navigateTo = "bind";
		
		return navigateTo;
	}
	public String dofilter() {
		String navigateTo = "callOfferfilter";
		
		return navigateTo;
	}
	public String domanage() {
		String navigateTo = "manageBid";
		
		return navigateTo;
	}
	public String doConfirmBind() {
		
String navigateTo = "";
		
		return navigateTo;
		}
	
	 public boolean filterByPrice(Object value, Object filter, Locale locale) {
	        String filterText = (filter == null) ? null : filter.toString().trim();
	        if(filterText == null||filterText.equals("")) {
	            return true;
	        }
	         
	        if(value == null) {
	            return false;
	        }
	         
	        return ((Comparable) value).compareTo(Float.valueOf(filterText)) < 0;
	    }

	public String dateToString() {
		SimpleDateFormat formater = null;
		formater = new SimpleDateFormat("dd-MM-yy");
		String d = formater.format(callOfferSelected.getDateMax());
		return d;
	}

	// getters and setters
	public void setCallOffers(List<CallOffer> callOffers) {
		this.callOffers = callOffers;
	}

	public CallOffer getCallOffer() {
		return callOffer;
	}

	public void setCallOffer(CallOffer callOffer) {
		this.callOffer = callOffer;
	}

	public CallOffer getCallOfferSelected() {
		return callOfferSelected;
	}

	public void setCallOfferSelected(CallOffer callOfferSelected) {
		this.callOfferSelected = callOfferSelected;
	}

	public CallOffer getFiltredCallOffer() {
		return filtredCallOffer;
	}

	public void setFiltredCallOffer(CallOffer filtredCallOffer) {
		this.filtredCallOffer = filtredCallOffer;
	}

	public List<CallOffer> getCallOffersFeltred() {
		return callOffersFeltred;
	}

	public void setCallOffersFeltred(List<CallOffer> callOffersFeltred) {
		this.callOffersFeltred = callOffersFeltred;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Boolean getTest() {
		return test;
	}

	public void setTest(Boolean test) {
		this.test = test;
	}

	public CallOfferServicesLocal getCallOfferServicesLocal() {
		return callOfferServicesLocal;
	}

	public void setCallOfferServicesLocal(
			CallOfferServicesLocal callOfferServicesLocal) {
		this.callOfferServicesLocal = callOfferServicesLocal;
	}

	

	public LoginBean getCustomerBean() {
		return customerBean;
	}

	public void setCustomerBean(LoginBean customerBean) {
		this.customerBean = customerBean;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	

}
