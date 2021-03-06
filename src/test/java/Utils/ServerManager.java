package Utils;


import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by borisgurtovyy on 10/30/17.
 */
public class ServerManager extends BaseTest {

    private String base_url = "https://moviemates-prod.herokuapp.com/api/v1/";

    public String getMovies() throws IOException {
        String url = base_url + "movies?days=1";
        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet(url);
        System.out.println(prop.getProperty("TOKEN"));
        request.addHeader("Authorization", "Token " + prop.getProperty("TOKEN"));
        HttpResponse response = client.execute(request);
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        StringBuffer result = new StringBuffer();
        String line = "";
        while((line = rd.readLine()) != null) {
            result.append(line);
        }
        return result.toString();
    }
}
