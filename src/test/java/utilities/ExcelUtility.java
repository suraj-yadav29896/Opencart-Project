package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	public FileInputStream Fi;
	public FileOutputStream Fo;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public XSSFCellStyle style;
	String path;

	public ExcelUtility(String path)
	{
		this.path=path;
	}
	public int getRowCount(String sheetname) throws IOException
	{
		Fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(Fi);
		sheet=workbook.getSheet(sheetname);
		int RowCount=sheet.getLastRowNum();
		workbook.close();
		Fi.close();
		return RowCount;
	}
	public int getCellCount(String sheetName,int rownum) throws IOException
	{
		Fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(Fi);
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rownum);
		int CellCount= row.getLastCellNum();
		workbook.close();
		Fi.close();
		return CellCount;
	}
	public String getcellData(String sheetName,int rownum,int colnum) throws IOException
	{
		Fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(Fi);
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rownum);
		cell=row.getCell(colnum);
		DataFormatter formater =new DataFormatter();
		String data;
		try {
			data=formater.formatCellValue(cell);//return formated value as string format
		}
		catch(Exception e)
		{
			data="";

		}
		workbook.close();
		Fi.close();
		return data;

	}

}
