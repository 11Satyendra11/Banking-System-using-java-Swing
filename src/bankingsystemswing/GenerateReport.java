package bankingsystemswing;

import java.io.FileOutputStream;
import java.io.OutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;

public class GenerateReport {

    GenerateReport()
    {
	Workbook wb = new HSSFWorkbook();  
	
	try(OutputStream fileOut = new FileOutputStream("Generated Report.xls")) {  
	    Sheet sheet1 = (Sheet) wb.createSheet("Main Sheet"); 
	    
	    Row row     = ((org.apache.poi.ss.usermodel.Sheet) sheet1).createRow(2);  
            Cell cell   = row.createCell(5);  
            cell.setCellValue("Satyenda Chandan is there!!! !!!!! !!!");  
	    wb.write(fileOut);  
            
        }catch(Exception e) {  
            System.out.println(e.getMessage());  
        }  
	
    }
}
