package services.interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.Customer;
import entities.DemandeCredit;

@Local
public interface DemandeCreditServicesLocal {
	Boolean adddemandecredit(DemandeCredit demande);
	
	Boolean deletedemandecreditById(Integer id);

	DemandeCredit finddemandecreditById(Integer id);

	Boolean updatedemandecredit(DemandeCredit demande);

	Boolean deletedemandecredit(DemandeCredit demande);

	List<DemandeCredit> findAllDemandeCredit();
	
	List<DemandeCredit> findDemandeCreditByCustomer(Customer customer);

	Boolean assignCustomertoDemande(Integer customer, Integer demande);
}
