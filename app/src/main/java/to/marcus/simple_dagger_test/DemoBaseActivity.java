package to.marcus.simple_dagger_test;

import android.app.Activity;
import android.os.Bundle;

import javax.inject.Inject;

import timber.log.Timber;

/**
 * Created by marcus on 23/03/15.
 */
public abstract class DemoBaseActivity extends Activity {

    @Inject
    public Timber mTimber;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        //perform injection so that when this call returns, all dependencies will be available for use
        ((DemoApplication) getApplication()).inject(this);
    }
}
