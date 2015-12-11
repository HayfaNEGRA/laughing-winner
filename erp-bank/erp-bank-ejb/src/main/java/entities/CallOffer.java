package entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: CallOffer
 *
 */
@Entity
@Table(name="T_call_offer")

public class CallOffer implements Serializable {

	
	private Integer Id;
	private String Name;
	private String Description;
	private Date DateMax;
	private int Quantity;
	private float price;
	private boolean Provided;
	private  Provider provider ;
	private InventoryManager Inventory_Manager;
	private static final long serialVersionUID = 1L;

	public CallOffer() {
		super();
	}   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	public Integer getId() {
		return this.Id;
	}

	public void setId(Integer Id) {
		this.Id = Id;
	}   
	public String getDescription() {
		return this.Description;
	}

	public void setDescription(String Description) {
		this.Description = Description;
	}
	@ManyToOne
	@JoinColumn(name="id_prodvider")
	public Provider getProvider() {
		return provider;
	}
	public void setProvider(Provider provider) {
		this.provider = provider;
	}
	@ManyToOne
	@JoinColumn(name="id_Inventory_Manager")
	public InventoryManager getInventory_Manager() {
		return Inventory_Manager;
	}
	public void setInventory_Manager(InventoryManager inventory_Manager) {
		Inventory_Manager = inventory_Manager;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public Date getDateMax() {
		return DateMax;
	}
	public void setDateMax(Date dateMax) {
		DateMax = dateMax;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public boolean isProvided() {
		return Provided;
	}
	public void setProvided(boolean provided) {
		Provided = provided;
	}

   
}
