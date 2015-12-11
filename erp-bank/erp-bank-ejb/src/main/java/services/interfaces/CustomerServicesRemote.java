package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.Customer;

@Remote
public interface CustomerServicesRemote {
	
   
	Boolean deleteCustomerById(Integer id);

	Customer findCustomerById(Integer id);

	Boolean updateCustomer(Customer customer);

	Boolean deleteCustomer(Customer customer);

	List<Customer> findAllCustomer();

	Customer logIn(String email,String password);
	Customer CustomerByCin(Integer cin);

}
