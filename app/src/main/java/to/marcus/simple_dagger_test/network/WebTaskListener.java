package to.marcus.simple_dagger_test.network;

/**
 * Created by mplienegger on 4/13/2015.
 */
public interface WebTaskListener<T> {

    public void onTaskComplete(T result);

    public WebTaskListener get();
}
