package to.marcus.simple_dagger_test.ui;

import android.app.Application;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.LayoutInflater;

import javax.inject.Inject;

import timber.log.Timber;
import to.marcus.simple_dagger_test.DemoBaseActivity;

/**
 * Created by marcus on 23/03/15.
 */
public class HomeActivity extends DemoBaseActivity {
    @Inject
    LocationManager locationManager;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //after the super.onCreate call returns, we are guaranteed our injections are available
        //because of the DemoBaseActivity inject call
        mTimber.i("onCreate");
        //do something with injected dependencies here
    }
}
