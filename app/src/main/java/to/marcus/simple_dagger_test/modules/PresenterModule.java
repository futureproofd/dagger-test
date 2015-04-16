package to.marcus.simple_dagger_test.modules;

import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import to.marcus.simple_dagger_test.event.MainBus;
import to.marcus.simple_dagger_test.model.ImageStorage;
import to.marcus.simple_dagger_test.presenter.ImagePresenter;
import to.marcus.simple_dagger_test.ui.HomeActivity;
import to.marcus.simple_dagger_test.ui.HomeFragment;

/**
 * Created by marcus on 4/2/2015
 */

@Module(injects = HomeFragment.class,
        addsTo = ApplicationModule.class,
        complete = false
)
public class PresenterModule {

    @Provides @Singleton
    ImagePresenter provideImagePresenter(MainBus bus){
        return new ImagePresenter(bus);
    }
}
