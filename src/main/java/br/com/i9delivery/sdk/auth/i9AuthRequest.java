/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package br.com.i9delivery.sdk.auth;

import com.google.gson.Gson;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * 2023-04-08 21:52:53
 * @author murilotuvani
 */
public class i9AuthRequest {
    
    private static final Gson GSON = new Gson();
    
    public i9Auth authencicate() throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody requestBody = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("clientId", "22")
                .addFormDataPart("clientSecret", "P1CHqVq2TgWLfS5J8IO7h7brIsnxwUqiNGALifYGcEjbqlS4KK4ZPzqEL85UU1e5")
                .build();
        Request request = new Request.Builder()
                .url("https://teste.i9delivery.com.br/painel/fast/v1/oauth/token")
                .method("POST", requestBody)
                .build();
        Response response = client.newCall(request).execute();
        int responseCode = response.code();
        i9Auth resultado = null;
        try (ResponseBody responseBody = response.body()) {
            String str = null;
            if (responseBody != null) {
                str = new String(responseBody.bytes());
            }
            System.out.println("Response code : "+responseCode);
            System.out.println("Response code : "+str);
            
            if (responseCode == 200) {
                resultado = GSON.fromJson(str, i9Auth.class);
            } else {
                resultado = null;
            }
        }
        return resultado;
    }

}
