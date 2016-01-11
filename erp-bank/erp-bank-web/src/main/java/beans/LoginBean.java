package beans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import services.interfaces.EmployeeServicesLocal;
import entities.Cashier;
import entities.Employee;
import entities.HumanRessourceManager;

@ManagedBean
@SessionScoped
public class LoginBean {
	private Employee employee = new Employee();

	@EJB
	private EmployeeServicesLocal employeeServicesLocal;

	public String doLoginEmployee() {
		String navigateTo = "";
		Employee employeeLoggedIn = employeeServicesLocal.loginEmployee(
				employee.getEmail(), employee.getPassword());
		if (employeeLoggedIn != null) {
			if (employeeLoggedIn instanceof HumanRessourceManager) {
				navigateTo = "";
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

	
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
