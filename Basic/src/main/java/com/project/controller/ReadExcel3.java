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

public class ReadExcel3 {

	private static final String FILE_NAME = "/home/amit.goel1/Desktop/trackFRS.xlsx";
	private static final String dataFile = "/home/amit.goel1/Desktop/trackingRFS";

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
					Cell cell = cellIterator.next();
					cell.setCellType(Cell.CELL_TYPE_STRING);
					String rowIndex = cell.getStringCellValue();
					
					cell = cellIterator.next();
					cell.setCellType(Cell.CELL_TYPE_STRING);
					String parent = cell.getStringCellValue();
					
					String channel = cellIterator.next().getStringCellValue();
					Boolean boo = cellIterator.next().getBooleanCellValue();
					
					cell = cellIterator.next();
					cell.setCellType(Cell.CELL_TYPE_STRING);
					String product = cell.getStringCellValue();

					cell = cellIterator.next();
					cell.setCellType(Cell.CELL_TYPE_STRING);
					String cid = cell.getStringCellValue();
					cell = cellIterator.next();
					cell.setCellType(Cell.CELL_TYPE_STRING);
					String bid = cell.getStringCellValue();
					cell = cellIterator.next();
					cell.setCellType(Cell.CELL_TYPE_STRING);
					String uid = cell.getStringCellValue();
					cell = cellIterator.next();
					cell.setCellType(Cell.CELL_TYPE_STRING);
					String gid = cell.getStringCellValue();
					
					bw.write("curl -X POST \\\n" + 
							"  http://localhost:8080/configuration/api/data-insert-data-table.jsn \\\n" + 
							"  -H 'Accept: application/json' \\\n" + 
							"  -H 'Cache-Control: no-cache' \\\n" + 
							"  -H 'Content-Type: application/json' \\\n" + 
							"  -H 'Postman-Token: 64d7eb8c-bf85-4ebe-9b71-36c5522507ad' \\\n" + 
							"  -d '{\n" + 
							"  \"rowIndices\": [\n" + 
							"    "+rowIndex+"\n" + 
							"  ],\n" + 
							"  \"customTableDataDto\": [\n" + 
							"    {\n" + 
							"      \"customTableInstanceId\": \"206\",\n" + 
							"      \"customTableInstanceColumnId\": \"1690\",\n" + 
							"      \"data\": \"netRemmittCodes\"\n" + 
							"    },\n" + 
							"    {\n" + 
							"      \"customTableInstanceId\": \"206\",\n" + 
							"      \"customTableInstanceColumnId\": \"1691\"\n" + 
							"    },\n" + 
							"    {\n" + 
							"      \"customTableInstanceId\": \"206\",\n" + 
							"      \"customTableInstanceColumnId\": \"1692\"\n" + 
							"    },\n" + 
							"    {\n" + 
							"      \"customTableInstanceId\": \"206\",\n" + 
							"      \"customTableInstanceColumnId\": \"1693\"\n" + 
							"    },\n" + 
							"    {\n" + 
							"      \"customTableInstanceId\": \"206\",\n" + 
							"      \"customTableInstanceColumnId\": \"1694\"\n" + 
							"    },\n" + 
							"    {\n" + 
							"      \"customTableInstanceId\": \"206\",\n" + 
							"      \"customTableInstanceColumnId\": \"1695\"\n" + 
							"    },\n" + 
							"    {\n" + 
							"      \"customTableInstanceId\": \"206\",\n" + 
							"      \"customTableInstanceColumnId\": \"1696\"\n" + 
							"    },\n" + 
							"    {\n" + 
							"      \"customTableInstanceId\": \"206\",\n" + 
							"      \"customTableInstanceColumnId\": \"1697\",\n" + 
							"      \"data\": \""+cid+"\"\n" + 
							"    },\n" + 
							"     {\n" + 
							"      \"customTableInstanceId\": \"206\",\n" + 
							"      \"customTableInstanceColumnId\": \"1698\",\n" + 
							"      \"data\": \""+bid+"\"\n" + 
							"    },\n" + 
							"    {\n" + 
							"      \"customTableInstanceId\": \"206\",\n" + 
							"      \"customTableInstanceColumnId\": \"1699\",\n" + 
							"      \"data\": \""+uid+"\"\n" + 
							"    },\n" + 
							"    {\n" + 
							"      \"customTableInstanceId\": \"206\",\n" + 
							"      \"customTableInstanceColumnId\": \"1700\",\n" + 
							"      \"data\": \""+parent+"\"\n" + 
							"    },\n" + 
							"    {\n" + 
							"      \"customTableInstanceId\": \"206\",\n" + 
							"      \"customTableInstanceColumnId\": \"1701\",\n" + 
							"      \"data\": \"LIST\"\n" + 
							"    },\n" + 
							"    {\n" + 
							"      \"customTableInstanceId\": \"206\",\n" + 
							"      \"customTableInstanceColumnId\": \"1702\",\n" + 
							"      \"data\": \""+channel+"\"\n" + 
							"    },\n" + 
							"    {\n" + 
							"      \"customTableInstanceId\": \"206\",\n" + 
							"      \"customTableInstanceColumnId\": \"1703\",\n" + 
							"      \"data\": \""+boo+"\"\n" + 
							"    },\n" + 
							"    {\n" + 
							"      \"customTableInstanceId\": \"206\",\n" + 
							"      \"customTableInstanceColumnId\": \"1704\",\n" + 
							"      \"data\": \""+gid+"\"\n" + 
							"    },\n" + 
							"    {\n" + 
							"      \"customTableInstanceId\": \"206\",\n" + 
							"      \"customTableInstanceColumnId\": \"1705\",\n" + 
							"      \"data\": \""+product+"\"\n" + 
							"    },\n" + 
							"     {\n" + 
							"      \"customTableInstanceId\": \"206\",\n" + 
							"      \"customTableInstanceColumnId\": \"1706\"\n" + 
							"    },\n" + 
							"    {\n" + 
							"      \"customTableInstanceId\": \"206\",\n" + 
							"      \"customTableInstanceColumnId\": \"1707\",\n" + 
							"      \"data\": \"netRemmittCode\"\n" + 
							"    },\n" + 
							"    {\n" + 
							"      \"customTableInstanceId\": \"206\",\n" + 
							"      \"customTableInstanceColumnId\": \"1708\",\n" + 
							"      \"data\": \"netRemmittValue\"\n" + 
							"    },\n" + 
							"    {\n" + 
							"      \"customTableInstanceId\": \"206\",\n" + 
							"      \"customTableInstanceColumnId\": \"1831\"\n" + 
							"    },\n" + 
							"    {\n" + 
							"      \"customTableInstanceId\": \"206\",\n" + 
							"      \"customTableInstanceColumnId\": \"1832\"\n" + 
							"    },\n" + 
							"    {\n" + 
							"      \"customTableInstanceId\": \"206\",\n" + 
							"      \"customTableInstanceColumnId\": \"1833\"\n" + 
							"    },\n" + 
							"    {\n" + 
							"      \"customTableInstanceId\": \"206\",\n" + 
							"      \"customTableInstanceColumnId\": \"2175\"\n" + 
							"    },\n" + 
							"    {\n" + 
							"      \"customTableInstanceId\": \"206\",\n" + 
							"      \"customTableInstanceColumnId\": \"2176\"\n" + 
							"    }\n" + 
							"  ]\n" + 
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
