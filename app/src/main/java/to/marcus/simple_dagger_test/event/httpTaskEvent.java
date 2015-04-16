package to.marcus.simple_dagger_test.event;

import android.util.Log;
import java.util.ArrayList;
import to.marcus.simple_dagger_test.model.Image;

/**
 * Created by marcus on 13/04/15.
 */
public class HttpTaskEvent {
    private static final String TAG = "httpTaskEvent";
    private ArrayList<Image> result;

    public HttpTaskEvent(ArrayList<Image> result){
        Log.i(TAG, "Here's the result");
        this.result = result;
    }

    public ArrayList<Image> getResult(){
        Log.i(TAG, "get result called");
        return result;
    }
}
