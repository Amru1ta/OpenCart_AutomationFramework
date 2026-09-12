package Utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviderMultiple {

	@DataProvider (name="dp")
	public String[][] dataproviderofloginpge() throws IOException{
		String path = ".\\testData\\OpenaCartDataProvider_Data.xlsx";
		ExcelUtilities excel = new ExcelUtilities(path);
		int numberofrows = excel.getRowCount("sheet1");
		int numberofcol = excel.getCellCount("sheet1", 1);
		String data[] [] = new String [numberofrows][numberofcol];
		
		for (int i=1; i<numberofrows; i++) {
			for (int j=0; j<numberofcol; j++) {
				data [i-1][j] =  excel.getCellData("sheet1", i, j);
			}
		}
		return data;
		
	}
}
