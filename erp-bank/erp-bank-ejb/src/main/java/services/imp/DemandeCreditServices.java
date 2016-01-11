package services.imp;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.CallOffer;
import entities.Customer;
import entities.DemandeCredit;
import services.interfaces.CustomerServicesRemote;
import services.interfaces.DemandeCreditServicesLocal;
import services.interfaces.DemandeCreditServicesRemote;

/**
 * Session Bean implementation class DemandeCreditServices
 */
@Stateless
@LocalBean
public class DemandeCreditServices implements DemandeCreditServicesRemote, DemandeCreditServicesLocal {
	@PersistenceContext
	private EntityManager entityManager;
    /**
     * Default constructor. 
     */
	@EJB
	private CustomerServicesRemote customerServices;
    public DemandeCreditServices() {
        
    }
	@Override
	public Boolean adddemandecredit(DemandeCredit demande) {
		Boolean b = false;
		try {
			entityManager.persist(demande);
			b = true;
		} catch (Exception e) {
			System.err.println("ouups ...");
		}
		return b;
	}
	@Override
	public Boolean deletedemandecreditById(Integer id) {
		Boolean b = false;
		try {
			entityManager.remove(finddemandecreditById(id));
			b = true;
		} catch (Exception e) {
			System.err.println("ouups ...");
		}
		return b;
	}
	@Override
	public DemandeCredit finddemandecreditById(Integer id) {
		return entityManager.find(DemandeCredit.class, id);
	}
	@Override
	public Boolean updatedemandecredit(DemandeCredit demande) {
		Boolean b = false;
		try {
			entityManager.merge(demande);
			b = true;
		} catch (Exception e) {
			System.err.println("ouups ...");
		}
		return b;
	}
	@Override
	public Boolean deletedemandecredit(DemandeCredit demande) {
		Boolean b = false;
		try {
			entityManager.remove(entityManager.merge(demande));
			b = true;
		} catch (Exception e) {
			System.err.println("ouups ...");
		}
		return b;
	}
	@Override
	public List<DemandeCredit> findAllDemandeCredit() {
		String jpql = "select e from DemandeCredit e";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}
	@Override
	public List<DemandeCredit> findDemandeCreditByCustomer(Customer customer) {
		String jpql = "select e from DemandeCredit e where e.customer.customer_customerID =:c";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("c", customer.getCustomerID());
		return query.getResultList();
	}
	
	@Override
		public Boolean assignCustomertoDemande(Integer idCustomer, Integer idDemande) {
		Boolean b = false;
				try {
					Customer customerFound = customerServices.findCustomerById(idCustomer);
					DemandeCredit demandeFound = entityManager.find(DemandeCredit.class,
							idDemande);
		
					demandeFound.setCustomer(customerFound);
		
					entityManager.merge(demandeFound);
					b = true;
		
				} catch (Exception e) {
					System.err.println("ouups ...");
				}
		
				return b;
		}


}
