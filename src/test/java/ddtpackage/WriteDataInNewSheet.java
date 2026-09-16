package ddtpackage;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class WriteDataInNewSheet
{
    public static void main(String[] args) {

        try
        {
            FileInputStream fis = new FileInputStream("./src/test/resources/TestData/UserInfo.xlsx");

            Workbook workbook = WorkbookFactory.create(fis);

            Sheet newSheet = workbook.createSheet("newCreatedSheet");

            Row newSheetRow = newSheet.createRow(0);

            newSheetRow.createCell(0).setCellValue("NewCell_1");

            newSheetRow.createCell(1).setCellValue("NewCell_2");

            FileOutputStream fos = new FileOutputStream("./src/test/resources/TestData/UserInfo.xlsx");

            workbook.write(fos);

            workbook.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


    }
}
