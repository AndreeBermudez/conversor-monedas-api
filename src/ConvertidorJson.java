import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class ConvertidorJson {
    public void archivoJson(Moneda moneda) throws IOException {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        FileWriter archivo = new FileWriter(moneda.target_code() + ".json");
        archivo.write(gson.toJson(moneda));
        archivo.close();
    }
}
