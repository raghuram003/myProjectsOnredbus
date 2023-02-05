package neon.task.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class ExcelReader {
    private static final Logger logger = LoggerFactory.getLogger(ExcelReader.class);

    private static final String EMPTY_SPACE_REG_EXP = "\\s";

    public List<Map<String, Object>> read(byte[] bytes, boolean headerColumnRemoveSpace){
        List<Map<String, Object>> data = new LinkedList<>();

        try(InputStream inputStream = new ByteArrayInputStream(bytes)) {
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);

            XSSFSheet sheet = workbook.getSheetAt(0);

            List<String> headers = new ArrayList<>();
            Iterator<Row> iterator = sheet.iterator();
            int i = 0;
            while (iterator.hasNext()){
                Map<String, Object> rowData = new LinkedHashMap<>();
                Row row = iterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()){
                    Cell cell = cellIterator.next();
                    Object cellValue = getCellValue(cell);
                    if(i == 0){
                        String headerColumnVal = String.valueOf(cellValue);
                        if(headerColumnRemoveSpace){
                            headerColumnVal = headerColumnVal.replaceAll(EMPTY_SPACE_REG_EXP, StringUtils.EMPTY);
                        }
                        headers.add(headerColumnVal);
                    }else {
                        rowData.put(headers.get(cell.getColumnIndex()), cellValue);
                    }
                }
                if(i == 0) {
                    i++;
                }else{
                    data.add(rowData);
                }
            }
        } catch (IOException e) {
            logger.error("Unable to read from excel", e);
        }

        return data;
    }

    private Object getCellValue(Cell cell) {
        switch (cell.getCellType()){
            case Cell.CELL_TYPE_NUMERIC:
                if(HSSFDateUtil.isCellDateFormatted(cell)){
                    return cell.getDateCellValue();
                }else{
                    return NumberToTextConverter.toText(cell.getNumericCellValue());
                }

            case Cell.CELL_TYPE_STRING:
                    return cell.getStringCellValue();

            case Cell.CELL_TYPE_BLANK:
                return null;

            case Cell.CELL_TYPE_BOOLEAN:
                return cell.getBooleanCellValue();

            default:
                logger.error("cellType="+cell.getCellType()+" found, it is not handled");
                return null;
        }
    }


}}
