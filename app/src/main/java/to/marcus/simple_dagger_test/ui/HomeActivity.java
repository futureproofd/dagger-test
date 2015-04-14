package to.marcus.simple_dagger_test.ui;

import android.os.Bundle;
import android.util.Log;
import javax.inject.Inject;
import to.marcus.simple_dagger_test.BaseActivity;
import to.marcus.simple_dagger_test.event.MainBus;
import to.marcus.simple_dagger_test.event.httpTaskEvent;
import to.marcus.simple_dagger_test.model.ImageStorage;
import to.marcus.simple_dagger_test.network.GetWebTask;

/**
 * Created by marcus on 23/03/15
 */
public class HomeActivity extends BaseActivity {
    private static final String TAG = "HomeActivity";
    @Inject
    GetWebTask httpTask;
    @Inject
    MainBus mBus;
    @Inject
    ImageStorage imageStorage;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //after the super.onCreate call returns, we are guaranteed our injections are available
        //do something with injected dependencies here
        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .add(android.R.id.content, HomeFragment.newInstance())
                    .commit();
        }
        httpTask.execute();
    }

    @Override
    public void onResume(){
        super.onResume();
        //get event bus receiver
        mBus.getInstance().register(this);
    }

    @Override
    protected void onDestroy(){
        mBus.getInstance().unregister(this);
        super.onDestroy();
    }

    @com.squareup.otto.Subscribe
    public void onHttpTaskResult(httpTaskEvent event){
        Log.i(TAG, "received Event!");
        imageStorage.setImages(event.getResult());
    }

}
