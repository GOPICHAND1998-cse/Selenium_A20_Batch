package ddtpackage;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class WriteDataInNewRow
{
    public static void main(String[] args) {

        try
        {
            FileInputStream fis = new FileInputStream("./src/test/resources/TestData/UserInfo.xlsx");

            Workbook workbook = WorkbookFactory.create(fis);

            Sheet sheet = workbook.getSheet("UserCredintials");

            Row newRow = sheet.createRow(5);

            newRow.createCell(0).setCellValue("bruce@gmail.com");

            newRow.createCell(1).setCellValue("Password@0987");

            FileOutputStream fos = new FileOutputStream("./src/test/resources/TestData/UserInfo.xlsx");

            workbook.write(fos);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
