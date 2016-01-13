package beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entities.Employee;
import services.interfaces.EmployeeServicesLocal;


@ManagedBean(name = "EmployeBean")
@ViewScoped
public class GestionEmployeBean {
	private Employee employee = new Employee();
	@EJB
	private EmployeeServicesLocal employeeServices;
	private List<Employee> employees;
	
	@PostConstruct
	public void init() {
		employees = employeeServices.findAllEmployee();

	}
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public String doAddEmployee() {

		employeeServices.updateEmployee(employee);
		init();
		return null;
	}
	public  String doDeleteEmployee() {
		employeeServices.deleteEmployee(employee);
		init();
		return null;
	}
	public String doUpdate() {
		employeeServices.updateEmployee(employee);
		return null;
	}
}