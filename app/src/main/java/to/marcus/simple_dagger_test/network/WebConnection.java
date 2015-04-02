package to.marcus.simple_dagger_test.network;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by marcus on 31/03/15.
 * To open an HTTP Connection for working with request methods
 */
public class WebConnection {

    private byte[] getUrlBytes(String urlStr) throws IOException{
        URL url = new URL(urlStr);
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();

        try{
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            InputStream in = connection.getInputStream();

            if(connection.getResponseCode() != HttpURLConnection.HTTP_OK){
                return null;
            }
            int bytesRead = 0;
            byte[] buffer = new byte[1024];
            //fill up the bytes read
            while((bytesRead = in.read(buffer)) > 0){
                out.write(buffer, 0, bytesRead);
            }
            out.close();
            return out.toByteArray();
        }finally{
            connection.disconnect();
        }
    }

    public String getUrl(String urlStr) throws IOException{
        return new String(getUrlBytes(urlStr));
    }
}
