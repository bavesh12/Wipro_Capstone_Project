package pages;


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ExcelReader {
    public static Map<String, String> getCheckoutData(String filePath, String sheetName) throws IOException {
        Map<String, String> data = new HashMap<>();
        FileInputStream file = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheet(sheetName);
        
        // Get header row
        Row headerRow = sheet.getRow(0);
        // Get data row (assuming row 1 has the data)
        Row dataRow = sheet.getRow(1);
        
        for (int i = 0; i < headerRow.getLastCellNum(); i++) {
            String header = headerRow.getCell(i).getStringCellValue();
            String value = dataRow.getCell(i).getStringCellValue();
            data.put(header, value);
        }
        
        workbook.close();
        file.close();
        return data;
    }
}