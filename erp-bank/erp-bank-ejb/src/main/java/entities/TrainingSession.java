package entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: TrainingSession
 *
 */
@Entity
@Table(name="T_TrainingSession")

public class TrainingSession implements Serializable {

	
	private Integer IdTrainingSession;
	private Date TrainingDate;
	private String Goal;
	private String CoachName;
	private static final long serialVersionUID = 1L;
	private HumanRessourceManager humanressourcemanager;


	public TrainingSession() {
		super();
	}   
	@Id    
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	public Integer getIdTrainingSession() {
		return this.IdTrainingSession;
	}

	public void setIdTrainingSession(Integer IdTrainingSession) {
		this.IdTrainingSession = IdTrainingSession;
	}   
	public Date getTrainingDate() {
		return this.TrainingDate;
	}

	public void setTrainingDate(Date TrainingDate) {
		this.TrainingDate = TrainingDate;
	}   
	public String getGoal() {
		return this.Goal;
	}

	public void setGoal(String Goal) {
		this.Goal = Goal;
	}   
	public String getCoachName() {
		return this.CoachName;
	}

	public void setCoachName(String CoachName) {
		this.CoachName = CoachName;
	}
	@ManyToOne
	public HumanRessourceManager getHumanressourcemanager() {
		return humanressourcemanager;
	}
	public void setHumanressourcemanager(HumanRessourceManager humanressourcemanager) {
		this.humanressourcemanager = humanressourcemanager;
	}
	
   
}
