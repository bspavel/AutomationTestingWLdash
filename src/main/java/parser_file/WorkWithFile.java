package parser_file;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.List;

public class WorkWithFile {
    public static String fileName = "./src/test/resources/test_data.xls";

    public static String read(String fileName) throws FileNotFoundException {
        try {
            FileInputStream file = new FileInputStream(new File(fileName));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);

        } catch (Exception e) {
            e.printStackTrace();
        }
        //return List<String> arr;
        return fileName;
    }
}
