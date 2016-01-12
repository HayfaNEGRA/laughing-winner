package beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SlideEndEvent;

@ManagedBean
@ViewScoped
public class SimulatorBean {
	
	private int months;
	private int poucentage;
	private int montant;
	private int income;
	private double resultat; 
	
	
	public SimulatorBean() {
	}

	
	public int getMonths() {
		return months;
	}


	public void setMonths(int months) {
		this.months = months;
	}


	public int getPoucentage() {
		return poucentage;
	}


	public void setPoucentage(int poucentage) {
		this.poucentage = poucentage;
	}


	public int getMontant() {
		return montant;
	}


	public void setMontant(int montant) {
		this.montant = montant;
	}


	public int getIncome() {
		return income;
	}


	public void setIncome(int income) {
		this.income = income;
	}


	public double getResultat() {
		return resultat;
	}


	public void setResultat(double resultat) {
		this.resultat = resultat;
	}
	
	public String goToStats()
	{
		return "simulator";
	}

	public void Calculer()
	{ 
		double p = (double)poucentage/100;
		double t = p/12;
		double x = montant * (p/12);
		double y = 1 -(Math.pow(1+t , -months));
		resultat = x/y;
		
		
	}
	
	
    

	

}
