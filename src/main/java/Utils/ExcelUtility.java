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

    public Object[][] getExcelData(String filePath, String sheetName) {
        try {
            fileInputStream = new FileInputStream(filePath);
        } catch (FileNotFoundException f) {
            //log exception here
        }
        try {
            xssfWorkbook = new XSSFWorkbook(fileInputStream);
        } catch (IOException e) {
            //log exception here
            System.out.print(e.getMessage());
        }
        xssfSheet = xssfWorkbook.getSheet(sheetName);
        Object[][] sheetData = new Object[xssfSheet.getLastRowNum()][xssfSheet.getRow(1).getLastCellNum()];
        for (int i = 0; i < xssfSheet.getLastRowNum(); i++)
        {
            for(int j=0;j<xssfSheet.getRow(1).getLastCellNum();j++)
            {
                sheetData[i][j] = xssfSheet.getRow(i+1).getCell(j).getStringCellValue();
                System.out.println(sheetData[i][j]);
            }
            System.out.print("\n");
        }
        return sheetData;
    }

}
