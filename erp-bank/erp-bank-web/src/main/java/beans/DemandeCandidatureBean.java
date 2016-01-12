package beans;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.primefaces.event.FileUploadEvent;

import entities.CandidaciesDemands;
import entities.HumanRessourceManager;
import services.interfaces.CandidaciesDemandsServicesLocal;
import services.interfaces.CandidaciesDemandsServicesRemote;
import services.interfaces.HumanRessourceManagerServicesLocal;
import services.interfaces.HumanRessourceManagerServicesRemote;


@ManagedBean(name = "candidatureBean")
@ViewScoped
public class DemandeCandidatureBean {

	private CandidaciesDemands candidaciesDemands = new CandidaciesDemands();
	@EJB
	private CandidaciesDemandsServicesLocal candidaciesDemandsServices;
	@EJB
	private HumanRessourceManagerServicesLocal managerServicesRemote;
	@ManagedProperty("#{clientBean}")
	private ClientBean clientBean;
	public ClientBean getClientBean() {
		return clientBean;
	}

	public void setClientBean(ClientBean clientBean) {
		this.clientBean = clientBean;
	}

	private List<HumanRessourceManager> managers;
	private List<CandidaciesDemands> candidaciesDemandsList;
	private HumanRessourceManager manager = new HumanRessourceManager();
	
	@PostConstruct
	public void init() {
		managers = managerServicesRemote.findAllHumanRessourceManager();
		candidaciesDemandsList= candidaciesDemandsServices.findAllCandidaciesDemands();
	}
	
	public String doAddCandidaciesDemands() {
		candidaciesDemands.setHumanressourcemanager(manager);
		candidaciesDemandsServices.updatecandidaciesdemands(candidaciesDemands);
		return null;
	}
	public  String doDeleteDemand() {
		candidaciesDemandsServices.deletecandidaciesdemands(candidaciesDemands);
		init();
		return null;
	}
	
	public String doAccept(){
		candidaciesDemands.setIsDeleted(true);
		candidaciesDemandsServices.updatecandidaciesdemands(candidaciesDemands);
		clientBean.setSubject("Congratulation Candidacie Accepted !!");
		clientBean.setMessage("Hello your candidacie in Dream Bank is accepted");
		clientBean.setRecipient(candidaciesDemands.getEmail());
		clientBean.send();
		init();
		return null;
	}

	public CandidaciesDemands getCandidaciesDemands() {
		return candidaciesDemands;
	}

	public void setCandidaciesDemands(CandidaciesDemands candidaciesDemands) {
		this.candidaciesDemands = candidaciesDemands;
	}

	public List<HumanRessourceManager> getManagers() {
		return managers;
	}

	public void setManagers(List<HumanRessourceManager> managers) {
		this.managers = managers;
	}

	public HumanRessourceManager getManager() {
		return manager;
	}

	public void setManager(HumanRessourceManager manager) {
		this.manager = manager;
	}

	public List<CandidaciesDemands> getCandidaciesDemandsList() {
		return candidaciesDemandsList;
	}

	public void setCandidaciesDemandsList(List<CandidaciesDemands> candidaciesDemandsList) {
		this.candidaciesDemandsList = candidaciesDemandsList;
	}
	
	//
	private static final int BUFFER_SIZE = 61240;
	
	 public void handleFileUpload( FileUploadEvent event) {
	    	

	    	String c="C:\\Users\\skandar\\Desktop\\images\\";
	    	File result = new File("C:\\Users\\skandar\\Desktop\\images\\" + event.getFile().getFileName());
	        candidaciesDemands.setMotivation(c+event.getFile().getFileName());
	    	
	    

	 
	    	try {
	    	
	    	FileOutputStream fileOutputStream = new FileOutputStream(result);
	    	
	    	 
	    
	    	byte[] buffer = new byte[BUFFER_SIZE];
	    	
	    	 
	    	
	    	int bulk;
	    
	    	InputStream inputStream = event.getFile().getInputstream();
	        
	    	while (true) {
	    	
	    	bulk = inputStream.read(buffer);
	    	
	    	if (bulk < 0) {
	    	
	    	break;
	    
	    	}
	    
	    	fileOutputStream.write(buffer, 0, bulk);
	    
	    	fileOutputStream.flush();
	    	
	    	}
	    	
	    	 
	    	
	    	fileOutputStream.close();
	    	
	    	inputStream.close();
	    	candidaciesDemands.setMotivation(event.getFile().getFileName());
	    	
	    	FacesMessage msg = new FacesMessage("Detail image", "nom image: " + event.getFile().getFileName() + "taille image: " + event.getFile().getSize() / 1024 + " Kb	content type: " + event.getFile().getContentType() + "image enregistrer.");
	    	
	    	FacesContext.getCurrentInstance().addMessage(null, msg);
	    
	    	
	    
	    	} catch (IOException e) {
	    	
	    	e.printStackTrace();
	    
	    	 
	    
	    	FacesMessage error = new FacesMessage(FacesMessage.SEVERITY_ERROR, "The files were not uploaded!", "");
	    
	    	FacesContext.getCurrentInstance().addMessage(null, error);
	    	
	    	}      
	  
	    	}

//	 public void downloadFileListener(FacesContext facesContext, OutputStream outputStream) throws IOException {
//	        //Read file from particular path, path bind is binding of table field that contains path
//	        File filed = new File(candidaciesDemands.getMotivation());
//	        FileInputStream fis;
//	        byte[] b;
//	        try {
//	            fis = new FileInputStream(filed);
//
//	            int n;
//	            while ((n = fis.available()) > 0) {
//	                b = new byte[n];
//	                int result = fis.read(b);
//	                outputStream.write(b, 0, b.length);
//	                if (result == -1)
//	                    break;
//	            }
//	        } catch (IOException e) {
//	            e.printStackTrace();
//	        }
//	        outputStream.flush();
//	    }
	
	 
	 public void downloadFile() {
		 	System.out.println("test1111111111111");
		    File file = new File(candidaciesDemands.getMotivation());
		    HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();  
            System.out.println("hello");
		    response.setHeader("Content-Disposition", candidaciesDemands.getMotivation());  
		    response.setContentLength((int) file.length());  
		    ServletOutputStream out = null;  
		    try {  
		        FileInputStream input = new FileInputStream(file);  
		        byte[] buffer = new byte[1024];  
		        out = response.getOutputStream();  
		        int i = 0;  
		        while ((i = input.read(buffer)) != -1) {  
		            out.write(buffer);  
		            out.flush();  
		        }  
		        FacesContext.getCurrentInstance().getResponseComplete();  
		    } catch (IOException err) {  
		        err.printStackTrace();  
		    } finally {  
		        try {  
		            if (out != null) {  
		                out.close();  
		            }  
		        } catch (IOException err) {  
		            err.printStackTrace();  
		        }  
		    }  

		}
	 
	 
	 
	
	
	
}
