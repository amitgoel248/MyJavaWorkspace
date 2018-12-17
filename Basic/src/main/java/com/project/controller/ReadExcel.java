package com.project.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	private static final String FILE_NAME = "/home/amit.goel1/Desktop/data.xlsx";
	private static final String FILE_NAME2 = "/home/amit.goel1/Desktop/parents.xlsx";
	private static final String dataFile = "/home/amit.goel1/Desktop/tracedkingd";

	public static void main(String[] args) {
		BufferedWriter bw = null;
		FileWriter fw = null;

		Map<String, String> map1 = new HashMap<>();
		Map<String, String> map2 = new HashMap<>();
		ArrayList<String> list = new ArrayList<>();
		try {

			fw = new FileWriter(dataFile);
			bw = new BufferedWriter(fw);

			FileInputStream file = new FileInputStream(new File(FILE_NAME));
			FileInputStream file2 = new FileInputStream(new File(FILE_NAME2));

			// Create Workbook instance holding reference to .xlsx file
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFWorkbook workbook2 = new XSSFWorkbook(file2);
			// Get first/desired sheet from the workbook
			XSSFSheet sheet = workbook.getSheetAt(0);
			XSSFSheet sheet2 = workbook2.getSheetAt(0);
			// Iterate through each rows one by one
			Iterator<Row> rowIterator = sheet.iterator();
			Iterator<Row> rowIterator2 = sheet2.iterator();

			int count2 = 0;
			while (rowIterator2.hasNext()) {
				Row row2 = rowIterator2.next();
				// For each row, iterate through all the columns
				Iterator<Cell> cellIterator2 = row2.cellIterator();

				while (cellIterator2.hasNext()) {
					Cell cell = cellIterator2.next();
					cell.setCellType(Cell.CELL_TYPE_STRING);
					String parent = cell.getStringCellValue();
					map1.put(parent, "");
					map2.put(parent, "");
					list.add(parent);
				}

				System.out.println(count2++);
			}

			int count = 0;
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				// For each row, iterate through all the columns
				Iterator<Cell> cellIterator = row.cellIterator();

				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					cell.setCellType(Cell.CELL_TYPE_STRING);
					String p1 = cell.getStringCellValue();
					String v1 = cellIterator.next().getStringCellValue();
					String p221 = cellIterator.next().getStringCellValue();
//					cell = cellIterator.next();
//					cell.setCellType(Cell.CELL_TYPE_STRING);
//					String p2 = cell.getStringCellValue();
//					String v2;
//					try {
//						 v2 = cellIterator.next().getStringCellValue();
//					} catch (Exception e) {
//						e.printStackTrace();
//						v2 = "";
//					}
//					String psada = cellIterator.next().getStringCellValue();

					if (map1.containsKey(p1)) {
						map1.put(p1, map1.get(p1) + "," + v1);
					} else {
						System.out.println("problem");
						map1.put(p1, v1);
					}

//					if (map2.containsKey(p1)) {
//						map2.put(p1, map2.get(p1) + "," + v1);
//					} else {
//						System.out.println("problem");
//						map2.put(p1, v1);
//					}

				}

//				
				System.out.println(count++);
			}
			for (String ss : list)  
	            {
				bw.write(ss + 
						" = " + map1.get(ss) + "\n"); 
	            }
			
//			for (Map.Entry<String,String> entry : map2.entrySet())  
//				bw.write("Key = " + entry.getKey() + 
//	                             ", Value = " + entry.getValue()); 

			bw.flush();
			bw.close();
			file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
