package arquivosJson;

import com.google.gson.*;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EscreveJson {

    public static void main(String[] args) throws IOException {

        Usuario usuario1 = new Usuario();
        usuario1.setCpf("2762276276");
        usuario1.setLogin("Joao");
        usuario1.setSenha("151522");
        usuario1.setNome("Joao");

        Usuario usuario2 = new Usuario();
        usuario2.setCpf("2929922222");
        usuario2.setLogin("marta");
        usuario2.setSenha("37373");
        usuario2.setNome("Marta");

        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(usuario1);
        usuarios.add(usuario2);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String jsonUser = gson.toJson(usuarios);
        System.out.println(jsonUser);

        FileWriter fileWriter = new FileWriter
                ("C:\\Leitura txt excel com apache\\src\\main\\arquivos.json");
        fileWriter.write(jsonUser);
        fileWriter.flush();
        fileWriter.close();


        //==================LENDO ARQUIVO JSON ========================

        FileReader fileReader = new FileReader("C:\\Leitura txt excel com apache\\src\\main\\arquivos.json");

        JsonArray jsonArray = (JsonArray) JsonParser.parseReader(fileReader);

        List<Usuario> listaUsuarios = new ArrayList<>();

        for (JsonElement jsonELement : jsonArray) {

            Usuario usuario = new Gson().fromJson(jsonELement, Usuario.class);
            listaUsuarios.add(usuario);
        }
        System.out.println("Leitura do aquivo Json " + listaUsuarios);


    }
}
