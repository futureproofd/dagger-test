package to.marcus.simple_dagger_test.modules;

import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import to.marcus.simple_dagger_test.network.EndPoint;
import to.marcus.simple_dagger_test.network.GetWebTask;
import to.marcus.simple_dagger_test.network.WebConnection;
import to.marcus.simple_dagger_test.ui.HomeActivity;

/**
 * Created by marcus on 4/2/2015
 */

@Module(injects = HomeActivity.class)

public class ConnectionModule {

    private WebConnection httpConnection;

    @Provides @Singleton
    public WebConnection provideConnection() {
        return new WebConnection();
    }

    @Provides @Singleton
    public EndPoint provideEndPoint() {
        return new EndPoint();
    }

    @Provides @Singleton
    public GetWebTask provideData(WebConnection httpConnection, EndPoint endPoint) {
        return new GetWebTask(httpConnection, endPoint);
    }
}

