package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.Credit;
import entities.Customer;
import entities.DemandeCredit;

@Remote
public interface DemandeCreditServicesRemote {
	Boolean adddemandecredit(DemandeCredit demande);
	
	Boolean deletedemandecreditById(Integer id);

	DemandeCredit finddemandecreditById(Integer id);

	Boolean updatedemandecredit(DemandeCredit demande);

	Boolean deletedemandecredit(DemandeCredit demande);

	List<DemandeCredit> findAllDemandeCredit();
	
	List<DemandeCredit> findDemandeCreditByCustomer(Customer customer);

	Boolean assignCustomertoDemande(Integer customer, Integer demande);
}
