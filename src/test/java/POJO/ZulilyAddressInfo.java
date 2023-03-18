package POJO;

public class ZulilyAddressInfo {
	public String firstName;
	public String lastName;
	public String company;
	public String address;
	public String city;
	public String country;
	public String state;
	public String zipCode;
	public String telephone;
	public String password;
	public boolean notSave;
	public boolean notSetDefault;

	public ZulilyAddressInfo(String firstName, String lastName, String company, String address, String city,
			String country, String state, String zipCode, String telephone, String password, boolean notSave,
			boolean notSetDefault) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.company = company;
		this.address = address;
		this.city = city;
		this.country = country;
		this.state = state;
		this.zipCode = zipCode;
		this.telephone = telephone;
		this.password = password;
		this.notSave = notSave;
		this.notSetDefault = notSetDefault;
	}

}
