package apachePoiExcel;

import gerarArquivos.Pessoa;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ApachePoiEscrevendo {

    public static void main(String[] args) throws IOException {

        File file = new File("C:\\Leitura txt excel com apache\\src\\main\\arquivos_excel.xls");

        if (!file.exists()) {
            file.createNewFile();
        }

        Pessoa pessoa1 = new Pessoa();
        pessoa1.setNome("Marcello");
        pessoa1.setEmail("pessoa1@gmail.com");
        pessoa1.setIdade(50);

        Pessoa pessoa2 = new Pessoa();
        pessoa2.setEmail("pessoa2@gmail.com");
        pessoa2.setIdade(30);
        pessoa2.setNome("Jose");

        Pessoa pessoa3 = new Pessoa();
        pessoa3.setEmail("pessoa3@gmail.com");
        pessoa3.setIdade(20);
        pessoa3.setNome("Marta");

        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(pessoa1);
        pessoas.add(pessoa2);
        pessoas.add(pessoa3);

        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();// usado para escrever a planilha
        HSSFSheet linhasPessoa = hssfWorkbook.createSheet("planilha de pessoas treinamento");

        int numeroLinha = 0;

        for (Pessoa pessoa : pessoas) {
            Row linha = linhasPessoa.createRow(numeroLinha ++);//criando a linha na planilha

            int celula = 0;
            Cell cellNome = linha.createCell(celula ++);
            cellNome.setCellValue(pessoa.getNome());

            Cell cellEmail = linha.createCell(celula ++);
            cellEmail.setCellValue(pessoa.getEmail());

            Cell cellIdade = linha.createCell(celula ++);
            cellIdade.setCellValue(pessoa.getIdade());
        }

        FileOutputStream saida = new FileOutputStream(file);
        hssfWorkbook.write(saida);//escreve a planilha em arquivo
        saida.flush();
        saida.close();

        System.out.println("Planilha criada");
    }
}
