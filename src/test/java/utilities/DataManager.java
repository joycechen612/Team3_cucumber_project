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

	public String getProductName() {
		assertNotNull(productName, "DataManager - productName is not available");
		return productName;
	}

	public void setproductName(String productName) {
		this.productName = productName;
	}


}
