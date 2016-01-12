package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.HumanRessourceManager;

@Remote
public interface HumanRessourceManagerServicesRemote {
	List<HumanRessourceManager> findAllHumanRessourceManager();	
	HumanRessourceManager Findhumanressource_managerByLastName(String lastName);
}
