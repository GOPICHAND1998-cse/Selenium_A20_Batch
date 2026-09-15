package ddtpackage;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;

public class ReadingAllDynamicDataFromExcel
{
    public static void main(String[] args)
    {
     try
     {
         FileInputStream fis = new FileInputStream("./src/test/resources/TestData/DDT_UserCredintials.xlsx");

         Workbook workbook = WorkbookFactory.create(fis);

         Sheet sheet  = workbook.getSheet("DynamicCredentials");

         int firstRow= sheet.getFirstRowNum();
         int lastRow = sheet.getLastRowNum();

         int firstCell = sheet.getRow(firstRow).getFirstCellNum();
         int lastCell = sheet.getRow(firstRow).getLastCellNum();

         for(int r=firstRow+1;r<=lastRow;r++)
         {
             Row newRow = sheet.getRow(r);

             for(int c=firstCell;c<lastCell;c++)
             {
                 String data= newRow.getCell(c).toString();

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
