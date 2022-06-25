package com.library.utilities;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadLibraryExcel {

    static String path = "Library.xlsx";

    public static List<String> getUserName() {
        List<String> list = new ArrayList<>();

        try{
            FileInputStream file = new FileInputStream(path);

            XSSFWorkbook workbook = new XSSFWorkbook(file);

            XSSFSheet sheet = workbook.getSheet("library2");
            sheet.getRow(0).getCell(1);

            int endNumber = sheet.getPhysicalNumberOfRows();

            for (int row = 0; row < endNumber; row++) {

                list.add(sheet.getRow(row).getCell(1).toString());

            }
        }catch (IOException e){

        }



        return list;

    }


    public static List<String> getPassword() {

        List<String> passwordList = new ArrayList<>();

        try{
            FileInputStream file = new FileInputStream(path);

            XSSFWorkbook workbook = new XSSFWorkbook(file);

            XSSFSheet sheet = workbook.getSheet("library2");

            int numberRow = sheet.getPhysicalNumberOfRows();



            for (int row = 0; row < numberRow; row++) {

                passwordList.add(sheet.getRow(row).getCell(2).toString());

            }
        }catch (IOException e){

        }


        return passwordList;
    }

    @Test
    public void abc() throws IOException {

        FileInputStream file = new FileInputStream(path);

        XSSFWorkbook workbook = new XSSFWorkbook(file);

        XSSFSheet sheet = workbook.getSheet("library2");

        sheet.getRow(0).getCell(1);

        List<String> list = new ArrayList<>();

        int endNumber = sheet.getPhysicalNumberOfRows();

        for (int row = 0; row < endNumber; row++) {

            list.add(sheet.getRow(row).getCell(1).toString());

        }

        System.out.println(list);

    }

    @Test
    public void pass() throws IOException {

        List<String> passwordList = new ArrayList<>();

            FileInputStream file = new FileInputStream(path);

            XSSFWorkbook workbook = new XSSFWorkbook(file);

            XSSFSheet sheet = workbook.getSheet("library2");

            int numberRow = sheet.getPhysicalNumberOfRows();



            for (int row = 0; row < numberRow; row++) {

                passwordList.add(sheet.getRow(row).getCell(2).toString());

            }
        System.out.println(passwordList);
    }


}
