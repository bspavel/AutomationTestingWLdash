package xlsExtractor;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;


public class ReadExcel {
    public static final String PATH_FILE_ALL_TEST_DATA = "./testData/allTestData.xlsx";

    public static void main(String[] args) {
        ArrayList arr = new ArrayList();

        try {
            File testDataFile = new File(PATH_FILE_ALL_TEST_DATA);

            if (testDataFile.exists() && !testDataFile.isDirectory()) {
                System.out.println("FILE with test data is absent");
            }

            FileInputStream streamAllTestData = new FileInputStream(testDataFile);
            XSSFWorkbook wbTestData = new XSSFWorkbook(streamAllTestData);
            switch(typePage){
                case "company"
                case "vessel"
            }

            //company page
            XSSFSheet sheet = wbTestData.getSheetAt(0);
            int rowNum = sheet.getLastRowNum() + 1;
            int cellNum = sheet.getRow(0).getLastCellNum();

            Iterator rows = sheetCompany.rowIterator();
            // Iterator<Row> rowIterator = sheetCompany.iterator();
            while (rows.hasNext()) {
                XSSFRow row1 = (XSSFRow) rows.next();
                //Row row1 = rowIterator.next();
                Iterator cells = row1.cellIterator();
                //Iterator<Cell> cellIterator = row.iterator();
                while (cells.hasNext()) {
                    XSSFCell cell1 = (XSSFCell) cells.next();
                    arr.add(cell1);
                    // arr.add(cell.getStringCellValue());
                }
            }
            System.out.println(arr);
//            String a = sheetCompany.getRow(1).getCell(0).getStringCellValue();
//
//            sheetCompany.getRow(16);
//            System.out.println(a);
//            XSSFSheet sheetVessel = wbTestData.getSheetAt(1);
//            String b = sheetVessel.getRow(0).getCell(1).getStringCellValue();
//            System.out.println(b);
//            sheetVessel.getRow(0);
//
//
//            sheetVessel.getRow(33);

        } catch (FileNotFoundException fne) {
            fne.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
    }

    public static void createExcelSheet(int typePage){

    }
}
