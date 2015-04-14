package to.marcus.simple_dagger_test.modules;

import android.content.Context;
import android.view.LayoutInflater;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import to.marcus.simple_dagger_test.BaseApplication;
import to.marcus.simple_dagger_test.ForApplication;

/**
 * A module for Android-specific dependencies which require a {@link Context} or
 * {@link android.app.Application} to create.
 */

@Module(library = true)
public class ApplicationModule {
    private final BaseApplication application;

    public ApplicationModule(BaseApplication application){
        this.application = application;
    }

    /**allow the application context to be injected, but require that it be annotated with
    /* {@link to.marcus.simple_dagger_test.ForApplication @Annotation} to explicitly differentiate it from an activity context.
    */

    @Provides @Singleton @ForApplication
    Context provideApplicationContext(){
        return application;
    }

    @Provides @Singleton
    LayoutInflater provideLayoutInflater(){
        return (LayoutInflater) application.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
}
