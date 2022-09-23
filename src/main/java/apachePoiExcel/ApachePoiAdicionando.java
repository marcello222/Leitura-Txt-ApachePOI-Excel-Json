package apachePoiExcel;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

public class ApachePoiAdicionando {

    public static void main(String[] args) throws IOException {

        File file = new File("C:\\Leitura txt excel com apache\\src\\main\\arquivos_excel.xls");

        FileInputStream entrada = new FileInputStream(file);

        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(entrada);
        HSSFSheet planilha = hssfWorkbook.getSheetAt(0);//pegando a planilha

        Iterator<Row> linhaIterator = planilha.iterator();


        while(linhaIterator.hasNext()) {//enquanto tiver linha
            Row linha = linhaIterator.next();//dados da pessoa na linha

            int numeroCelulas = linha.getPhysicalNumberOfCells();//quantidade de celulas

            Cell cell = linha.createCell(numeroCelulas);//cria nova celula na linha
            cell.setCellValue("5.400,20");
        }
        entrada.close();

        FileOutputStream saida = new FileOutputStream(file);
        hssfWorkbook.write(saida);
        saida.flush();
        saida.close();

        System.out.println("planilha atualizada");
     }
}
