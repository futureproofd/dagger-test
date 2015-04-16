package to.marcus.simple_dagger_test.event;

import android.util.Log;
import com.squareup.otto.Subscribe;
import java.util.ArrayList;
import to.marcus.simple_dagger_test.model.Image;
import to.marcus.simple_dagger_test.network.GetWebTask;

/**
 * Created by marcus on 15/04/15
 * request handler for all API calls. Need to expand upon...
 */
public class ApiRequestHandler {

    private final MainBus bus;
    private final GetWebTask httpTask;
    private static final String TAG = "ApiRequestHandler";

    public ApiRequestHandler(MainBus bus, GetWebTask httpTask){
        this.bus = bus;
        this.httpTask = httpTask;
        this.httpTask.execute();
    }

    @Subscribe
    public void onImagesRequested(final HttpTaskEvent event){
        Log.i(TAG, "Received event!");
        final ArrayList<Image> images = event.getResult();
    }
}
