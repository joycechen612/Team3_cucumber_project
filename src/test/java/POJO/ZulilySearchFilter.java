package POJO;

public class ZulilySearchFilter {
	public String productName;
	public String brandName;
	public String departmentName;
	public String subcategories;
	public String priceRange;
	public String size;

	public ZulilySearchFilter(String productName, String brandName, String departmentName, String subcategories,
			String priceRange, String size) {
		super();
		this.productName = productName;
		this.brandName = brandName;
		this.departmentName = departmentName;
		this.subcategories = subcategories;
		this.priceRange = priceRange;
		this.size = size;
	}

}
