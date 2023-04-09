package br.com.i9delivery.sdk.delivery;

import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * 2023-04-08 22:08:43
 *
 * @author murilotuvani
 */
public class DeliveryHistoricoRequest {

    public void execute() throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = RequestBody.create(mediaType, "");
        Request request = new Request.Builder()
                .url("https://teste.i9delivery.com.br/painel/fast/v1/delivery/historic/{{dateStart}}/{{dateEnd}}")
                .method("GET", body)
                .addHeader("Authorization", "Bearer {{token}}")
                .build();
        Response response = client.newCall(request).execute();
    }

}
