package Excel;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import readers.Builder;

public class ExcelReader {

    private File excelFile;
    private XSSFWorkbook workbook;

    public ExcelReader(String path) {
        setExcelFile(path);
    }

    private void setExcelFile(String path) {
        this.excelFile = new File(path);
    }

    public void loadExcelFile() {
        try {
            workbook = new XSSFWorkbook(excelFile);
        } catch (IOException | InvalidFormatException ex) {
            Logger.getLogger(ExcelReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void processData() {
        loadExcelFile();
        processDataFromSheets();
        closeWorkbook();
    }

    private void processDataFromSheets() {
        processRowsInSheet(0, Builder.f_Names, Builder.m_Names);
        processRowsInSheet(1, Builder.f_Sec_Names, Builder.m_Sec_Names);
        processRowsInSheet(2, Builder.sec_f_Teah_Names, Builder.sec_m_Teah_Names);

        for (int i = 0; i <= workbook.getSheetAt(workbook.getNumberOfSheets() - 1).getLastRowNum(); i++) {
            Builder.patronymic.add(workbook.getSheetAt(workbook.getNumberOfSheets() - 1).getRow(i).getCell(0).getStringCellValue());
        }
    }

    private void processRowsInSheet(int sheetIndex, ArrayList<String> list1, ArrayList<String> list2) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j <= workbook.getSheetAt(sheetIndex).getLastRowNum(); j++) {
                if (workbook.getSheetAt(sheetIndex).getRow(j).getCell(i) == null) {
                    break;
                }
                if (i == 0) {
                    list2.add(workbook.getSheetAt(sheetIndex).getRow(j).getCell(i).getStringCellValue());
//                    System.out.println(list2);
                }
                if (i == 1) {
                    list1.add(workbook.getSheetAt(sheetIndex).getRow(j).getCell(i).getStringCellValue());
//                    System.out.println(list1);
                }
            }
        }
    }

    private void closeWorkbook() {
        try {
            workbook.close();
        } catch (IOException ex) {
            Logger.getLogger(ExcelReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
