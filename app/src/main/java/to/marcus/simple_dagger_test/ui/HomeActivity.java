package to.marcus.simple_dagger_test.ui;

import android.os.Bundle;
import to.marcus.simple_dagger_test.BaseActivity;

/**
 * Created by marcus on 23/03/15
 */
public class HomeActivity extends BaseActivity {
    private static final String TAG = "HomeActivity";

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
