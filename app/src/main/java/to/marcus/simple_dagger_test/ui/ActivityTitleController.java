package to.marcus.simple_dagger_test.ui;

import android.app.Activity;

/**
 * Just an example
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
