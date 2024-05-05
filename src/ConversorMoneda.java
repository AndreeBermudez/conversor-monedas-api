import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversorMoneda {

    public Moneda monedaConversor(String tipoCambio, double cantidad){

        HttpClient client = HttpClient.newHttpClient();
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/b41d9e57aa86cb3ec53f6506/pair/PEN/"+tipoCambio+"/"+cantidad);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(),Moneda.class);
        } catch (IOException | InterruptedException  e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
