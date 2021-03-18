package com.avianca.certificacion.aviancaTestProject.util.excel;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.NumberToTextConverter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


/**
 * The type Lector excel.
 */
public class LectorExcel {

    /**
     * Obtiene los datos de un archivo de excel, teniendo en cuenta el nombre de la
     * hoja
     *
     * @param excelFilePath Ruta del libro de excel
     * @param sheetName     Nombre de la hoja que contiene los datos
     * @return data
     * @throws InvalidFormatException Manejo de error por formato inv�lido
     * @throws IOException            Manejo de error para el proceso de entrada y salida de datos
     */
    public List<Map<String, String>> getData(String excelFilePath, String sheetName)
            throws InvalidFormatException, IOException {
        Sheet sheet = getSheetByName(excelFilePath, sheetName);
        return readSheet(sheet);
    }

    /**
     * Obtiene los datos de un archivo de excel, teniendo en cuenta el numero de la
     * hoja
     *
     * @param excelFilePath Ruta del libro de excel
     * @param sheetNumber   Nombre de la hoja que contiene los datos
     * @return data
     * @throws InvalidFormatException Manejo de error por formato inv�lido
     * @throws IOException            Manejo de error para el proceso de entrada y salida de datos
     */
    public List<Map<String, String>> getData(String excelFilePath, int sheetNumber)
            throws InvalidFormatException, IOException {
        Sheet sheet = getSheetByIndex(excelFilePath, sheetNumber);
        return readSheet(sheet);
    }

    /**
     * Obtiene la hoja de trabajo donde se encuentran los datos de acuerdo a la
     * ruta del archivo
     *
     * @param excelFilePath Ruta del libro de excel
     * @param sheetName     Nombre de la hoja que contiene los datos
     * @return
     * @throws IOException
     * @throws InvalidFormatException
     */
    private Sheet getSheetByName(String excelFilePath, String sheetName) throws IOException, InvalidFormatException {
        Sheet sheet = getWorkBook(excelFilePath).getSheet(sheetName);
        return sheet;
    }

    /**
     * Obtiene los hoja de trabajo donde se encuentran los datos de acuerdo al index
     * de la hoja
     *
     * @param excelFilePath Ruta del libro de excel
     * @param sheetNumber   Indice de tipo entero de la hoja en el libro de excel
     * @return
     * @throws IOException
     * @throws InvalidFormatException
     * @author bgaona
     * @since 27/11/2017
     */
    private Sheet getSheetByIndex(String excelFilePath, int sheetNumber) throws IOException, InvalidFormatException {
        Sheet sheet = getWorkBook(excelFilePath).getSheetAt(sheetNumber);
        return sheet;
    }

    /**
     * Devuelve el libro correspondiente a la hoja determinada con antelaci�n
     *
     * @param excelFilePath Ruta del archivo de excel
     * @return
     * @throws IOException
     * @throws InvalidFormatException
     * @author bgaona
     * @since 27/11/2017
     */
    private Workbook getWorkBook(String excelFilePath) throws IOException, InvalidFormatException {
        return WorkbookFactory.create(new File(excelFilePath));
    }

    /**
     * Retorna la lista en forma de Map de todas las filas que contiene la hoja de
     * excel, teniendo en cuenta la primera fila como los nombres de la columna
     *
     * @param sheet Hoja de excel
     * @return
     * @author bgaona
     * @since 27/11/2017
     */
    private List<Map<String, String>> readSheet(Sheet sheet) {
        Row row;
        int totalRow = sheet.getPhysicalNumberOfRows(); //-------------> se deja la �ltima fila Se quita una de las filas que la librer�a considera que tiene datos debido a que deja una en blanco
        List<Map<String, String>> excelRows = new ArrayList<Map<String, String>>();
        int headerRowNumber = getHeaderRowNumber(sheet);
        if (headerRowNumber != -1) {
            int totalColumn = sheet.getRow(headerRowNumber).getLastCellNum();
            int setCurrentRow = 1;
            for (int currentRow = setCurrentRow; currentRow <= totalRow; currentRow++) {
                row = getRow(sheet, sheet.getFirstRowNum() + currentRow);
                LinkedHashMap<String, String> columnMapdata = new LinkedHashMap<String, String>();
                for (int currentColumn = 0; currentColumn < totalColumn; currentColumn++) {
                    columnMapdata.putAll(getCellValue(sheet, row, currentColumn));
                }
                excelRows.add(columnMapdata);
            }
        }
        return excelRows;
    }

