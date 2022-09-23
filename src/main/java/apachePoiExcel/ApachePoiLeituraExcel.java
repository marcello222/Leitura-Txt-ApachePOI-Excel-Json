package apachePoiExcel;

import gerarArquivos.Pessoa;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ApachePoiLeituraExcel {

    public static void main(String[] args) throws IOException {

        FileInputStream entrada = new FileInputStream(
                "C:\\Leitura txt excel com apache\\src\\main\\arquivos_excel.xls");


        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(entrada);//prepara a entrada do arquivo excel para leitura
        HSSFSheet planilha = hssfWorkbook.getSheetAt(0);// Pega a primeira planilha do arquivo excel

        Iterator<Row> linhaIterator = planilha.iterator();

        List<Pessoa> pessoas = new ArrayList<>();

        while(linhaIterator.hasNext()) {//enquanto tiver linha no arquivo do excel

            Row linha = linhaIterator.next();//dados da pessoa na linha

            Iterator<Cell> celulas = linha.iterator();

            Pessoa pessoa = new Pessoa();

            while (celulas.hasNext()) { //enquanto tiver celulas
                Cell cell = celulas.next();

                switch (cell.getColumnIndex()) {
                    case 0:
                        pessoa.setNome(cell.getStringCellValue());
                        break;
                    case 1:
                        pessoa.setEmail(cell.getStringCellValue());
                        break;
                    case 2:
                        pessoa.setIdade((int) cell.getNumericCellValue());
                        break;
                }
            }
            pessoas.add(pessoa);
        }
        entrada.close();//terminou de ler o arquivo excel

        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa);
        }
    }
}
