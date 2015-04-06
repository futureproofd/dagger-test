package to.marcus.simple_dagger_test.network;

import android.os.AsyncTask;
import android.util.Log;
import java.io.IOException;

/**
 * Created by marcus on 4/1/2015.
 * AsyncTask to retrieve XML data from Flickr API
 */

public class GetWebTask extends AsyncTask<Void, Void, Void> {

    private static final String TAG = "GetWebTask";
    private WebConnection httpConnection;
    private EndPoint endPoint;


    public GetWebTask(WebConnection httpConnection, EndPoint endPoint){
        this.httpConnection = httpConnection;
        this.endPoint = endPoint;
    }

    @Override
    protected Void doInBackground(Void... params){
        try{
            endPoint.getXMLContent(httpConnection);
        }catch (IOException ioe){
            Log.e(TAG, "Failed to fetch URL Data: ", ioe);
        }
        return null;
    }
}
