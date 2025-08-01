 package utilities;

import org.testng.annotations.DataProvider;

import java.io.IOException;


public class DataProviders {

	// Dataprovider 1
	@DataProvider(name="LoginData")
	public String [][]getData() throws IOException
	{
		String path=".\\testData\\opencartData.xlsx"; // taking xl file from test data

		ExcelUtility xlutility=new ExcelUtility(path); // creating object for ExcelUtility 

		int totalRows=xlutility.getRowCount("Sheet1");
		int totalcols=xlutility.getCellCount("Sheet1",1);

		String [][]loginData=new String[totalRows][totalcols]; //creating two dimension array and stored the data 

		for (int i=1;i<=totalRows;i++)//read the data from xl storing in two dimension array
			// 1 is taking because 0 index is data heading is present
		{
			// Outer for loop represent the Row and innner loop represent the column
			for(int j=0; j<totalcols;j++)//0 i is the row and j is the column
			{
				loginData[i-1][j]=xlutility.getcellData("Sheet1", i, j);// 1,0
			}
		}
		return loginData;
	}
	// Dataprovider 2

	//Dataprovider 3

	//Dataprovider 4
}