package xlsExtractor;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

/**
 * @author Sasha on 3/16/2016.
 */
public class XlsExtractor {

    public static void main(String[] args) throws IOException {



        // Specify the file path which you want to create or write
    try

    {

        File src = new File("./src/test/resources/testDataXLS/test.xlsx");

        // Load the file

        FileInputStream fis = new FileInputStream(src);

        // load the workbook

        XSSFWorkbook wb = new XSSFWorkbook(fis);

        // get the sheet which you want to modify or create

        XSSFSheet sh1 = wb.getSheetAt(0);
        sh1.getFirstHeader();
        System.out.println(sh1.getFirstHeader().toString());
        XSSFRow row;

        // getRow specify which row we want to read and getCell which column

        System.out.println(sh1.getRow(0).getCell(0).getStringCellValue());

        System.out.println(sh1.getRow(0).getCell(1).getStringCellValue());

        System.out.println(sh1.getRow(1).getCell(0).getStringCellValue());

        System.out.println(sh1.getRow(1).getCell(1).getStringCellValue());
        System.out.println("\nSecond type");
        Iterator<Row> rowIterator = sh1.iterator();
        while (rowIterator.hasNext()) {
            row = (XSSFRow) rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                System.out.println(cell.getStringCellValue());
            }
            System.out.println();

        }

// here createCell will create column

// and setCellvalue will set the value

//        sh1.getRow(0).createCell(2).setCellValue("2.41.0");
//
//        sh1.getRow(1).createCell(2).setCellValue("2.5");
//
//        sh1.getRow(2).createCell(2).setCellValue("2.39");
//
//
//// here we need to specify where you want to save file
//
//        FileOutputStream fout = new FileOutputStream(new File("location of file/filename.xlsx"));
//
//
//// finally write content
//
//        wb.write(fout);
//
//// close the file
//
//        fout.close();


    }catch(Exception io){
        io.printStackTrace();
    }
    }
}







