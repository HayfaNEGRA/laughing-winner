package utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Bid;
import entities.CallOffer;
import entities.Customer;
import entities.InventoryManager;
import entities.Provider;

/**
 * Session Bean implementation class InitDB
 */
@Singleton
@LocalBean
@Startup
public class InitDB {
	@PersistenceContext
	private EntityManager entityManager;

	@PostConstruct
	public void initDataBase() throws ParseException {
		SimpleDateFormat formater = null;
		Date aujourdhui = new Date();
		formater = new SimpleDateFormat("dd-MM-yy");
		String d =formater.format(aujourdhui);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		Customer cust = new Customer();
		cust.setEmail("haifanegra@esprit.tn");
		cust.setPassword("password");
		cust.setIsDeleted(false);
		
		Provider prov = new Provider();
		prov.setEmail("haifanegra@esprit.tn");
		prov.setPassword("password");
		prov.setIsDeleted(false);
		
		InventoryManager im = new InventoryManager();
		im.setEmail("haifanegra2@esprit.tn");
		im.setPassword("password");
		im.setIsDeleted(false);
		
		Bid bid= new Bid();
		bid.setCallOfferName("name1");
		bid.setProviderEmail("haifanegra@esprit.tn");
		
		Bid bid1= new Bid();
		bid1.setCallOfferName("name2");
		bid1.setProviderEmail("haifanegra@esprit.tn");
		
		Bid bid2= new Bid();
		bid2.setCallOfferName("name3");
		bid2.setProviderEmail("haifanegra@esprit.tn");
		
		Date date2 = simpleDateFormat.parse("25/12/2015");
		CallOffer co1 = new CallOffer();
		co1.setDescription("Manufacture, supply, commissioning and maintenance of secure box for the sites of the Dream bank");
		co1.setName("Secure box");
		co1.setPrice(10000);
		co1.setDateMax(date2);
		co1.setProvided(false);
		co1.setQuantity(1);
		
		CallOffer co3 = new CallOffer();
		co3.setDescription("Framework agreement for the supply of electrical energy of the Dream Bank");
		co3.setName("electrical energy supply");
		co3.setDateMax(aujourdhui);
		co3.setPrice(10000);
		co3.setProvided(false);
		co3.setQuantity(1);
		CallOffer co4 = new CallOffer();
		co4.setDescription("Providing an automated handling system associated with a warehouse management system.");
		co4.setName("automated handling system");
		co4.setPrice(50000);
		co4.setDateMax(date2);
		co4.setProvided(false);
		co4.setQuantity(1);
		CallOffer co5 = new CallOffer();
		co5.setDescription("Acquisition and maintenance of two large-capacity copiers for the print shop of the Dream Bank");
		co5.setName("large-capacity copiers");
		co5.setPrice(50000);
		co5.setDateMax(date2);
		co5.setProvided(false);
		co5.setQuantity(1);
		CallOffer co6 = new CallOffer();
		co6.setDescription("Cotton comber waste");
		co6.setName("Cotton comber waste");
		co6.setDateMax(date2);
		co6.setPrice(60000);
		co6.setProvided(false);
		co6.setQuantity(1);
		CallOffer co7 = new CallOffer();
		co7.setDescription("Providing an automated handling system associated with a warehouse management system.");
		co7.setName("Automated system");
		co7.setPrice(70000);
		co7.setDateMax(date2);
		co7.setProvided(false);
		co7.setQuantity(1);
		CallOffer co2 = new CallOffer();
		co2.setDescription("Acquisition and maintenance of two large-capacity copiers for the print shop of the Dream Bank");
		co2.setName("Copiers");
		co2.setPrice(10);
		co2.setDateMax(date2);
		co2.setProvided(false);
		co2.setQuantity(1);
		entityManager.persist(co1);
		entityManager.persist(co2);
		entityManager.persist(co3);
		entityManager.persist(co4);
		entityManager.persist(co5);
		entityManager.persist(co6);
		entityManager.persist(co7);
		entityManager.persist(cust);
		entityManager.persist(prov);
		entityManager.persist(im);
		entityManager.persist(bid);
		entityManager.persist(bid1);
		entityManager.persist(bid2);

	}

	/**
	 * Default constructor.
	 */
	public InitDB() {
		// TODO Auto-generated constructor stub
	}

}
