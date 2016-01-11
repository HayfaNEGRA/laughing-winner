package beans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import entities.Bid;
import services.interfaces.BidServicesLocal;


@ManagedBean
@SessionScoped
public class BidBean {
	// models
	private Bid bid = new Bid();
	private List<Bid> bids;
	private Bid bidSelected = new Bid();
	private Boolean displayform = false;
	// injection of the proxy
		@EJB
		private BidServicesLocal bidServicesLocal;
		
		
		public void doaddBid()
		{
		//	bid.setProviderEmail(callOfferBean.getText());
			//bid.setProviderPassword(callOfferBean.getPassword());
			bidServicesLocal.addBid(bid);
		}
		
		public void doDeleteBid() {
			bidServicesLocal.deleteBid(bid);
			displayform = false;
			
			
		}

		public void doUpdateBid() {
			bidServicesLocal.updateBid(bid);
			displayform = false;
			
		}

		public void doSelect() {
			displayform = true;
		}
		//getters and setters
		public Bid getBid() {
			return bid;
		}

		public void setBid(Bid bid) {
			this.bid = bid;
		}

		public List<Bid> getBids() {
			return bids;
		}

		public void setBids(List<Bid> bids) {
			this.bids = bids;
		}

		public Bid getBidSelected() {
			return bidSelected;
		}

		public void setBidSelected(Bid bidSelected) {
			this.bidSelected = bidSelected;
		}

		public Boolean getDisplayform() {
			return displayform;
		}

		public void setDisplayform(Boolean displayform) {
			this.displayform = displayform;
		}

		public BidServicesLocal getBidServicesLocal() {
			return bidServicesLocal;
		}

		public void setBidServicesLocal(BidServicesLocal bidServicesLocal) {
			this.bidServicesLocal = bidServicesLocal;
		}

		

		
		
}
