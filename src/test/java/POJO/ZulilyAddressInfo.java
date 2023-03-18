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
	public boolean save;
	public boolean setDeault;

	public ZulilyAddressInfo(String firstName, String lastName, String company, String address, String city,
			String country, String state, String zipCode, String telephone, String password, boolean save,
			boolean setDeault) {
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
		this.save = save;
		this.setDeault = setDeault;
	}

}
