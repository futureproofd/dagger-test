package to.marcus.simple_dagger_test.network;

import android.os.AsyncTask;
import android.util.Log;
import java.io.IOException;

/**
 * Created by mplienegger on 4/1/2015.
 */

public class GetWebTask extends AsyncTask<Void, Void, Void> {
    private static final String TAG = "GetWebTask";
    private WebConnection httpConnection;

    public GetWebTask(WebConnection httpConnection){
        this.httpConnection = httpConnection;
    }

    @Override
    protected Void doInBackground(Void... params){
        try{
            String result = httpConnection.getUrl("http://www.google.com");
            Log.i(TAG, "URL Data: " + result);
        }catch (IOException ioe){
            Log.e(TAG, "Failed to fetch URL Data: ", ioe);
        }
        return null;
    }
}
