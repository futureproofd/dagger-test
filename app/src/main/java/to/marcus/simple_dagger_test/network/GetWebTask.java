package to.marcus.simple_dagger_test.network;

import android.os.AsyncTask;
import android.util.Log;
import java.io.IOException;
import java.util.ArrayList;
import to.marcus.simple_dagger_test.event.MainBus;
import to.marcus.simple_dagger_test.event.httpTaskEvent;
import to.marcus.simple_dagger_test.model.Image;

/**
 * Created by marcus on 4/1/2015.
 * AsyncTask to retrieve XML data from Flickr API
 */

public class GetWebTask extends AsyncTask<Void, Void, ArrayList<Image>> {

    private static final String TAG = "GetWebTask";
    private WebConnection httpConnection;
    private EndPoint endPoint;
    private MainBus mBus;

    public GetWebTask(WebConnection httpConnection, EndPoint endPoint, MainBus bus){
        this.httpConnection = httpConnection;
        this.endPoint = endPoint;
        this.mBus = bus;
    }

    @Override
    protected ArrayList<Image> doInBackground(Void... params){
        try{
            return endPoint.getXMLContent(httpConnection);
        }catch (IOException ioe){
            Log.e(TAG, "Failed to fetch URL Data: ", ioe);
            return null;
        }
    }

    @Override
    protected void onPostExecute(ArrayList<Image> images){
        Log.d(TAG, "The returned list contains " + images.size());
        mBus.getInstance().post(new httpTaskEvent(images));
    }

}
