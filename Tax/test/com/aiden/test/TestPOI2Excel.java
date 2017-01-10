package com.aiden.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

public class TestPOI2Excel {

	@Test
	public void testWrite03Excel() throws Exception{
		//create workbook
		HSSFWorkbook workbook = new HSSFWorkbook();
		//create sheet
		HSSFSheet sheet = workbook.createSheet("hello world");
		//create row
		HSSFRow row = sheet.createRow(3);
		//create cell
		HSSFCell cell = row.createCell(3);
		cell.setCellValue("hello world");
		//output harddisk
		FileOutputStream outputStream = new FileOutputStream("E:\\aiden\\test.xls");
		workbook.write(outputStream);
		workbook.close();
		outputStream.close();
	}
	
	@Test
	public void testRead03Excel() throws Exception{
		FileInputStream inputStream = new FileInputStream("E:\\aiden\\test.xls");
		//read workbook
		HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
		//read sheet
		HSSFSheet sheet = workbook.getSheetAt(0);
		//read row
		HSSFRow row = sheet.getRow(3);
		//read cell
		HSSFCell cell = row.getCell(3);
		cell.setCellValue("hello world");
		System.out.println("第四行第四列的值：" + cell.getStringCellValue());

		workbook.close();
		inputStream.close();
	}
	
	@Test
	public void testWrite07Excel() throws Exception{
		//create workbook
		XSSFWorkbook workbook = new XSSFWorkbook();
		//create sheet
		XSSFSheet sheet = workbook.createSheet("hello world");
		//create row
		XSSFRow row = sheet.createRow(3);
		//create cell
		XSSFCell cell = row.createCell(3);
		cell.setCellValue("hello world");
		//output harddisk
		FileOutputStream outputStream = new FileOutputStream("E:\\aiden\\test.xlsx");
		workbook.write(outputStream);
		workbook.close();
		outputStream.close();
	}
	
	@Test
	public void testRead07Excel() throws Exception{
		FileInputStream inputStream = new FileInputStream("E:\\aiden\\test.xlsx");
		//read workbook
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		//read sheet
		XSSFSheet sheet = workbook.getSheetAt(0);
		//read row
		XSSFRow row = sheet.getRow(3);
		//read cell
		XSSFCell cell = row.getCell(3);
		cell.setCellValue("hello world");
		System.out.println("第四行第四列的值：" + cell.getStringCellValue());

		workbook.close();
		inputStream.close();
	}
	
	@Test
	public void testRead03And07Excel() throws Exception{
		String fileName = "E:\\aiden\\test.xlsx";
		boolean is03Excel = true;
		FileInputStream inputStream = new FileInputStream(fileName);
//		System.out.println(fileName.substring(fileName.lastIndexOf('.')));
		if(fileName.substring(fileName.lastIndexOf('.')).equals(".xlsx")){
			is03Excel = false;
		}
//		System.out.println(is03Excel);
		//read workbook
		Workbook workbook =is03Excel? new HSSFWorkbook(inputStream):new XSSFWorkbook(inputStream);
		//read sheet
		Sheet sheet = workbook.getSheetAt(0);
		//read row
		Row row = sheet.getRow(3);
		//read cell
		Cell cell = row.getCell(3);
		System.out.println("第四行第四列的值：" + cell.getStringCellValue());

		workbook.close();
		inputStream.close();
	}
	
	@Test
	public void testExcelStyle() throws Exception {
		//1、创建工作簿
		HSSFWorkbook workbook = new HSSFWorkbook();
		//1.1、创建合并单元格对象;合并第3行的第3列到第5列
		CellRangeAddress cellRangeAddress = new CellRangeAddress(3, 3, 3, 5);//起始行号，结束行号，起始列号，结束列号
		//1.2、创建单元格样式
		HSSFCellStyle style = workbook.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);//水平居中
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//垂直居中
		//1.3、创建字体
		HSSFFont font = workbook.createFont();
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//加粗字体
		font.setFontHeightInPoints((short) 16);//设置字体大小
		//加载字体
		style.setFont(font);
		
		//单元格背景
		//设置背景填充模式
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		//设置填充背景色
		style.setFillBackgroundColor(HSSFColor.YELLOW.index);
		//设置填充前景色
		style.setFillForegroundColor(HSSFColor.RED.index);
		
		//2、创建工作表
		HSSFSheet sheet = workbook.createSheet("Hello World");//指定工作表名
		//2.1、加载合并单元格对象
		sheet.addMergedRegion(cellRangeAddress);
		
		//3、创建行；创建第3行
		HSSFRow row = sheet.createRow(3);
		//4、创建单元格；创建第3行第3列
		HSSFCell cell = row.createCell(3);
		//加载样式
		cell.setCellStyle(style);
		cell.setCellValue("Hello World!");
		
		//输出到硬盘
		FileOutputStream outputStream = new FileOutputStream("E:\\aiden\\test.xls");
		//把excel输出到具体的地址
		workbook.write(outputStream);
		workbook.close();
		outputStream.close();
	}
}
