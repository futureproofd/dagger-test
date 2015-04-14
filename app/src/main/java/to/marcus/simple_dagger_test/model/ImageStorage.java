package to.marcus.simple_dagger_test.model;

import java.util.ArrayList;

/**
 * Created by marcus on 4/10/2015
 */
public class ImageStorage {
    private ArrayList<Image> mImages;

    public ImageStorage(){
    }

    public ArrayList<Image> getImages() {
        return mImages;
    }

    public void setImages(ArrayList<Image> mImages) {
        this.mImages = mImages;
    }
}
