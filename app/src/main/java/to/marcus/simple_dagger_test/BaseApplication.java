package to.marcus.simple_dagger_test;

import android.app.Application;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import dagger.ObjectGraph;
import to.marcus.simple_dagger_test.modules.ApplicationModule;

/**
 * Created by marcus on 23/03/15.
 */
public class BaseApplication extends Application {
    private ObjectGraph applicationGraph;

    @Override
    public void onCreate(){
        super.onCreate();
        applicationGraph = ObjectGraph.create(getModules().toArray());
    }

    /**
     * list of modules to use for the application graph
     * @return list
     */
    protected List<Object> getModules(){
        return Arrays.<Object>asList(new ApplicationModule(this));
    }

    ObjectGraph getApplicationGraph(){
        return applicationGraph;
    }
}
