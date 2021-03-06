package services.interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.Bid;
import entities.CallOffer;

@Local
public interface CallOfferServicesLocal {

Boolean addcall_offer(CallOffer call_offer);
	
	Boolean deletecall_offerById(Integer id);

	CallOffer findcall_offerById(Integer id);

	Boolean updatecall_offer(CallOffer call_offer);

	Boolean deletecall_offer(CallOffer call_offer);

	List<CallOffer> findAllCallOffer();

	List<Bid> findbyname(String name);

	Boolean deleteBidByname(String name);
}
