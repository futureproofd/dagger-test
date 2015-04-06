package to.marcus.simple_dagger_test.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import javax.inject.Inject;
import to.marcus.simple_dagger_test.BaseFragment;

/**
 * Created by marcus on 31/03/15!
 */
public class HomeFragment extends BaseFragment{
    public static HomeFragment newInstance(){
        return new HomeFragment();
    }

    @Inject
    ActivityTitleController titleController;

    @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                       Bundle savedInstanceState){
        TextView tv = new TextView(getActivity());
        tv.setText("Hi");
        return tv;
    }

    @Override public void onResume(){
        super.onResume();
        titleController.setTitle("Home Fragment");
    }

}
