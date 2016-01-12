package services.interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.Bid;

@Local
public interface BidServicesLocal {

	Boolean addBid(Bid Bid);

	Boolean deleteBidById(Integer id);

	Bid findBidById(Integer id);

	Boolean updateBid(Bid Bid);

	Boolean deleteBid(Bid Bid);

	List<Bid> findAllBid();

	List<Bid> findbyemail(String email);

}
