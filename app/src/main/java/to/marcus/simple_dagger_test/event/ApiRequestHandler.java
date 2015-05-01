package to.marcus.simple_dagger_test.event;

import android.util.Log;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import to.marcus.simple_dagger_test.model.ImageResponse;
import to.marcus.simple_dagger_test.model.Photos;
import to.marcus.simple_dagger_test.network.ApiService;

/**
 * Created by marcus on 15/04/15
 * request handler for all API calls. Need to expand upon...
 */
public class ApiRequestHandler{

    private final Bus bus;
    private final ApiService apiService;
    private static final String TAG = "ApiRequestHandler";

    //injections 'injected' further via constructor
    public ApiRequestHandler(Bus bus, ApiService apiService){
        this.bus = bus;
        this.apiService = apiService;
    }

    @Subscribe
    public void onImagesRequested(final ImagesRequestedEvent event){
        //this shoud take a string as the result( from the search )
        final String image = event.getResult();
        apiService.getRecent("flickr.photos.getRecent",
                "4b37ee018d17b1aa7cd793ede2ea7ee7",
                "json",
                "1",
                new Callback<ImageResponse>() {
                    @Override
                    public void success(ImageResponse imageResponse, Response response) {
                        bus.post(new ImagesReceivedEvent( imageResponse.getPhotosObject().getPhotos()));
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        Log.e(TAG, " " + error.getUrl());
                        Log.e(TAG, " " + error.getMessage());
                        bus.post(new HttpFailedEvent("failed :( "));
                    }
                });
    }
}
