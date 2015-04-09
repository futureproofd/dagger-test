package to.marcus.simple_dagger_test.model;

/**
 * Created by marcus 4/6/2015.
 * Holds image objects. Parameters obtained from Flickr EndPoint
 */
public class Image {
    private String mCaption;
    private String mId;
    private String mUrl;

    //to populate simple_gallery_item layout for our adapter
    @Override
    public String toString(){
        return mCaption;
    }

    public String getCaption() {
        return mCaption;
    }

    public void setCaption(String mCaption) {
        this.mCaption = mCaption;
    }

    public String getId() {
        return mId;
    }

    public void setId(String mId) {
        this.mId = mId;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String mUrl) {
        this.mUrl = mUrl;
    }
}
