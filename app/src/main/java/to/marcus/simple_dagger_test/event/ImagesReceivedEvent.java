package to.marcus.simple_dagger_test.event;

import android.util.Log;
import java.util.ArrayList;
import to.marcus.simple_dagger_test.model.Photos.Photo;

/**
 * Created by marcus on 22/04/15.
 */
public class ImagesReceivedEvent {

    private static final String TAG = "ImagesReceivedEvent";
    private ArrayList<Photo> result;

    public ImagesReceivedEvent(ArrayList<Photo> result){
        Log.i(TAG, "arraylist for presenter");
        this.result = result;
    }

    public ArrayList<Photo> getResult(){return result;}
}
