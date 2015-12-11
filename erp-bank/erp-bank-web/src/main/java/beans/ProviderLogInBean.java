package beans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import persistence.Proviider;
import services.interfaces.ProviiderServicesLocal;

@ManagedBean
@SessionScoped
public class ProviderLogInBean {
	private Proviider proviider = new Proviider();
	@EJB
	private ProviiderServicesLocal proviiderServicesLocal;
	


	public String doLogIn()
	{
		String navigateTo;
		Proviider providerLogedIn=proviiderServicesLocal.providerLogIn(proviider.getEmail(), proviider.getPassword());
		if(providerLogedIn!= null)
			{proviider=providerLogedIn;
			navigateTo="ok";
			}
		else
		{
			navigateTo="error";
		}
		return navigateTo;
	}

	public Proviider getProviider() {
		return proviider;
	}

	public void setProviider(Proviider proviider) {
		this.proviider = proviider;
	}

}
