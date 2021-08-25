package com.jk.integral.utils;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class PoiUtil {

	
	
	public static XSSFSheet exportData(XSSFWorkbook workbook,String sheetName,String[] titles) {
		//得到sheet页
		XSSFSheet sheet = workbook.createSheet(sheetName);
		//获取第一行
		XSSFRow row = sheet.createRow(0);
		
//		for循环，将标题写入第一行
		for (int i = 0; i < titles.length; i++) {
			//cell代表单元格
			row.createCell(i).setCellValue(titles[i]);
		}
		
		return sheet;
	}
	
	/**
	 * 下载
	 * @param response
	 * @param workbook
	 * @param fileName
	 */
	public static void down(HttpServletResponse response,XSSFWorkbook workbook,String fileName) {
		ServletOutputStream outputStream = null ;
		try {
			if(fileName.toLowerCase().lastIndexOf(".xlsx")== -1){
			fileName = fileName+".xlsx";
		}
//		 下载
//		 设置Content-Disposition :attchment
			response.setHeader("Content-Disposition", "attchment;filename="+URLEncoder.encode(fileName, "utf-8"));
			outputStream = response.getOutputStream();//获取输出流
//		这样的下载直接将文件下载到指定的地方
//		FileOutputStream outputStream = new FileOutputStream("D://123.xlsx");
			workbook.write(outputStream);
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				outputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}// 关闭资源
		}
	}
}
