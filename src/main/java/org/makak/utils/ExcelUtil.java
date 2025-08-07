package org.makak.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelUtil {

    public static List<String[]> getData(String filePath, String sheetName) {
        List<String[]> data = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            Iterator<Row> rowIterator = sheet.iterator();

            rowIterator.next(); // header'ı atla

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                int columnCount = row.getLastCellNum();
                String[] rowData = new String[columnCount];

                for (int i = 0; i < columnCount; i++) {
                    Cell cell = row.getCell(i, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    rowData[i] = cell.toString().trim();
                }

                data.add(rowData);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }
}
