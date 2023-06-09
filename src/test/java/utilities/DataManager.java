package utilities;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import POJO.AddressInfo;
import POJO.SearchFilter;

public class DataManager {

	// Data Manager
	private static DataManager dataManager;

	private DataManager() {
	};

	public static DataManager getInstance() {
		if (dataManager == null) {
			dataManager = new DataManager();
		}
		return dataManager;
	}

	public static void cleanUp() {
		if (dataManager != null) {
			dataManager = null;
		}
	}

	// Data
	private String productName;
	private String orderQty;
	private int lowPrice;
	private int highPrice;
	private SearchFilter zulilySearchFilter;
	private AddressInfo addressinfo;

	public int getLowPrice() {
		assertNotNull(lowPrice, "DataManager - lowPrice is not available");
		return lowPrice;
	}

	public void setLowPrice(int lowPrice) {
		this.lowPrice = lowPrice;
	}

	public int getHighPrice() {
		assertNotNull(highPrice, "DataManager - highPrice is not available");
		return highPrice;
	}

	public void setHighPrice(int highPrice) {
		this.highPrice = highPrice;
	}

	public String getProductName() {
		assertNotNull(productName, "DataManager - productName is not available");
		return productName;
	}

	public void setproductName(String productName) {
		this.productName = productName;
	}

	public String getOrderQty() {
		assertNotNull(orderQty, "DataManager - order quantity is not available");
		return orderQty;
	}

	public void setOrderQty(String orderQty) {
		this.orderQty = orderQty;
	}

	public SearchFilter getzulilySearchFilter() {
		assertNotNull(zulilySearchFilter, "DataManager - zulilySearchFilter is not available");
		return zulilySearchFilter;
	}

	public void setzulilySearchFilter(SearchFilter zulilySearchFilter) {
		this.zulilySearchFilter = zulilySearchFilter;
	}

	public AddressInfo getAddressinfo() {
		assertNotNull(addressinfo, "DataManager - addressinfo is not available");
		return addressinfo;
	}

	public void setAddressinfo(AddressInfo addressinfo) {
		this.addressinfo = addressinfo;
	}

}
