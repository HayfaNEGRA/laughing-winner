package beans;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import services.interfaces.CashierServicesRemote;
import services.interfaces.CreditServicesRemote;
import services.interfaces.CustomerServicesRemote;
import services.interfaces.DemandeCreditServicesRemote;
import entities.Cashier;
import entities.Credit;
import entities.Customer;
import entities.DemandeCredit;

/**
 * Session Bean implementation class PopulateDb
 */
@Singleton
@LocalBean
@Startup
public class PopulateDb {

	@EJB
	private DemandeCreditServicesRemote demandeCreditServicesRemote;
	@EJB
	private CreditServicesRemote creditServicesRemote;
	@EJB
	private CustomerServicesRemote customerServicesRemote;
	@EJB
	private CashierServicesRemote cashierServicesRemote;

	/**
	 * Default constructor.
	 */
	public PopulateDb() {
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void initDb() {
	
		DemandeCredit demande= new DemandeCredit();
		DemandeCredit demande2= new DemandeCredit();
		
		Cashier cashier = new Cashier();
		demande.setDescription("fghjklfghjklfghjk");
		demande.setType("2");
		demande.setMontant((float) 20);
		demande2.setDescription("azertyuiop");
		demande2.setType("1");
		demande2.setMontant((float) 500);
		Credit credit = new Credit();
		Credit credit2 = new Credit();
		Credit credit3 = new Credit();
		Credit credit4 = new Credit();
		Credit credit5 = new Credit();
		Credit credit6 = new Credit();
		credit.setMontantRestant((float) 40);
		credit.setTypeCrédit("Normal");
		credit2.setMontantRestant((float) 40);
		credit2.setTypeCrédit("Normal");
		credit3.setMontantRestant((float) 40);
		credit3.setTypeCrédit("Pas Normal");
		credit4.setMontantRestant((float) 40);
		credit4.setTypeCrédit("Pas Normal");
		credit5.setMontantRestant((float) 40);
		credit5.setTypeCrédit("Normal");
		credit6.setMontantRestant((float) 40);
		credit6.setTypeCrédit("Bof");
		
		cashier.setEmail("Joe2");
		cashier.setPassword("Joe2");

		demandeCreditServicesRemote.adddemandecredit(demande2);
		demandeCreditServicesRemote.adddemandecredit(demande);
		creditServicesRemote.addcredit(credit);
		creditServicesRemote.addcredit(credit2);
		creditServicesRemote.addcredit(credit3);
		creditServicesRemote.addcredit(credit4);
		creditServicesRemote.addcredit(credit5);
		creditServicesRemote.addcredit(credit6);
		
		cashierServicesRemote.addCashier(cashier);
		

	}
}