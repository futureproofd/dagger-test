package to.marcus.simple_dagger_test;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import java.util.Arrays;
import java.util.List;
import dagger.ObjectGraph;
import to.marcus.simple_dagger_test.modules.ActivityModule;
import to.marcus.simple_dagger_test.modules.ConnectionModule;

/**
 * Created by marcus on 23/03/15
 */
public abstract class BaseActivity extends FragmentActivity {
    private ObjectGraph activityGraph;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        //Create activity Graph by .plus-ing our modules onto the application graph
        BaseApplication application = (BaseApplication) getApplication();
        activityGraph = application.getApplicationGraph().plus(getModules().toArray());
        //perform injection so that when this call returns, all dependencies will be available for use
        activityGraph.inject(this);
    }

    @Override
    protected void onDestroy(){
        //clear reference to activity graph for GC
        activityGraph = null;
        super.onDestroy();
    }

    protected List<Object> getModules(){
        return Arrays.<Object>asList(new ActivityModule(this),
                new ConnectionModule());
    }

    //inject the supplied object using the activity-specific graph
    public void inject(Object object){
        activityGraph.inject(object);
    }
}
