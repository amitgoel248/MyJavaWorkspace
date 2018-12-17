package com.project.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel2 {

	private static final String FILE_NAME = "/home/amit.goel1/Desktop/change/Data_Blank.xlsx";
	private static final String dataFile = "/home/amit.goel1/Desktop/script1";

	public static void main(String[] args) {
		BufferedWriter bw = null;
		FileWriter fw = null;

		try {

			fw = new FileWriter(dataFile);
			bw = new BufferedWriter(fw);

			FileInputStream file = new FileInputStream(new File(FILE_NAME));
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = sheet.iterator();
			int count = 0;
			Map<String, Map<String, Integer>> map = new HashMap<>();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				// For each row, iterate through all the columns
				Iterator<Cell> cellIterator = row.cellIterator();

				while (cellIterator.hasNext()) 
				{
					String old = cellIterator.next().getStringCellValue();
					String newString = cellIterator.next().getStringCellValue();

					
					bw.write("curl -X POST \\\n" + 
							"  http://localhost:8080/configuration/api/execute-dynamic-query.jsn \\\n" + 
							"  -H 'Accept: application/json' \\\n" + 
							"  -H 'Cache-Control: no-cache' \\\n" + 
							"  -H 'Content-Type: application/json' \\\n" + 
							"  -H 'Postman-Token: 1e9021be-15af-466b-84e5-5669167655f6' \\\n" + 
							"  -d '{\n" + 
							"\"queryString\" : \"update custom_table_instance_column_data set `data` = '\\''"+newString+"'\\'' where custom_table_instance_id = '\\''163'\\'' and custom_table_instance_column_id = '\\''1393'\\'' and `data` = '\\''"+old+"'\\'';\"\n" + 
							"}'\n\n");
					
				}

				System.out.println(count++);
			}
			bw.flush();
			bw.close();
			file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static boolean okay(Map<String, Integer> map) {
		for (String key : map.keySet()) {
			if (map.get(key) > 1)
				return true;
		}
		return false;
	}

	private static String print(Map<String, Integer> map) {
		String ans = "";
		for (String key : map.keySet()) {
			ans += (key + "  - " + map.get(key) + "  ");
		}
		return ans;
	}

}
