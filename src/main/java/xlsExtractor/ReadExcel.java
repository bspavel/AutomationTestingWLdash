package xlsExtractor;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ReadExcel {
    public static final String PATH_FILE_ALL_TEST_DATA = "./testData/allTestData.xlsx";
    public static String pathFileCompany = "./testData/company.xlsx";
    public static String pathFileVessel = "./testData/vessel.xlsx";

   // public static void mainstreamWorkBookExcel(){
    public static void main(String[]args){
        try {
            File allTestData = new File(PATH_FILE_ALL_TEST_DATA);
            if(allTestData.exists()&&!allTestData.isDirectory()){
                System.out.println("FILE with test data is absent");
            }
            FileInputStream streamAllTestData = new FileInputStream(allTestData);
            XSSFWorkbook workbookAllData = new XSSFWorkbook(streamAllTestData);

            XSSFSheet sheetCompany = workbookAllData.getSheetAt(0);
            Iterator<Row> rowIterator = sheetCompany.iterator();
            while(rowIterator.hasNext()){
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.iterator();
                while (cellIterator.hasNext()){
                    Cell cell = cellIterator.next();
                }
            }

            String a =sheetCompany.getRow(1).getCell(0).getStringCellValue();
            sheetCompany.getRow(1);
            sheetCompany.getRow(2);
            sheetCompany.getRow(3);
            sheetCompany.getRow(4);
            sheetCompany.getRow(5);
            sheetCompany.getRow(6);
            sheetCompany.getRow(7);
            sheetCompany.getRow(8);
            sheetCompany.getRow(9);
            sheetCompany.getRow(10);
            sheetCompany.getRow(11);
            sheetCompany.getRow(12);
            sheetCompany.getRow(13);
            sheetCompany.getRow(14);
            sheetCompany.getRow(15);
            sheetCompany.getRow(16);
            System.out.println(a);
            XSSFSheet sheetVessel = workbookAllData.getSheetAt(1);
            String b =sheetVessel.getRow(0).getCell(1).getStringCellValue();
            System.out.println(b);
            sheetVessel.getRow(0);
            sheetVessel.getRow(1);
            sheetVessel.getRow(2);
            sheetVessel.getRow(3);
            sheetVessel.getRow(4);
            sheetVessel.getRow(5);
            sheetVessel.getRow(6);
            sheetVessel.getRow(7);
            sheetVessel.getRow(8);
            sheetVessel.getRow(9);
            sheetVessel.getRow(10);
            sheetVessel.getRow(11);
            sheetVessel.getRow(12);
            sheetVessel.getRow(13);
            sheetVessel.getRow(14);
            sheetVessel.getRow(15);
            sheetVessel.getRow(16);
            sheetVessel.getRow(17);
            sheetVessel.getRow(18);
            sheetVessel.getRow(19);
            sheetVessel.getRow(20);
            sheetVessel.getRow(21);
            sheetVessel.getRow(22);
            sheetVessel.getRow(23);
            sheetVessel.getRow(24);
            sheetVessel.getRow(25);
            sheetVessel.getRow(26);
            sheetVessel.getRow(27);
            sheetVessel.getRow(28);
            sheetVessel.getRow(29);
            sheetVessel.getRow(30);
            sheetVessel.getRow(31);
            sheetVessel.getRow(32);
            sheetVessel.getRow(33);

        }catch(FileNotFoundException fne){
            fne.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
