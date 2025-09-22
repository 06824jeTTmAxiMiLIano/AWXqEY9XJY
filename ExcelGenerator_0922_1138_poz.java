// 代码生成时间: 2025-09-22 11:38:00
package com.example;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Excel表格自动生成器
 */
public class ExcelGenerator {

    private static final String EXCEL_2003_FORMAT = ".xls";
    private static final String EXCEL_2007_FORMAT = ".xlsx";

    /**
     * 创建一个新的Excel工作簿
     *
     * @return 返回一个Workbook对象
     */
    public Workbook createWorkbook() {
        return new XSSFWorkbook(); // 创建一个Excel 2007格式的工作簿
    }

    /**
     * 创建一个新的Excel工作表
     *
     * @param workbook Workbook对象
     * @param sheetName 工作表名称
     * @return 返回一个Sheet对象
     */
    public Sheet createSheet(Workbook workbook, String sheetName) {
        return workbook.createSheet(sheetName);
    }

    /**
     * 创建一个新的行
     *
     * @param sheet Sheet对象
     * @param rowNum 行号
     * @return 返回一个Row对象
     */
    public Row createRow(Sheet sheet, int rowNum) {
        return sheet.createRow(rowNum);
    }

    /**
     * 创建一个新的单元格
     *
     * @param row Row对象
     * @param cellNum 单元格号
     * @return 返回一个Cell对象
     */
    public Cell createCell(Row row, int cellNum) {
        return row.createCell(cellNum);
    }

    /**
     * 设置单元格的值
     *
     * @param cell Cell对象
     * @param value 要设置的值
     */
    public void setCellValue(Cell cell, String value) {
        cell.setCellValue(value);
    }

    /**
     * 将数据写入Excel文件
     *
     * @param workbook Workbook对象
     * @param fileName 文件名称
     * @throws IOException 如果写入失败
     */
    public void writeExcel(Workbook workbook, String fileName) throws IOException {
        try (FileOutputStream outputStream = new FileOutputStream(fileName)) {
            workbook.write(outputStream);
        }
    }

    /**
     * 读取Excel文件
     *
     * @param inputStream 输入流
     * @return 返回一个Workbook对象
     * @throws IOException 如果读取失败
     */
    public Workbook readExcel(InputStream inputStream) throws IOException {
        Workbook workbook;
        if (inputStream.available() > 0) {
            workbook = new XSSFWorkbook(inputStream); // 读取Excel 2007格式的文件
        } else {
            throw new IOException("Empty input stream");
        }
        return workbook;
    }

    /**
     * 主方法，用于演示Excel生成器的使用
     *
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        ExcelGenerator excelGenerator = new ExcelGenerator();

        try {
            // 创建Excel工作簿
            Workbook workbook = excelGenerator.createWorkbook();

            // 创建工作表
            Sheet sheet = excelGenerator.createSheet(workbook, "Sample Sheet");

            // 创建数据
            List<List<String>> data = new ArrayList<>();
            data.add(List.of("Header1", "Header2", "Header3"));
            data.add(List.of("Data1", "Data2", "Data3"));
            data.add(List.of("Data4", "Data5", "Data6"));

            // 写入数据到Excel
            for (int i = 0; i < data.size(); i++) {
                Row row = excelGenerator.createRow(sheet, i);
                for (int j = 0; j < data.get(i).size(); j++) {
                    Cell cell = excelGenerator.createCell(row, j);
                    excelGenerator.setCellValue(cell, data.get(i).get(j));
                }
            }

            // 写入Excel文件
            excelGenerator.writeExcel(workbook, "GeneratedExcel.xlsx");

            System.out.println("Excel file generated successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}