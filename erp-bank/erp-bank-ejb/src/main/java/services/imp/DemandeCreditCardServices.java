package services.imp;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Customer;
import entities.DemandeCreditCard;
import services.interfaces.CustomerServicesRemote;
import services.interfaces.DemandeCreditCardServicesLocal;
import services.interfaces.DemandeCreditCardServicesRemote;

/**
 * Session Bean implementation class DemandeCreditCardCardServices
 */
@Stateless
@LocalBean
public class DemandeCreditCardServices implements DemandeCreditCardServicesRemote, DemandeCreditCardServicesLocal {
    @PersistenceContext
	private EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public DemandeCreditCardServices() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Default constructor. 
     */
	@EJB
	private CustomerServicesRemote customerServices;

	@Override
	public Boolean adddemandecredit(DemandeCreditCard demande) {
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
	public DemandeCreditCard finddemandecreditById(Integer id) {
		return entityManager.find(DemandeCreditCard.class, id);
	}
	@Override
	public Boolean updatedemandecredit(DemandeCreditCard demande) {
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
	public Boolean deletedemandecredit(DemandeCreditCard demande) {
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
	public List<DemandeCreditCard> findAllDemandeCreditCard() {
		String jpql = "select e from DemandeCreditCard e";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}
	@Override
	public List<DemandeCreditCard> findDemandeCreditCardByCustomer(Customer customer) {
		String jpql = "select e from DemandeCreditCard e where e.customer.customer_customerID =:c";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("c", customer.getCustomerID());
		return query.getResultList();
	}
	
	@Override
		public Boolean assignCustomertoDemande(Integer idCustomer, Integer idDemande) {
		Boolean b = false;
				try {
					Customer customerFound = customerServices.findCustomerById(idCustomer);
					DemandeCreditCard demandeFound = entityManager.find(DemandeCreditCard.class,
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
