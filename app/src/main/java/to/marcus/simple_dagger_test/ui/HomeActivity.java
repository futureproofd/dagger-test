package to.marcus.simple_dagger_test.ui;

import android.os.Bundle;

import java.util.ArrayList;

import javax.inject.Inject;

import to.marcus.simple_dagger_test.BaseActivity;
import to.marcus.simple_dagger_test.model.Image;
import to.marcus.simple_dagger_test.model.ImageStorage;

/**
 * Created by marcus on 23/03/15
 */
public class HomeActivity extends BaseActivity {
    private static final String TAG = "HomeActivity";
    private ArrayList<Image> mImages;

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
    }
}
