package ddtpackage;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;

public class ReadingDataFromMultiCells
{
    public static void main(String[] args)
    {
        try
        {
            FileInputStream fis = new FileInputStream("./src/test/resources/TestData/UserInfo.xlsx");

            Workbook workbook = WorkbookFactory.create(fis);

            Sheet sheet = workbook.getSheet("UserCredintials");

            int lastRow = sheet.getLastRowNum();

            int lastCell= sheet.getRow(0).getLastCellNum();

            for(int r=1;r<=lastRow;r++)
            {
                Row newRow = sheet.getRow(r);

                for(int c=0;c<lastCell;c++)
                {
                    String data = newRow.getCell(c).toString();

                    System.out.print(data+"  ");
                }
                System.out.println();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
