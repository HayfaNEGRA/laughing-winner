package services.imp;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.CallOffer;
import entities.Credit;
import entities.Customer;
import services.interfaces.CreditServicesLocal;
import services.interfaces.CreditServicesRemote;

/**
 * Session Bean implementation class CreditServices
 */
@Stateless
@LocalBean
public class CreditServices implements CreditServicesRemote, CreditServicesLocal {
	@PersistenceContext
	private EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public CreditServices() {
    	
    }
	@Override
	public Boolean addcredit(Credit credit) {
		Boolean b = false;
		try {
			entityManager.persist(credit);
			b = true;
		} catch (Exception e) {
			System.err.println("ouups ...");
		}
		return b;
	}
	@Override
	public Boolean deletecreditById(Integer id) {
		Boolean b = false;
		try {
			entityManager.remove(findcreditById(id));
			b = true;
		} catch (Exception e) {
			System.err.println("ouups ...");
		}
		return b;
	}
	@Override
	public Credit findcreditById(Integer id) {
		return entityManager.find(Credit.class, id);
	}
	@Override
	public Boolean updatecredit(Credit credit) {
		Boolean b = false;
		try {
			entityManager.merge(credit);
			b = true;
		} catch (Exception e) {
			System.err.println("ouups ...");
		}
		return b;
	}
	@Override
	public Boolean deletecredit(Credit credit) {
		Boolean b = false;
		try {
			entityManager.remove(entityManager.merge(credit));
			b = true;
		} catch (Exception e) {
			System.err.println("ouups ...");
		}
		return b;
	}
	@Override
	public List<Credit> findAllCredit() {
		String jpql = "select e from Credit e";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}
	@Override
	public List<Credit> findCreditByCustomer(Customer customer) {
		String jpql = "select e from Credit e where e.customer =:c";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("c", customer);
		return query.getResultList();
	}

}
