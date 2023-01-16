package one_to_one_uni.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Person {
	@Id
	private int userId;
	private String name;
	private long phone;
	private String address;
	@OneToOne
	private AadharCard aadharCard;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public AadharCard getAadharCard() {
		return aadharCard;
	}
	public void setAadharCard(AadharCard aadharCard) {
		this.aadharCard = aadharCard;
	}
	@Override
	public String toString() {
		return "Person [userId=" + userId + ", name=" + name + ", phone=" + phone + ", address=" + address
				+ ", aadharCard=" + aadharCard + "]";
	}
	
	

}
