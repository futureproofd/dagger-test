package to.marcus.simple_dagger_test.ui.presenter;

import android.util.Log;

import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;
import java.util.ArrayList;
import to.marcus.simple_dagger_test.event.ImagesReceivedEvent;
import to.marcus.simple_dagger_test.event.ImagesRequestedEvent;
import to.marcus.simple_dagger_test.model.Photos.Photo;

/**
 * Created by marcus on 15/04/15
 */

public class ImagePresenter{

    //define a View interface
    public interface ImageView{
        void displayImages(ArrayList<Photo> images);
    }

    private final String TAG = "ImagePresenter";
    private final Bus bus;
    private final ImageView view;

    public ImagePresenter(Bus bus, ImageView view){
        this.bus = bus;
        this.view = view;
    }

    public void onImagesRequested(String request){
        //view.showloadingIndicator  -- HomeFragment will implement our view interface and override this method
        Log.i(TAG, "Images Requested Event!");
        bus.post(new ImagesRequestedEvent(request));  //this will notify our ApiRequestHandler
    }

    @Subscribe
    public void onImagesArrayReceived(final ImagesReceivedEvent event){
        Log.i(TAG, "array ready for presenter");
        ArrayList<Photo> images = event.getResult();
    }

}
