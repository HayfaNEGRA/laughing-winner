package services.imp;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Bid;
import entities.Employee;
import services.interfaces.BidServicesLocal;
import services.interfaces.BidServicesRemote;

/**
 * Session Bean implementation class BidServices
 */
@Stateless
public class BidServices implements BidServicesRemote, BidServicesLocal {
	@PersistenceContext
	private EntityManager entityManager;
    /**
     * Default constructor. 
     */
	
	
	public BidServices() {
        // TODO Auto-generated constructor stub
    }
	
   @Override
    public Boolean addBid(Bid Bid) {
  		Boolean b = false;
  				
  					entityManager.merge(Bid);
  					b = true;
  				
  				return b;
  	}
   @Override
  	public Boolean deleteBidById(Integer id) {
  		Boolean b = false;
  				try {
  					entityManager.remove(findBidById(id));
  					b = true;
  				} catch (Exception e) {
  					System.err.println("ouups ...");
  				}
  				return b;
  	}

   @Override
  	public Bid findBidById(Integer id) {
  		return entityManager.find(Bid.class, id);
  		
  	}
   @Override
  	public Boolean updateBid(Bid Bid) {
  		
  		Boolean b = false;
  				try {
  					entityManager.merge(Bid);
  					b = true;
  				} catch (Exception e) {
  					System.err.println("ouups ...");
  				}
  				return b;
  	}
   @Override
  	public Boolean deleteBid(Bid Bid) {
  		Boolean b = false;
  				try {
  					entityManager.remove(entityManager.merge(Bid));
  					b = true;
  				} catch (Exception e) {
  					System.err.println("ouups ...");
  				}
  				return b;
  	}

  	@SuppressWarnings("unchecked")
  	 @Override
  	public List<Bid> findAllBid() {
  		String jpql = "select e from Bid e";
  				Query query = entityManager.createQuery(jpql);
  				return query.getResultList();
  	}
  	 @Override
  	public List<Bid> findbyemail(String email) {
  		String jpql = "select e from Bid e where e.providerEmail=:param";
  		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", email);
		return query.getResultList();

  	}



}
