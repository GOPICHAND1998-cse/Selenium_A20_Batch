package ddtpackage;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class WriteDataInExistingRowNewCell
{
    public static void main(String[] args) {

        try
        {
            FileInputStream fis = new FileInputStream("./src/test/resources/TestData/UserInfo.xlsx");

            Workbook workbook = WorkbookFactory.create(fis);

            Sheet sheet = workbook.getSheet("UserCredintials");

            Row row  = sheet.getRow(0);

            Cell newCell = row.createCell(2);

            newCell.setCellValue("Mobile");

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
