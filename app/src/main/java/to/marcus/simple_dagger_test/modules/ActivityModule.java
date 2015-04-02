package to.marcus.simple_dagger_test.modules;


import android.content.Context;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import to.marcus.simple_dagger_test.BaseActivity;
import to.marcus.simple_dagger_test.ForActivity;
import to.marcus.simple_dagger_test.network.WebConnection;
import to.marcus.simple_dagger_test.ui.ActivityTitleController;
import to.marcus.simple_dagger_test.ui.HomeActivity;
import to.marcus.simple_dagger_test.ui.HomeFragment;

/**
 * module only for objects existing on the scope of a single activity
 * can create activity specific singletons
 */
@Module(
        injects ={
                HomeActivity.class,
                HomeFragment.class
        },
        includes ={
          ConnectionModule.class
        },
        library = true
)
public class ActivityModule {
    private final BaseActivity activity;

    public ActivityModule(BaseActivity activity){
        this.activity = activity;
    }

    /**
     * allow the activity context to be injected but annotated to differentiate from application
     * context
     */
    @Provides @Singleton @ForActivity
    Context provideActivityContext(){
        return activity;
    }

    @Provides @Singleton
    ActivityTitleController provideTitleController(){
        return new ActivityTitleController(activity);
    }

}
