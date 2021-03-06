package services.imp;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import services.interfaces.CustomerServicesLocal;
import services.interfaces.CustomerServicesRemote;
import entities.Customer;
import entities.Employee;

/**
 * Session Bean implementation class CustomerServices
 */
@Stateless
public class CustomerServices implements CustomerServicesRemote,
		CustomerServicesLocal {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public CustomerServices() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Customer CustomerByCin(Integer cin) {

		String jpql = "select c from Customer c where c.cin =:c ";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("c", cin);
		Customer c = (Customer) query.getSingleResult();

		return c;
	}

	public Boolean deleteCustomerById(Integer id) {
		Boolean b = false;
		try {
			entityManager.remove(findCustomerById(id));
			b = true;
		} catch (Exception e) {
			System.err.println("ouups ...");
		}
		return b;
	}

	public Customer findCustomerById(Integer id) {
		return entityManager.find(Customer.class, id);

	}

	public Boolean updateCustomer(Customer customer) {

		Boolean b = false;
		try {
			entityManager.merge(customer);
			b = true;
		} catch (Exception e) {
			System.err.println("ouups ...");
		}
		return b;
	}

	public Boolean deleteCustomer(Customer customer) {
		Boolean b = false;
		try {
			entityManager.remove(entityManager.merge(customer));
			b = true;
		} catch (Exception e) {
			System.err.println("ouups ...");
		}
		return b;
	}

	@SuppressWarnings("unchecked")
	public List<Customer> findAllCustomer() {
		String jpql = "select e from Customer e";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

	@Override
	public Customer logIn(String email, String password) {
		Customer customer = null;
		String jpql = "select e from Customer e where e.email=:param1 and e.password=:param2";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param1", email);
		query.setParameter("param2", password);

		try {
			customer = (Customer) query.getSingleResult();
		} catch (Exception e) {
			System.out.println("user not found");
		}

		return customer;
	}

	@Override
	public Boolean addCustomer(Customer customer) {
		Boolean b = false;
			
			entityManager.persist(customer);
			b = true;
		
		return b;
	}

	

}
