package beans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import entities.Customer;
import services.interfaces.CustomerServicesRemote;



@ManagedBean
@SessionScoped
public class LoginCustomerBean {
	private Customer customer = new Customer();
	private Customer customerLoggedIn = new Customer();
	@EJB
	private CustomerServicesRemote employeeServicesRemote;

	public String doLoginCustomer() {
		String navigateTo = "";
		 customerLoggedIn = employeeServicesRemote.logIn(
				customer.getEmail(), customer.getPassword());
		if (customerLoggedIn != null) {
			
				navigateTo = "homeCustomer";
			
		} else {
			navigateTo = "logincustomer";
		}

		return navigateTo;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Customer getCustomerLoggedIn() {
		return customerLoggedIn;
	}

	public void setCustomerLoggedIn(Customer customerLoggedIn) {
		this.customerLoggedIn = customerLoggedIn;
	}

	public String doLogout(){
		String navigateTo = null;
		FacesContext
		.getCurrentInstance()
		.getExternalContext()
		.getSessionMap()
		.clear();
		navigateTo = "/logincustomer?faces-redirect=true";
		return navigateTo;
	}
	
	

}

