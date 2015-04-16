package to.marcus.simple_dagger_test.modules;

import android.content.Context;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import to.marcus.simple_dagger_test.BaseApplication;
import to.marcus.simple_dagger_test.event.MainBus;
import to.marcus.simple_dagger_test.network.EndPoint;
import to.marcus.simple_dagger_test.network.GetWebTask;
import to.marcus.simple_dagger_test.network.WebConnection;

/**
 * A module for Android-specific dependencies which require a {@link Context} or
 * {@link android.app.Application} to create.
 */

@Module(
        injects = BaseApplication.class
)

public class ApplicationModule {

    public ApplicationModule() {
    }

    /**
     * allow the application context to be injected, but require that it be annotated with
     * /* {@link to.marcus.simple_dagger_test.ForApplication @Annotation} to explicitly differentiate it from an activity context.
     */
/*
    @Provides @Singleton @ForApplication
    Context provideApplicationContext(){
        return application;
    }

    @Provides @Singleton
    LayoutInflater provideLayoutInflater(){
        return (LayoutInflater) application.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
*/
    @Provides
    @Singleton
    public MainBus provideMainBus() {
        return new MainBus();
    }

    @Provides
    @Singleton
    public WebConnection provideConnection() {
        return new WebConnection();
    }

    @Provides
    @Singleton
    public EndPoint provideEndPoint() {
        return new EndPoint();
    }

    @Provides
    @Singleton
    public GetWebTask provideData(WebConnection httpConnection, EndPoint endPoint, MainBus bus) {
        return new GetWebTask(httpConnection, endPoint, bus);
    }
}
