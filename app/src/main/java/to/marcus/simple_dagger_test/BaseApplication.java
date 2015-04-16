package to.marcus.simple_dagger_test;

import android.app.Application;
import android.content.Context;
import javax.inject.Inject;
import dagger.ObjectGraph;
import to.marcus.simple_dagger_test.event.ApiRequestHandler;
import to.marcus.simple_dagger_test.event.MainBus;
import to.marcus.simple_dagger_test.modules.Modules;
import to.marcus.simple_dagger_test.network.GetWebTask;

/**
 * Created by marcus on 23/03/15
 */

public class BaseApplication extends Application {
    private ObjectGraph applicationGraph;
    @Inject GetWebTask httpTask;
    @Inject MainBus mainBus;

    @Override
    public void onCreate(){
        super.onCreate();
        applicationGraph = ObjectGraph.create(Modules.list());
            applicationGraph.inject(this);
        createApiRequestHandler();
        //mainBus.getInstance().register(this);
    }

    ObjectGraph getApplicationGraph(){
        return applicationGraph;
    }

    public static BaseApplication get(Context c){
        return (BaseApplication) c.getApplicationContext();
    }

/*
    @com.squareup.otto.Subscribe
    public void onHttpTaskResult(HttpTaskEvent event){
        Log.i(TAG, "received Event!");
        //ImageStorage.setImages(event.getResult());
    }
*/

    private void createApiRequestHandler(){
        mainBus.register(new ApiRequestHandler(mainBus, httpTask));
    }
}
