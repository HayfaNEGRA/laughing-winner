package beans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import services.interfaces.EmployeeServicesLocal;
import entities.Cashier;
import entities.Employee;
import entities.HumanRessourceManager;
import entities.InventoryManager;
import entities.Provider;

@ManagedBean
@SessionScoped
public class LoginBean {
	private Employee employee = new Employee();
	private Employee employeeLoggedIn = new Employee();
	@EJB
	private EmployeeServicesLocal employeeServicesLocal;

	public Employee getEmployeeLoggedIn() {
		return employeeLoggedIn;
	}



	public void setEmployeeLoggedIn(Employee employeeLoggedIn) {
		this.employeeLoggedIn = employeeLoggedIn;
	}



	public String doLoginEmployee() {
		String navigateTo = "";
		 employeeLoggedIn = employeeServicesLocal.loginEmployee(
				employee.getEmail(), employee.getPassword());
		if (employeeLoggedIn != null) {
			if (employeeLoggedIn instanceof HumanRessourceManager) {
				navigateTo = "";
			}
			else if (employeeLoggedIn instanceof Provider) {
				navigateTo = "callOfferfilter";
			}
			else if (employeeLoggedIn instanceof InventoryManager) {
				navigateTo = "imManageBid";
			}
			else if (employeeLoggedIn instanceof Cashier)
			{
				navigateTo = "menuDemande";
			}
		} else {
			navigateTo = "error";
		}

		return navigateTo;
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
	
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
