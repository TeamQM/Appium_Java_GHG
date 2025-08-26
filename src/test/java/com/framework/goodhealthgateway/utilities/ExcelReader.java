package com.framework.goodhealthgateway.utilities;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class ExcelReader {
    public static String excel(String label,String sheetname) throws Exception {
        // TODO Auto-generated method stub
        ArrayList<String> a = new ArrayList<>();
        FileInputStream inputStream = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/Files/TestData.XLSX");
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        int sheets = workbook.getNumberOfSheets();
        for (int i = 0; i < sheets; i++) {
            if (workbook.getSheetName(i).equalsIgnoreCase(sheetname)) {
                XSSFSheet sheet = workbook.getSheetAt(i);
                Iterator<Row> rows = sheet.rowIterator();
                Row firstrow = rows.next();
                Iterator<Cell> ce = firstrow.cellIterator();
                while (rows.hasNext()) {
                    Row r = rows.next();
                    if (r.getCell(0) != null) {
                        if (r.getCell(0).getStringCellValue().equalsIgnoreCase(label)) {
                            Iterator<Cell> c = r.cellIterator();
                            while (c.hasNext()) {
                                Cell cv= c.next();
                               // cv.
                                if(cv.getCellTypeEnum() == CellType.STRING)
                                {
                                    a.add(cv.getStringCellValue());
                                }
                                else{
                                    a.add(NumberToTextConverter.toText(cv.getNumericCellValue()));
                                }
                            }
                        }
                    }
                }
            }
        }
        return a.get(1);
    }
}
