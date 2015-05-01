package to.marcus.simple_dagger_test.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import java.util.ArrayList;
import javax.inject.Inject;
import to.marcus.simple_dagger_test.BaseApplication;
import to.marcus.simple_dagger_test.BaseFragment;
import to.marcus.simple_dagger_test.R;
import to.marcus.simple_dagger_test.model.Photos.Photo;
import to.marcus.simple_dagger_test.modules.PresenterModule;
import to.marcus.simple_dagger_test.ui.presenter.ImagePresenter;

/**
 * Created by marcus on 31/03/15!
 */
public class HomeFragment extends BaseFragment implements ImagePresenter.ImageView{
    private final String TAG = "HomeFragment";
    GridView mGridView;
    ArrayList<Photo> mImages;
    @Inject ImagePresenter presenter;

    public static HomeFragment newInstance(){
        return new HomeFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        BaseApplication.get(getActivity()).createScopedGraph(new PresenterModule(this)).inject(this);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_grid_layout, container, false);
        mGridView = (GridView)v.findViewById(R.id.gridView);
        setupAdapter();
        return v;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater){
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.action, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.refresh:
                Log.i(TAG, "clicked to get images!");
                //presenter.onImagesRequested("test");
                return true;
        }
        Log.i(TAG, "didn't get shit");
        return super.onOptionsItemSelected(item);
    }

    @Override public void onResume(){
        super.onResume();
        presenter.onImagesRequested("test");
    }

    public void setupAdapter(){
        if(getActivity() == null || mGridView == null) return;

        if (mImages != null){
            mGridView.setAdapter(new ArrayAdapter<Photo>(getActivity(),
                    android.R.layout.simple_gallery_item, mImages));
        }else{
            mGridView.setAdapter(null);
        }
    }

    @Override
    public void displayImages(ArrayList<Photo> images) {
        this.mImages = images;
    }

    //showloadingindicator()
        //progressIndicator.setVisibility(Visible)

    //shownoresultsfound
        //showerror

}
