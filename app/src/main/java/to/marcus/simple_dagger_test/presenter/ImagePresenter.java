package to.marcus.simple_dagger_test.presenter;

import to.marcus.simple_dagger_test.event.MainBus;

/**
 * Created by marcus on 15/04/15
 */

public class ImagePresenter {

    private final MainBus bus;

    public ImagePresenter(MainBus bus){
        this.bus = bus;
    }

    public void onImagesRequested(){
        //view.showloading etc
        //bus.post(new HttpTaskEvent());
    }
}
