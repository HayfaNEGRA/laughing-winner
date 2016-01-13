package converter;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import entities.Employee;
import entities.HumanRessourceManager;
import services.interfaces.HumanRessourceManagerServicesRemote;

@ManagedBean
public class ManagerConverter implements Converter {

	@EJB
	private HumanRessourceManagerServicesRemote managerServicesRemote;
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		return managerServicesRemote.Findhumanressource_managerByLastName(arg2);
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		return ((Employee) arg2).getLastName();
	}

	
}
