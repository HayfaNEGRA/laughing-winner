package beans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import services.interfaces.BankAccountServicesRemote;
import entities.BankAccount;

@ManagedBean
@SessionScoped
public class AccountAffBean {
	private BankAccount account;
	private List<BankAccount> accounts ;
	@ManagedProperty("#{loginCustomerBean}") 
	private LoginCustomerBean login; 
	@EJB
	private BankAccountServicesRemote BankAccountServiceRemote;
	
	
	public AccountAffBean(){
		
	}
	
	public List<BankAccount> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<BankAccount> accounts) {
		this.accounts = accounts;
	}

	public LoginCustomerBean getLogin() {
		return login;
	}

	public void setLogin(LoginCustomerBean login) {
		this.login = login;
	}
public BankAccount AfficherCompte(){
/*	accounts = BankAccountServiceRemote.findAllBankAccount();
	for (BankAccount bankAccount : accounts) {
		if(bankAccount.getCustomer().getCustomerID()==this.login.getCustomerLoggedIn().getCustomerID()){
		this.account=bankAccount;	
		}
		
	}*/
	accounts = BankAccountServiceRemote.findAllBankAccount();
	for (BankAccount bankAccount : accounts) {
		if(bankAccount.getCustomer().getCustomerID()==1){
		this.account=bankAccount;	
		}
		
	}
	return this.account;
}

public BankAccount getAccount() {
	return account;
}

public void setAccount(BankAccount account) {
	this.account = account;
}

	//findAllBankAccount()

}
