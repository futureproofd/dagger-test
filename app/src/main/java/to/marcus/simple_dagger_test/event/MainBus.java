package to.marcus.simple_dagger_test.event;

import android.os.Handler;
import android.os.Looper;
import com.squareup.otto.Bus;

/**
 * Created by marcus on 13/04/15.
 * Injectable Event Bus
 * Needed to override post method:
 * It is not the responsibility of the event bus (which is purely a subscription/distribution mechanism)
 * to know about or change the thread on which event propagation is happening. Creating a handler for
 * our AsyncTask requires this
 */
public class MainBus extends Bus{
    private final Handler handler = new Handler(Looper.getMainLooper());
    private static Bus instance = null;

    @Override
    public void post(final Object event){
        if(Looper.myLooper() == Looper.getMainLooper()){
            super.post(event);
        }else{
            handler.post(new Runnable() {
                @Override
                public void run() {
                    MainBus.super.post(event);
                }
            });
        }
    }

    public MainBus(){
        instance = new Bus();
    }

    public static Bus getInstance(){
        if(instance == null){
            instance = new MainBus();
        }
        return instance;
    }
}
