package beans;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.ToggleEvent;

import services.interfaces.CreditServicesRemote;
import services.interfaces.DemandeCreditServicesRemote;
import entities.DemandeCredit;

@ManagedBean
@SessionScoped
public class DemandeCreditBean {
    private String Image;
	private DemandeCredit demande = new DemandeCredit();
	private List<DemandeCredit> demandes;
	
	@ManagedProperty("#{loginCustomerBean}") 
	private LoginCustomerBean login; 

	public LoginCustomerBean getLogin() {
		return login;
	}
	public void setLogin(LoginCustomerBean login) {
		this.login = login;
		}





	private Boolean displayform = false;
	@EJB
	private DemandeCreditServicesRemote demandeCreditServiceRemote;
	@EJB
	private CreditServicesRemote creditServicesRemote;
	
	
	
	public void getImage(ToggleEvent event)
	{
		this.setImage(((DemandeCredit) event.getData()).getFile());
		
	}
	public DemandeCreditBean()
	{}
	
	
	
	public String doAddDemandeCredit() {
		demande.setDateDemande( new Date());
		demandeCreditServiceRemote.adddemandecredit(demande);
		
		return null;

	}
	
	public String doDeleteDemandeCredit() {
		demandeCreditServiceRemote.deletedemandecredit(demande);
		setDisplayform(false);

		return "";
	}

	
	public String doUpdateDemandeCredit() {
		demandeCreditServiceRemote.updatedemandecredit(demande);
		setDisplayform(false);
		return "";
	}
	
	public String doAjouterDemande() {
		
		return "Ajouter";
	}

	public DemandeCreditServicesRemote getDemandeCreditServiceRemote() {
		return demandeCreditServiceRemote;
	}
	
	
	
	public void setDemandeCreditServiceRemote(
			DemandeCreditServicesRemote demandeCreditServiceRemote) {
		this.demandeCreditServiceRemote = demandeCreditServiceRemote;
	}

	public void doSelect() {
		setDisplayform(true);
	}

	public DemandeCredit getDemande() {
		return demande;
	}

	public void setDemande(DemandeCredit demande) {
		this.demande = demande;
	}
	
	public List<DemandeCredit> getDemandes() {
		demandes = demandeCreditServiceRemote.findAllDemandeCredit();
		return demandes;
	}

	public void setDemandes(List<DemandeCredit> demandes) {
		this.demandes = demandes;
		
	}

	public Boolean getDisplayform() {
		return displayform;
	}

	public void setDisplayform(Boolean displayform) {
		this.displayform = displayform;
	}
	public CreditServicesRemote getCreditServicesRemote() {
		return creditServicesRemote;
	}
	public void setCreditServicesRemote(CreditServicesRemote creditServicesRemote) {
		this.creditServicesRemote = creditServicesRemote;
	}
	
	
	
	
	
	///////////insert  file///////////
	private static final int BUFFER_SIZE = 61240;   
    
    

    public void handleFileUpload( FileUploadEvent event) {
    	

    	
    	File result = new File("C:\\Users\\Joe\\Desktop\\images\\" + event.getFile().getFileName());
        demande.setFile(event.getFile().getFileName());
    	System.out.println("C:\\Users\\Joe\\Desktop\\images" + event.getFile().getFileName());
    

 
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
    	demande.setFile(event.getFile().getFileName());
    	
    	FacesMessage msg = new FacesMessage("Detail image", "nom image: " + event.getFile().getFileName() + "taille image: " + event.getFile().getSize() / 1024 + " Kb	content type: " + event.getFile().getContentType() + "image enregistrer.");
    	
    	FacesContext.getCurrentInstance().addMessage(null, msg);
    
    	
    
    	} catch (IOException e) {
    	
    	e.printStackTrace();
    
    	 
    
    	FacesMessage error = new FacesMessage(FacesMessage.SEVERITY_ERROR, "The files were not uploaded!", "");
    
    	FacesContext.getCurrentInstance().addMessage(null, error);
    	
    	}      
  
    	}



	public String getImage() {
		return Image;
	}



	public void setImage(String image) {
		Image = image;
	}
	
	
	
	
	
	

}
