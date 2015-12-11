package services.imp;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import services.interfaces.MaterialsServicesLocal;
import services.interfaces.MaterialsServicesRemote;
import entities.Materials;

/**
 * Session Bean implementation class MaterialsServices
 */

@Stateless
@LocalBean
public class MaterialsServices implements MaterialsServicesRemote, MaterialsServicesLocal {
	@PersistenceContext
	private EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public MaterialsServices() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Boolean addMateriel(Materials materiel) {
		Boolean b = false;
				try {
					entityManager.persist(materiel);
					b = true;
				} catch (Exception e) {
					System.err.println("ouups ...");
				}
				return b;
	}

	
	
	@Override
	public Boolean deleteMaterielById(Integer id) {
		Boolean b = false;
				try {
					entityManager.remove(findMaterielById(id));
					b = true;
				} catch (Exception e) {
					System.err.println("ouups ...");
				}
				return b;
	}

	@Override
	public Materials findMaterielById(Integer id) {
		return entityManager.find(Materials.class, id);
		
	}

	@Override
	public Boolean updateMateriel(Materials materiel) {
		
		Boolean b = false;
				try {
					entityManager.merge(materiel);
					b = true;
				} catch (Exception e) {
					System.err.println("ouups ...");
				}
				return b;
	}

	@Override
	public Boolean deleteMateriel(Materials materiel) {
		Boolean b = false;
				try {
					entityManager.remove(entityManager.merge(materiel));
					b = true;
				} catch (Exception e) {
					System.err.println("ouups ...");
				}
				return b;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Materials> findAllMaterials() {
		String jpql = "select e from Materials e";
				Query query = entityManager.createQuery(jpql);
				return query.getResultList();
	}

	@Override
	public List<Materials> getAyHaja() {
List<Materials> stats = new ArrayList<Materials>();
		
		
		List<Object[]> results = entityManager.createQuery("select count(f.name),f.name from Materials f group by f.name").getResultList();
		for (Object[] result : results) {
			Materials stat = new Materials();
			stat.setQuantity((((Number) result[0]).intValue()));
			stat.setName((String) result[1]);
			stats.add(stat);
		}
		
		//List<StatCompany> stats =   em.createQuery("select a from Flight a  ").getResultList();
		return stats;
	}
	
	

}
