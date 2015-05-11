package to.marcus.simple_dagger_test.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;
import to.marcus.simple_dagger_test.R;
import to.marcus.simple_dagger_test.model.Photos;

/**
 * Created by mplienegger on 5/11/2015.
 */
public class PhotoAdapter extends ArrayAdapter<Photos.Photo> {

    private final Context context;
    private LayoutInflater mLayoutInflater;
    private final ArrayList<Photos.Photo> mPhotos;
    private ViewHolder viewHolder;

    public PhotoAdapter(Context context, ArrayList<Photos.Photo> photos){
        super(context, android.R.layout.simple_list_item_1, photos);
        this.context = context;
        this.mPhotos = photos;
        this.mLayoutInflater = LayoutInflater.from(context);
    }

    static class ViewHolder{
        ImageView imageView;
    }

    @Override
    public int getCount() {
        return mPhotos == null ? 0 : mPhotos.size();
    }

    @Override
    public Photos.Photo getItem(int position) {
        return mPhotos == null ? null : mPhotos.get(position);
    }

    @Override
    public long getItemId(int position) {return position;}

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        if(view == null){
            view = mLayoutInflater.inflate(R.layout.photo_item, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.imageView = (ImageView) view.findViewById(R.id.photo_item_imageView);
            viewHolder.imageView.setImageResource(R.drawable.ic_launcher);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)view.getTag();
        }
        //do something with each image
        return view;
    }
}
