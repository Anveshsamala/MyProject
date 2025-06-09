package myutilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class MyExcelReader {
		
		public static List<Map<String, String>> readDataFromExcel(String filepath, String sheetName) {
			List<Map<String, String>> allRowData=new ArrayList<>();
			try(FileInputStream fis=new FileInputStream(new File(filepath));
					Workbook workbook=new XSSFWorkbook(fis)){
				Sheet sheet=workbook.getSheet(sheetName);
				if(sheet==null)
				{
					 throw new IOException("Sheet with name '" + sheetName + "' not found.");
				}
				Row headerRow=sheet.getRow(0);
				if(headerRow==null) {
					throw new IOException("Header row is missing in the sheet.");
					
				}
				
				 Map<String, Integer> headerIndexMap = new HashMap<>();
		            for (int i = 0; i < headerRow.getPhysicalNumberOfCells(); i++) {
		                String headerName = headerRow.getCell(i).getStringCellValue().trim();
		                if (headerName != null && !headerName.isEmpty()) {
		                    headerIndexMap.put(headerName, i);
		                }
		            }
		            
		            for( int rowIndex=1; rowIndex<=sheet.getLastRowNum(); rowIndex++)
		            {
		            	Row dataRow=sheet.getRow(rowIndex);
		            	if(dataRow==null)continue;
		            	Map<String, String> rowData=new HashMap<>();
		            	
		            	for(Map.Entry<String, Integer> entry:headerIndexMap.entrySet()) {
		            		String header=entry.getKey();
		            		int columnIndex=entry.getValue();
		            		Cell cell=dataRow.getCell(columnIndex);
		            		 String cellValue = (cell != null) ? cell.toString().trim() : "";
		                     rowData.put(header, cellValue);
		            	}
		            	 allRowData.add(rowData);
		            	 
		            }
		            
		            
				}
			catch (IOException e) {
	            e.printStackTrace();
	        }

	        return allRowData;
	    }
}
