package one_to_one_uni.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AadharCard {
	@Id
	private int aadharId;
	private String name;
	private String address;
	
	public int getAadharId() {
		return aadharId;
	}
	public void setAadharId(int aadharId) {
		this.aadharId = aadharId;
	}
	@Override
	public String toString() {
		return "AadharCard [aadharId=" + aadharId + ", name=" + name + ", address=" + address + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	

}
