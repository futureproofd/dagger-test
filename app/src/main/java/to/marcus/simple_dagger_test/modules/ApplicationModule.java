package to.marcus.simple_dagger_test.modules;

import android.content.Context;
import com.squareup.otto.Bus;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import retrofit.Endpoint;
import retrofit.RestAdapter;
import to.marcus.simple_dagger_test.BaseApplication;
import to.marcus.simple_dagger_test.network.ApiEndpoint;
import to.marcus.simple_dagger_test.network.ApiService;

/**
 * A module for Android-specific dependencies which require a {@link Context} or
 * {@link android.app.Application} to create.
 */

@Module(
        injects = BaseApplication.class
)

public class ApplicationModule {

    private final String apiKey;

    public ApplicationModule(String apiKey) {
        this.apiKey = apiKey;
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
    public Bus provideBus() {
        return new Bus();
    }

    @Provides
    @Singleton
    public ApiEndpoint provideEndPoint() {
        return new ApiEndpoint();
    }

    @Provides
    @Singleton
    public ApiService provideApiService(ApiEndpoint endpoint){
        return new RestAdapter.Builder()
                .setEndpoint(endpoint)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build()
                .create(ApiService.class);
    }
}
