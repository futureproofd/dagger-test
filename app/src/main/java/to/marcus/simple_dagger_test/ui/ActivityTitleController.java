package to.marcus.simple_dagger_test.ui;

import android.app.Activity;

/**
 * Created by marcus on 31/03/15.
 */
public class ActivityTitleController {
    private final Activity activity;

    public ActivityTitleController(Activity activity){
        this.activity = activity;
    }

    public void setTitle(CharSequence title){
        activity.setTitle(title);
    }
}
