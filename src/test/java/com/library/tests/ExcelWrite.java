package com.library.tests;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.*;

public class ExcelWrite {

    String path = "SampleData.xlsx";

    XSSFWorkbook workbook;
    XSSFSheet sheet;

    @Test
    public void write_excel_file() throws IOException {

        FileInputStream file = new FileInputStream(path);
        workbook = new XSSFWorkbook(file);
        sheet = workbook.getSheet("Employees");


        XSSFCell salaryCell = sheet.getRow(0).createCell(3);

        salaryCell.setCellValue("Salary");

        XSSFCell salary1 = sheet.getRow(1).createCell(3);
        salary1.setCellValue("$12000");

        XSSFCell salary2 = sheet.getRow(2).createCell(3);
        salary2.setCellValue("$12000");

        XSSFCell salary3 = sheet.getRow(3).createCell(3);
        salary3.setCellValue("$12000");

        XSSFCell salary4 = sheet.getRow(4).createCell(3);
        salary4.setCellValue("$12000");
        
        
        //Change mary s lastname as Jones

        for (int row = 0; row < sheet.getLastRowNum(); row++) {
            if(sheet.getRow(row).getCell(0).toString().equals("Mary")){
                sheet.getRow(row).getCell(1).setCellValue("Jones");
            }
        }

        FileOutputStream writeOutput = new FileOutputStream(path);
        workbook.write(writeOutput);

        writeOutput.close();
        file.close();
        workbook.close();


    }
}
