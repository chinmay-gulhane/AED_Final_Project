package edu.neu.wasteManagement.utility;

import edu.neu.wasteManagement.business.Business;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ImportDataFile {

    public static void read(Business business, String filePath) {
        try (FileInputStream fileInputStream = new FileInputStream(new File(filePath));
            Workbook workbook = new XSSFWorkbook(fileInputStream)) {
            readCustomer(business, workbook);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void readCustomer(Business business, Workbook workbook){
        Sheet custom = workbook.getSheetAt(0);
        Iterator<Row> customerSheet = custom.iterator();
        while (customerSheet.hasNext()) {
             Row row = customerSheet.next();
             
          if (row.getRowNum() == 0) {
                continue;
            }
            
        }
    }
  
}
