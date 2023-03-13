package utilities;

import static org.junit.jupiter.api.Assertions.assertNotNull;

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

}
