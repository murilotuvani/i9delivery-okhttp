package br.com.i9delivery.sdk.auth;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 2023-04-08 21:43:47
 *
 * @author murilotuvani
 */
public class i9Auth implements Serializable {

    private final LocalDateTime birthtime;
    @SerializedName("access_token")
    private String accessToken;
    @SerializedName("token_type")
    private String tokenType;
    @SerializedName("expires_in")
    private int expiresIn;
    
        /*
    
    {
    "access_token": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VySWQiOiIyMiIsImVtYWlsIjoiZGV2QGF1dG9nZXJhbC5jb20uYnIiLCJ0eXBlIjoiMiIsImV4cGlyZXNJbiI6MTY4MTAyMjg3M30.RrLWBwMbKQUvj-hmKfXSuPTZetOsHfaYmrV8LvbVXfs",
    "token_type": "bearer",
    "expires_in": 21599
}
     */
    public i9Auth() {
        this.birthtime = LocalDateTime.now();
    }


    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }

}
