package to.marcus.simple_dagger_test;

import android.app.Application;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import dagger.ObjectGraph;
import timber.log.Timber;

/**
 * Created by marcus on 23/03/15.
 */
public class DemoApplication extends Application {
    private ObjectGraph graph;

    @Override
    public void onCreate(){
        super.onCreate();
        graph = ObjectGraph.create(getModules().toArray());
    }

    protected List<Object> getModules(){
        return Arrays.asList(
                new AndroidModule(this),
                new DemoModule()
        );
    }

    //which objects to inject on (activity in this case)
    public void inject(Object object){
        graph.inject(object);
    }
}
