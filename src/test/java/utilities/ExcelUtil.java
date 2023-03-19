package utilities;

import java.io.FileOutputStream;
import java.sql.Timestamp;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import POJO.SearchResult;

public class ExcelUtil {
	

	public static void writeZulilySearchResultToFile(List<SearchResult> results, String productName) {
		DataManager dataManager = DataManager.getInstance();
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet(productName);

		XSSFRow firstRow = sheet.createRow(0);
		firstRow.createCell(0).setCellValue("ID");
		firstRow.createCell(1).setCellValue("Price");
		firstRow.createCell(2).setCellValue("Title");

		int rowNum = 1;
		for (SearchResult result : results) {
			XSSFRow row = sheet.createRow(rowNum);
			row.createCell(0).setCellValue(result.id);
			row.createCell(1).setCellValue(result.priceRange);
			row.createCell(2).setCellValue(result.title);
			rowNum++;
		}
		
		

		XSSFRow brandNameRow = sheet.createRow(results.size() + 1);
		brandNameRow.createCell(0).setCellValue("brandName");
		brandNameRow.createCell(1).setCellValue(dataManager.getzulilySearchFilter().brandName);
		XSSFRow departmentNameRow = sheet.createRow(results.size() + 2);
		departmentNameRow.createCell(0).setCellValue("departmentName");
		departmentNameRow.createCell(1).setCellValue(dataManager.getzulilySearchFilter().departmentName);
		XSSFRow subcategoriesRow = sheet.createRow(results.size() + 3);
		subcategoriesRow.createCell(0).setCellValue("subcategories");
		subcategoriesRow.createCell(1).setCellValue(dataManager.getzulilySearchFilter().subcategories);
		XSSFRow priceRangeRow = sheet.createRow(results.size() + 4);
		priceRangeRow.createCell(0).setCellValue("priceRange");
		priceRangeRow.createCell(1).setCellValue(dataManager.getzulilySearchFilter().priceRange);
		XSSFRow sizeRow = sheet.createRow(results.size() + 5);
		sizeRow.createCell(0).setCellValue("size");
		sizeRow.createCell(1).setCellValue(dataManager.getzulilySearchFilter().size);

		try {
			FileOutputStream fos = new FileOutputStream("target/zulilySearch" + getTimeStamp() + ".xlsx");
			workbook.write(fos);

			workbook.close();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static long getTimeStamp() {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		return timestamp.getTime();
	}

}
