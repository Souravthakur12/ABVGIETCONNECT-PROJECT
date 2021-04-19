package institute.college.abvgietconnect;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.List;

public class ImageSliderAdapter extends SliderViewAdapter<SliderViewHolder> {

    Context context;
    List<ImageSliderModel> imageSliderModelList;



    public ImageSliderAdapter(Context context,List<ImageSliderModel> imageSliderModelList)
    {
        this.context = context;
       this.imageSliderModelList = imageSliderModelList;

    }

    @Override
    public SliderViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.slider_item_layout,parent,false);
        return new SliderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SliderViewHolder viewHolder, int position) {
      viewHolder.sliderImageView.setImageResource(imageSliderModelList.get(position).getImage());

    }

    @Override
    public int getCount() {
        return imageSliderModelList.size();
    }
}

class SliderViewHolder extends SliderViewAdapter.ViewHolder{
    ImageView sliderImageView;
    View itemView;
    public SliderViewHolder(View itemView) {
        super(itemView);
        this.itemView = itemView;
        sliderImageView = itemView.findViewById(R.id.imageView);
    }
}
