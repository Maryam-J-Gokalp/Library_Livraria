package com.library.tests;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelRead {


    @Test
    public void read_from_excel_file() throws IOException {

        String path = "SampleData.xlsx";


            FileInputStream file = new FileInputStream(path);
            //workbook>sheet>row>cell
            //Create a workbook
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            //We need to get specific sheet from currently open workbook
            XSSFSheet sheet = workbook.getSheet("Employees");
            //Select row and cell
            //print out mary's cell
            //Indexes starts from 0

        System.out.println(sheet.getRow(1).getCell(0));

        //print out developer

        System.out.println(sheet.getRow(3).getCell(2));

        int usedRows = sheet.getPhysicalNumberOfRows();
        System.out.println(usedRows);

        int lastRows= sheet.getLastRowNum();
        System.out.println(lastRows);


        //Create a logic print Vindo Name


        for (int row = 0; row < usedRows ; row++) {
            if(sheet.getRow(row).getCell(0).toString().equals("Linda")){
                System.out.println(sheet.getRow(row).getCell(2));
            }
        }



    }

}
