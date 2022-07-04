package service;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import static com.google.gson.JsonParser.parseReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.Modelo;

public class Servicio {

    private static String api_key = "h1FmyvduCMVJeKuV8OqvzBGkACNZVLRu0meKkBAkmtI";
    private static String host = "https://apis.paralleldots.com/v4/";

    public static String abuse(String text) throws Exception {
        if (api_key != null) {
            String url = host + "abuse";
            OkHttpClient client = new OkHttpClient();
            RequestBody requestBody = new MultipartBody.Builder()
                    .setType(MultipartBody.FORM)
                    .addFormDataPart("api_key", api_key)
                    .addFormDataPart("text", text)
                    .build();
            Request request = new Request.Builder()
                    .url(url)
                    .post(requestBody)
                    .addHeader("cache-control", "no-cache")
                    .build();
            Response response = client.newCall(request).execute();
            return response.body().string();
        } else {
            return "{ \"Error\": \"API key does not exist\" }";
        }
    }

    public static void abuso(Modelo modelo) throws Exception {
        String texto = modelo.getText();
        if (api_key != null) {
            String url = host + "abuse";
            OkHttpClient client = new OkHttpClient();
            RequestBody requestBody = new MultipartBody.Builder()
                    .setType(MultipartBody.FORM)
                    .addFormDataPart("api_key", api_key)
                    .addFormDataPart("text", texto)
                    .build();
            Request request = new Request.Builder()
                    .url(url)
                    .post(requestBody)
                    .addHeader("cache-control", "no-cache")
                    .build();
            Response response = client.newCall(request).execute();
            JsonObject jsonObject = JsonParser.parseString​(response.body().string()).getAsJsonObject();
            if (jsonObject.isJsonObject()) {
                JsonObject rootobj = jsonObject.getAsJsonObject();
                String Abusivo = rootobj.get("abusive").getAsString();
                String Odio = rootobj.get("hate_speech").getAsString();
                String Ninguno = rootobj.get("neither").getAsString();
                modelo.setAbusivo(Abusivo);
                modelo.setOdio(Odio);
                modelo.setNinguno(Ninguno);
                System.out.println("\n"+Abusivo+"\n"+Ninguno+"\n"+Odio);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        String texto = "soy victor la vida es triste, me quiero morir";
        String resultado = "";
        resultado = abuse(texto);
        System.out.println("resultado" + resultado);
        
        Modelo mol = new Modelo();
        mol.setText(texto);
        abuso(mol);

        
    }
}
