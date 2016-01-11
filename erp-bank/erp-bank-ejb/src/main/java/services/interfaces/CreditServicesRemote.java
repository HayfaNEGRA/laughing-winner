package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.Credit;
import entities.Customer;
import entities.DemandeCredit;

@Remote
public interface CreditServicesRemote {
	Boolean addcredit(Credit credit);
	
	Boolean deletecreditById(Integer id);

	Credit findcreditById(Integer id);

	Boolean updatecredit(Credit credit);

	Boolean deletecredit(Credit credit);

	List<Credit> findAllCredit();
	
	List<Credit> findCreditByCustomer(Customer customer);
}
