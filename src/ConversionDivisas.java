import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversionDivisas {

    public void buscarDivisa(Divisas codigoBase, Divisas codigoFinal , double conversionDeValor) {
        //CREACION DEL CODIGO DE MI API EN EXCHANGERATEAPI
        String key = "1b1938feb89fa52df6f680dd";
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/" + key + "/latest/" + codigoBase);
        //Contruyendo el cliente para las solicitudes
        HttpClient client = HttpClient.newHttpClient();
        //Contruyendo la solicitud de la API
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            //Construyendo las respuestas de la API
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            //Accediendo a las respuestas JSON
            JsonObject jsonObject = new Gson().fromJson(response.body(), JsonObject.class);

            JsonObject tasasConversion = jsonObject.getAsJsonObject("conversion_rates");

            var valorMoneda = tasasConversion.get(String.valueOf(codigoFinal)).getAsDouble();
            var conversion = conversionMoneda(valorMoneda, conversionDeValor);

            System.out.println("El valor " + conversionDeValor +" "+ codigoBase + " corresponde al valor final de: " +
                    conversion+ " "+codigoFinal);

        } catch (Exception e) {
            throw new RuntimeException("No se pudo realizar la conversion");
        }

    }
    public double conversionMoneda(double moneda, double valor){

        return moneda * valor;
    }
}
