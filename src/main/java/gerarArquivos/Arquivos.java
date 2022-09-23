package gerarArquivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Arquivos {

    public static void main(String[] args) throws IOException {

        Pessoa pessoa1 = new Pessoa();
        pessoa1.setNome("Marcello");
        pessoa1.setEmail("pessoa1@gmail.com");
        pessoa1.setIdade(50);

        Pessoa pessoa2 = new Pessoa();
        pessoa2.setEmail("pessoa2@gmail.com");
        pessoa2.setIdade(30);
        pessoa2.setNome("José");

        Pessoa pessoa3 = new Pessoa();
        pessoa3.setEmail("pessoa3@gmail.com");
        pessoa3.setIdade(20);
        pessoa3.setNome("Marta");

        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(pessoa1);
        pessoas.add(pessoa2);
        pessoas.add(pessoa3);

        File arquivos = new File("C:\\Leitura txt excel com apache\\src\\main\\arquivos.csv");

        if (!arquivos.exists()) {
            arquivos.createNewFile();
        }

        FileWriter escrever_no_arquivo = new FileWriter(arquivos);

       for (Pessoa pessoa : pessoas) {
           escrever_no_arquivo.write(pessoa.getNome() +
                   ";" + pessoa.getEmail() + ";" + pessoa.getIdade() + "\n");
       }
        escrever_no_arquivo.flush();
        escrever_no_arquivo.close();
    }
}
