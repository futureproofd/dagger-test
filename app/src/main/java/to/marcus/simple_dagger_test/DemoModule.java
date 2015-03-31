package to.marcus.simple_dagger_test;

import dagger.Module;
import to.marcus.simple_dagger_test.ui.HomeActivity;

/**
 * Created by marcus on 23/03/15.
 */

@Module(
    injects = HomeActivity.class,
    complete = false
)

public class DemoModule {
    //put application specific providers here
}
