package to.marcus.simple_dagger_test.event;

import android.util.Log;

/**
 * Created by marcus on 22/04/15.
 */
public class HttpFailedEvent {

    private static final String TAG = "httpFailedEvent";
    private String result;

    public HttpFailedEvent(String result){
        Log.i(TAG, "Here's the result");
        this.result = result;
    }

    public String getResult(){
        Log.i(TAG, "get result called");
        return result;
    }
}
