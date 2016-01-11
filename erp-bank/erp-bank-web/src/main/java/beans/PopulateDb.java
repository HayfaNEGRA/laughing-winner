package beans;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import services.interfaces.BankAccountServicesRemote;
import services.interfaces.CashierServicesRemote;
import services.interfaces.CreditServicesRemote;
import services.interfaces.CustomerServicesRemote;
import services.interfaces.DemandeCreditServicesRemote;
import entities.BankAccount;
import entities.Cashier;
import entities.Credit;


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
	
	@EJB
	private BankAccountServicesRemote bankAccountServicesRemote;

	/**
	 * Default constructor.
	 */
	public PopulateDb() {
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void initDb() {
	
		
		Cashier cashier = new Cashier();
		BankAccount banker = new BankAccount();
		banker.setCreationDate(new Date());
		banker.setBankAccountNumber(123456);
		banker.setBalance(10000.00);
		Credit credit = new Credit();
		credit.setMontantRestant((float) 40);
		credit.setTypeCrédit("Normal");
		
		cashier.setEmail("Joe2");
		cashier.setPassword("Joe2");

		bankAccountServicesRemote.addBankAccount(banker);
		creditServicesRemote.addcredit(credit);
		cashierServicesRemote.addCashier(cashier);
		

	}
}