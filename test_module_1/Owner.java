package test_module_1;

import test_module_1.Date;

public class Owner {
	private String name;
	private Date date_of_birth;
	private String nic;
	public Owner(String name, Date date_of_birth, String nic) {
		this.name = name;
		this.date_of_birth = date_of_birth;
		this.nic = nic;
	}
	
	public Owner() {
	}
	
	public Owner(Owner owner) {
		this.name = owner.getName();
		this.date_of_birth = owner.date_of_birth;
		this.nic = owner.nic;
	}

	@Override
	public String toString() {
		date_of_birth.toString();
		return "Owner [name=" + name + ", nic=" + nic + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public String getNic() {
		return nic;
	}

	public void setNic(String nic) {
		this.nic = nic;
	}
	
}
