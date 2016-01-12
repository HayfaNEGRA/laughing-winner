package services.interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.Customer;
import entities.DemandeCreditCard;

@Local
public interface DemandeCreditCardServicesLocal {
	Boolean adddemandecredit(DemandeCreditCard demande);
	
	Boolean deletedemandecreditById(Integer id);

	DemandeCreditCard finddemandecreditById(Integer id);

	Boolean updatedemandecredit(DemandeCreditCard demande);

	Boolean deletedemandecredit(DemandeCreditCard demande);

	List<DemandeCreditCard> findAllDemandeCreditCard();
	
	List<DemandeCreditCard> findDemandeCreditCardByCustomer(Customer customer);

	Boolean assignCustomertoDemande(Integer customer, Integer demande);

}
