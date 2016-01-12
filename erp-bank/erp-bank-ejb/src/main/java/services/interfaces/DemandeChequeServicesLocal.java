package services.interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.Customer;
import entities.Demandecheque;

@Local
public interface DemandeChequeServicesLocal {
	Boolean adddemandecredit(Demandecheque demande);
	
	Boolean deletedemandecreditById(Integer id);

	Demandecheque finddemandecreditById(Integer id);

	Boolean updatedemandecredit(Demandecheque demande);

	Boolean deletedemandecredit(Demandecheque demande);

	List<Demandecheque> findAllDemandeCheque();
	
	List<Demandecheque> findDemandeChequeByCustomer(Customer customer);

	Boolean assignCustomertoDemande(Integer customer, Integer demande);


}
