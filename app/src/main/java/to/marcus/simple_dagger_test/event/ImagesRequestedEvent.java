package to.marcus.simple_dagger_test.event;

/**
 * Created by mplienegger on 4/20/2015
 */
public class ImagesRequestedEvent {

    private String result;

    public ImagesRequestedEvent(String result){
        this.result = result;
    }

    public String getResult(){
        return result;
    }
}
