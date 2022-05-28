package com.test.Utils;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;


public class ExcelFileUtils {

    public static FileInputStream fis;
    public static XSSFWorkbook workbook;
    public static XSSFSheet sheet;

    public static String getCellValueFromSheet(XSSFSheet sheet, String ColumnName, int row) {

        String CellValue = null;
        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
        for (int i = 0; i < colCount; i++) {
            if (sheet.getRow(0).getCell(i).toString().equals(ColumnName)) {
                CellValue = sheet.getRow(row).getCell(i).toString().trim();
                CellValue = (CellValue == null) ? "" : CellValue;
                break;
            }
        }
        return CellValue;
    }

    public static XSSFSheet returnExcelSheet(String FilePath, String SheetName) throws IOException {


        try {
            fis = new FileInputStream(new File(FilePath));
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheet(SheetName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return sheet;
    }

    public static void CLoseExcelSheet() throws IOException {
        fis.close();
        workbook.close();

    }


    public static Map LoadExcelDataIntoHashMap(XSSFSheet sheet, int row) throws IOException {

        Map<String, String> excelDatamap = new LinkedHashMap();
        String CellValue = null;
        String ColumnHeader = null;
        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
        for (int i = 0; i < colCount; i++) {
            CellValue = sheet.getRow(row).getCell(i).toString().trim();
            CellValue = (CellValue == null) ? "" : CellValue;
            ColumnHeader = sheet.getRow(0).getCell(i).toString().trim();
            excelDatamap.put(ColumnHeader, CellValue);

        }
        CLoseExcelSheet();
        return excelDatamap;
    }


}
