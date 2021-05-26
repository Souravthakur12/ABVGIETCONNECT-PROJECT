package institute.college.abvgietconnect;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StaggeredRecyclerAdapter extends RecyclerView.Adapter<StaggeredRecyclerAdapter.ImageViewHolder> {

    Context mContext;
    List<row> mdata;

    public StaggeredRecyclerAdapter(Context mContext, List<row> mdata) {
        this.mContext = mContext;
        this.mdata = mdata;
    }

    @NonNull
    @Override
    public StaggeredRecyclerAdapter.ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.row_item, parent, false);

        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StaggeredRecyclerAdapter.ImageViewHolder holder, int position) {

        holder.img.setImageResource(mdata.get(position).getImg());
    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder {

        ImageView img;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.row_img);


        }
    }
}
