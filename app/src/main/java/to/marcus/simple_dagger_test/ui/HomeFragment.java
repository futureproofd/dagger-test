package to.marcus.simple_dagger_test.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import java.util.ArrayList;
import to.marcus.simple_dagger_test.BaseFragment;
import to.marcus.simple_dagger_test.R;
import to.marcus.simple_dagger_test.model.Image;
import to.marcus.simple_dagger_test.network.GetWebTask;

/**
 * Created by marcus on 31/03/15!
 */
public class HomeFragment extends BaseFragment{
    GridView mGridView;
    ArrayList<Image> mImages;
    GetWebTask httpTask;
    //  @Inject
    // ActivityTitleController titleController;

    public static HomeFragment newInstance(){
        return new HomeFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //Not working: NPE on httpTask instance
        //mImages = httpTask.getImages();
    }

    @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                       Bundle savedInstanceState){

        View v = inflater.inflate(R.layout.fragment_grid_layout, container, false);
        mGridView = (GridView)v.findViewById(R.id.gridView);
        setupAdapter();
        return v;
    }

    @Override public void onResume(){
        super.onResume();
        //titleController.setTitle("Home Fragment");
    }


    public void setupAdapter(){
        if(getActivity() == null || mGridView == null) return;

        if (mImages != null){
            mGridView.setAdapter(new ArrayAdapter<Image>(getActivity(),
                    android.R.layout.simple_gallery_item, mImages));
        }else{
            mGridView.setAdapter(null);
        }
    }

}
