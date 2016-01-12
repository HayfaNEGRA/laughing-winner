package services.imp;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Customer;
import entities.Demandecheque;
import services.interfaces.CustomerServicesRemote;
import services.interfaces.DemandeChequeServicesLocal;
import services.interfaces.DemandeChequeServicesRemote;

/**
 * Session Bean implementation class DemandeChequeServices
 */
@Stateless
@LocalBean
public class DemandeChequeServices implements DemandeChequeServicesRemote, DemandeChequeServicesLocal {

    /**
     * Default constructor. 
     */
    public DemandeChequeServices() {
        // TODO Auto-generated constructor stub
    }
	@PersistenceContext
	private EntityManager entityManager;
    /**
     * Default constructor. 
     */
	@EJB
	private CustomerServicesRemote customerServices;
  
	@Override
	public Boolean adddemandecredit(Demandecheque demande) {
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
	public Demandecheque finddemandecreditById(Integer id) {
		return entityManager.find(Demandecheque.class, id);
	}
	@Override
	public Boolean updatedemandecredit(Demandecheque demande) {
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
	public Boolean deletedemandecredit(Demandecheque demande) {
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
	public List<Demandecheque> findAllDemandeCheque() {
		String jpql = "select e from Demandecheque e";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}
	@Override
	public List<Demandecheque> findDemandeChequeByCustomer(Customer customer) {
		String jpql = "select e from Demandecheque e where e.customer.customer_customerID =:c";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("c", customer.getCustomerID());
		return query.getResultList();
	}
	
	@Override
		public Boolean assignCustomertoDemande(Integer idCustomer, Integer idDemande) {
		Boolean b = false;
				try {
					Customer customerFound = customerServices.findCustomerById(idCustomer);
					Demandecheque demandeFound = entityManager.find(Demandecheque.class,
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
