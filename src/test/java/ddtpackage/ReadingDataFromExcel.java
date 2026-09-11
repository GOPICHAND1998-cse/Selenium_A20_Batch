package ddtpackage;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;

public class ReadingDataFromExcel
{
    public static void main(String[] args)
    {
        try
        {
            FileInputStream fis = new FileInputStream("./src/test/resources/TestData/UserInfo.xlsx");

           Workbook workbook = WorkbookFactory.create(fis);

           Sheet sheet = workbook.getSheet("UserCredintials");

           Row row = sheet.getRow(1);

           Cell cell = row.getCell(0);

            System.out.println(cell.getStringCellValue());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


    }
}
