package to.marcus.simple_dagger_test;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import java.util.Arrays;
import java.util.List;
import to.marcus.simple_dagger_test.modules.ActivityModule;

/**
 * Created by marcus on 23/03/15
 */
public abstract class BaseActivity extends FragmentActivity {
    //private ObjectGraph activityGraph;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //activityGraph = ((BaseApplication)getApplication()).createScopedGraph(getModules().toArray());
       // activityGraph.inject(this);
    }

    @Override
    protected void onDestroy(){
        //clear reference to activity graph for GC
        //activityGraph = null;
        super.onDestroy();
    }

    protected List<Object> getModules(){
        return Arrays.<Object>asList(new ActivityModule(this));
    }

    //inject the supplied object using the activity-specific graph
    /*
    public void inject(Object object){
        activityGraph.inject(object);
    }
    */
}
