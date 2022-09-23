package lerAqruivos;

import gerarArquivos.Pessoa;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LerAqruivosTxt {

    public static void main(String[] args) throws FileNotFoundException {

        // arquivo de entrada de dados
        FileInputStream entradaArquivo = new FileInputStream(new File(
                "C:\\Leitura txt excel com apache\\src\\main\\arquivos.csv"));

        Scanner lerArquivo = new Scanner(entradaArquivo, StandardCharsets.UTF_8);

        List<Pessoa> pessoas = new ArrayList<>();

        while (lerArquivo.hasNext()) {
            String linha = lerArquivo.nextLine();

            if (linha != null && !linha.isEmpty()) {
                String[] dados = linha.split("\\;");

                Pessoa pessoa = new Pessoa();
                pessoa.setNome(dados[0]);
                pessoa.setEmail(dados[1]);
                pessoa.setIdade(Integer.parseInt(dados[2]));
                pessoas.add(pessoa);
            }
        }

        for (Pessoa pessoa: pessoas) { //poderia gerar boletom enviar email etc...
            System.out.println(pessoa);
        }
    }
}
