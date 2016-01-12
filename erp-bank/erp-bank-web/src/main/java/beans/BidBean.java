package beans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import entities.Bid;
import services.interfaces.BidServicesLocal;
import services.interfaces.CallOfferServicesLocal;


@ManagedBean
@SessionScoped
public class BidBean {
	// models
	private Bid bid = new Bid();
	private List<Bid> bids;
	private List<Bid> bids2;
	private Bid bidSelected = new Bid();
	private Boolean displayform = false;
	// injection of the proxy
		@EJB
		private BidServicesLocal bidServicesLocal;
		
		
		@ManagedProperty(value = "#{callOfferBean}")
		private CallOfferBean callOfferBean;
		@ManagedProperty(value = "#{loginCustomerBean}")
		private LoginCustomerBean customerBean;
		
		
		public LoginCustomerBean getCustomerBean() {
			return customerBean;
		}

		public void setCustomerBean(LoginCustomerBean customerBean) {
			this.customerBean = customerBean;
		}

		public void doaddBid()
		{
		bid.setProviderEmail(callOfferBean.getCustomerBean().getCustomerLoggedIn().getEmail());
	    bid.setCallOfferName(callOfferBean.getCallOfferSelected().getName());
	    bid.setContactEmail(callOfferBean.getText());
	    bid.setDiscription(callOfferBean.getDescription());
	    
			bidServicesLocal.addBid(bid);
		}
		
		public void doDeleteBid() {
			bidServicesLocal.deleteBid(bid);
			displayform = false;
			
			
		}
		public void acceptBid()
		{
			
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
			bids = bidServicesLocal.findbyemail(customerBean.getCustomerLoggedIn().getEmail());
			
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

		public CallOfferBean getCallOfferBean() {
			return callOfferBean;
		}

		public void setCallOfferBean(CallOfferBean callOfferBean) {
			this.callOfferBean = callOfferBean;
		}

		public List<Bid> getBids2() {
			bids2 = bidServicesLocal.findAllBid();
			return bids2;
		}

		
		public String doselect() {
			String navigateTo = "bidSelected";
			return navigateTo;
		}

		

		
		
}
