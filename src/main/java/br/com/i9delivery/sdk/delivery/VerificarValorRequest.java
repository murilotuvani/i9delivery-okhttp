package br.com.i9delivery.sdk.delivery;

import br.com.i9delivery.sdk.auth.i9Auth;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * 2023-04-08 22:04:02
 *
 * @author murilotuvani
 */
public class VerificarValorRequest {

    public String execute() throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\r\n    \"vehicleType\": 1,\r\n    \"addresses\": [\r\n        {\r\n            \"city\": \"Itu\",\r\n            \"complement\": \"Sala 8\",\r\n            \"goal\": \"Ação\",\r\n            \"lat\": -23.2685324,\r\n            \"lng\": -47.2936349,\r\n            \"neighborhood\": \"Vila Nova\",\r\n            \"number\": \"35\",\r\n            \"position\": 1,\r\n            \"responsible\": \"Autor\",\r\n            \"retDescription\": \"TESTE\",\r\n            \"retType\": 3,\r\n            \"state\": \"SP\",\r\n            \"street\": \"Rua Capitão Sílvio Fleming\"\r\n        }\r\n    ]\r\n}");
        Request request = new Request.Builder()
                .url("https://teste.i9delivery.com.br/painel/fast/v1/delivery/checkValue")
                .method("POST", body)
                .addHeader("Authorization", "Bearer {{token}}")
                .addHeader("Content-Type", "application/json")
                .build();
        Response response = client.newCall(request).execute();

        String resultado = null;
        int responseCode = response.code();
        try (ResponseBody responseBody = response.body()) {
            String str = null;
            if (responseBody != null) {
                str = new String(responseBody.bytes());
            }
            System.out.println("Response code : " + responseCode);
            System.out.println("Response code : " + str);

            if (responseCode == 200) {
//                resultado = GSON.fromJson(str, i9Auth.class);
                resultado = str;
            } else {
                resultado = null;
            }
        }
        return resultado;
    }

}
