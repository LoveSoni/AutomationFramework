package Utils;

import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelUtility {
    private FileInputStream fileInputStream;
    private XSSFWorkbook xssfWorkbook;
    private XSSFSheet xssfSheet;
    private Logger logger = Logger.getLogger(ExcelUtility.class);

    public Object[][] getExcelData(String filePath, String sheetName) {
        try {
            fileInputStream = new FileInputStream(filePath);
        } catch (FileNotFoundException e) {
            logger.error(e.getMessage());
        }
        try {
            xssfWorkbook = new XSSFWorkbook(fileInputStream);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        xssfSheet = xssfWorkbook.getSheet(sheetName);
        Object[][] sheetData = new Object[xssfSheet.getLastRowNum()][xssfSheet.getRow(1).getLastCellNum()];
        for (int i = 0; i < xssfSheet.getLastRowNum(); i++)
        {
            for(int j=0;j<xssfSheet.getRow(1).getLastCellNum();j++)
            {
                sheetData[i][j] = xssfSheet.getRow(i+1).getCell(j).getStringCellValue();
            }
        }
        return sheetData;
    }

}
