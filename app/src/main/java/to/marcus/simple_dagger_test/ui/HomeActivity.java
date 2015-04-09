package to.marcus.simple_dagger_test.ui;

import android.os.Bundle;
import javax.inject.Inject;
import to.marcus.simple_dagger_test.BaseActivity;
import to.marcus.simple_dagger_test.network.GetWebTask;

/**
 * Created by marcus on 23/03/15
 */
public class HomeActivity extends BaseActivity {
    @Inject
    GetWebTask httpTask;

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
        //working
        httpTask.execute();
    }
}
