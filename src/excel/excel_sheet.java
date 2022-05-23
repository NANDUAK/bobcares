package excel;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


	public class excel_sheet {

		static String ProjectPath;
		static XSSFSheet sheet;
		static XSSFWorkbook workbook;


		public  excel_sheet(String excel_path,String Sheet_name){

			try {
				workbook = new XSSFWorkbook(excel_path);
				sheet= workbook.getSheet(Sheet_name);

			} catch (IOException exp) {
				System.out.println(exp.getMessage());
				System.out.println(exp.getMessage());	
				exp.printStackTrace();
			}				
		}

		public static void main (String[] args){
			//		getRowCount();
			//		getCellDataNumber(0,0);
			//		getCellDataNumber(0,0);

		}

		public static  void getRowCount()  {

			try {

				int rowCount=sheet.getPhysicalNumberOfRows();
				System.out.println("NO of row count "+rowCount);

			} catch(Exception exp)

			{

				System.out.println(exp.getMessage());
				System.out.println(exp.getMessage());
				exp.printStackTrace();

			}

		}

		public String getCellDataString(int rowNum,int colNum) {
			String cell_data = null;
			try {

				cell_data=sheet.getRow(rowNum).getCell(colNum).getStringCellValue();		
				System.out.println(cell_data);

			} catch (Exception exp) {

				System.out.println(exp.getMessage());
				System.out.println(exp.getMessage());
				exp.printStackTrace();

			}

			return cell_data;

		}

		public  Integer getCellDataNumber(int rowNum,int colNum) {
			Integer cell_data = null;
			try {

				cell_data= (int) sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();		
				System.out.println(cell_data);

			} catch (Exception exp) {

				System.out.println(exp.getMessage());
				System.out.println(exp.getMessage());
				exp.printStackTrace();

			}

			return cell_data;

		}

	}


