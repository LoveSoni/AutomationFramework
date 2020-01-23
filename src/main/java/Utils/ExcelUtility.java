package Utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Logger;

public class ExcelUtility {
    private FileInputStream fileInputStream;
    private XSSFWorkbook xssfWorkbook;
    private XSSFSheet xssfSheet;

    public Object[][] getExcelData(String sheetPath, String sheetName) {
        try {
            fileInputStream = new FileInputStream(sheetPath);
        } catch (FileNotFoundException f) {
            //log exception here
        }
        try {
            xssfWorkbook = new XSSFWorkbook(fileInputStream);
        } catch (IOException e) {
            //log exception here
        }
        xssfSheet = xssfWorkbook.getSheet(sheetName);
        Object[][] sheetData = new Object[xssfSheet.getLastRowNum()][xssfSheet.getRow(1).getLastCellNum()];
        for (int i = 1; i < xssfSheet.getLastRowNum(); i++)
        {
            for(int j=0;j<xssfSheet.getRow(1).getLastCellNum();j++)
            {
                sheetData[i][j] = xssfSheet.getRow(i).getCell(j).getDateCellValue();
            }
        }
        return sheetData;
    }
}