    /**
     * Obtiene el n�mero de filas conceniernte a encabezado de la hoja
     *
     * @param sheet
     * @return
     * @author bgaona
     * @since 27/11/2017
     */
    private int getHeaderRowNumber(Sheet sheet) {
        Row row;
        int totalRow = sheet.getLastRowNum();
        for (int currentRow = 0; currentRow <= totalRow + 1; currentRow++) {
            row = getRow(sheet, currentRow);
            if (row != null) {
                int totalColumn = row.getLastCellNum();
                for (int currentColumn = 0; currentColumn < totalColumn; currentColumn++) {
                    Cell cell;
                    cell = row.getCell(currentColumn, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    if (cell.getCellTypeEnum() == CellType.STRING) {
                        return row.getRowNum();
                    } else if (cell.getCellTypeEnum() == CellType.NUMERIC) {
                        return row.getRowNum();

                    } else if (cell.getCellTypeEnum() == CellType.BOOLEAN) {
                        return row.getRowNum();
                    } else if (cell.getCellTypeEnum() == CellType.ERROR) {
                        return row.getRowNum();
                    }
                }
            }
        }
        return (-1);
    }

    /**
     * Obtiene la fila de acuerdo a la hoja y el n�mero de �sta
     *
     * @param sheet
     * @param rowNumber
     * @return
     * @author bgaona
     * @since 27/11/2017
     */
    private Row getRow(Sheet sheet, int rowNumber) {
        return sheet.getRow(rowNumber);
    }

    /**
     * Obtiene el valor de cada una de las celdas -------> reevaluar y dejar como texto todos los valores
     *
     * @param sheet
     * @param row
     * @param currentColumn
     * @return
     * @author bgaona
     * @since 27/11/2017
     */
    private LinkedHashMap<String, String> getCellValue(Sheet sheet, Row row, int currentColumn) {
        LinkedHashMap<String, String> columnMapdata = new LinkedHashMap<String, String>();
        Cell cell;
        if (row == null) {
            if (sheet.getRow(sheet.getFirstRowNum()).getCell(currentColumn, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
                    .getCellTypeEnum() != CellType.BLANK) {
                String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(currentColumn)
                        .getStringCellValue();
                columnMapdata.put(columnHeaderName, "");
            }
        } else {
            cell = row.getCell(currentColumn, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
            if (cell.getCellTypeEnum() == CellType.STRING) {
                if (sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex(), Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
                        .getCellTypeEnum() != CellType.BLANK) {
                    String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex())
                            .getStringCellValue();
                    columnMapdata.put(columnHeaderName, cell.getStringCellValue());
                }
            } else if (cell.getCellTypeEnum() == CellType.NUMERIC) {
                if (sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex(), Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
                        .getCellTypeEnum() != CellType.BLANK) {
                    String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex())
                            .getStringCellValue();
                    columnMapdata.put(columnHeaderName, NumberToTextConverter.toText(cell.getNumericCellValue()));
                }
            } else if (cell.getCellTypeEnum() == CellType.BLANK) {
                if (sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex(), Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
                        .getCellTypeEnum() != CellType.BLANK) {
                    String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex())
                            .getStringCellValue();
                    columnMapdata.put(columnHeaderName, "");
                }
            } else if (cell.getCellTypeEnum() == CellType.BOOLEAN) {
                if (sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex(), Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
                        .getCellTypeEnum() != CellType.BLANK) {
                    String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex())
                            .getStringCellValue();
                    columnMapdata.put(columnHeaderName, Boolean.toString(cell.getBooleanCellValue()));
                }
            } else if (cell.getCellTypeEnum() == CellType.ERROR) {
                if (sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex(), Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
                        .getCellTypeEnum() != CellType.BLANK) {
                    String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex())
                            .getStringCellValue();
                    columnMapdata.put(columnHeaderName, Byte.toString(cell.getErrorCellValue()));
                }
            }
        }
        return columnMapdata;
    }
}

