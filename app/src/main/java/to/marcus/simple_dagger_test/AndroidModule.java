package to.marcus.simple_dagger_test;

import android.content.Context;
import android.location.LocationManager;
import android.view.LayoutInflater;

import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import timber.log.Timber;

/**
 * Created by marcus on 23/03/15.
 */

/**
 * A module for Android-specific dependencies which require a {@link Context} or
 * {@link android.app.Application} to create.
 */

@Module(library = true)
public class AndroidModule {
    private final DemoApplication application;

    public AndroidModule(DemoApplication application){
        this.application = application;
    }

    /**allow the application context to be injected, but require that it be annotated with
    /* {@link ForApplication @Annotation} to explicitly differentiate it from an activity context.
    */

    @Provides @Singleton @ForApplication
    Context provideApplicationContext(){
        return application;
    }

    @Provides @Singleton
    LocationManager provideLocationManager(){
        return (LocationManager) application.getSystemService(Context.LOCATION_SERVICE);
    }

    @Provides @Singleton
    LayoutInflater provideLayoutInflater(){
        return (LayoutInflater) application.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Provides @Singleton
    Timber.Tree provideLogging(){
        if (BuildConfig.DEBUG) {
            return new Timber.DebugTree();
        }
        return new Timber.DebugTree();
    }

}
