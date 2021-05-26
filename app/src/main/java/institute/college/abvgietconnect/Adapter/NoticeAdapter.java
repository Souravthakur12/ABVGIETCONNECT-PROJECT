package institute.college.abvgietconnect.Adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import institute.college.abvgietconnect.Models.NoticeModel;
import institute.college.abvgietconnect.R;

public class NoticeAdapter extends RecyclerView.Adapter<NoticeAdapter.NoticeViewAdapter> {
    private Context context;
    private ArrayList<NoticeModel> list;

    public NoticeAdapter(Context context, ArrayList<NoticeModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public NoticeViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_notice_layout, parent, false);
        return new NoticeViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoticeViewAdapter holder, int position) {
        NoticeModel currentItem = list.get(position);
        holder.showNoticeTitle.setText(currentItem.getTitle());
        holder.date.setText(currentItem.getData());
        holder.time.setText(currentItem.getTime());
        try {
            if (currentItem.getImage() != null)
                Picasso.get().load(currentItem.getImage()).into(holder.showNoticeImage);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class NoticeViewAdapter extends RecyclerView.ViewHolder {

        private TextView showNoticeTitle, date, time;
        private ImageView showNoticeImage;

        public NoticeViewAdapter(@NonNull View itemView) {
            super(itemView);

            showNoticeTitle = itemView.findViewById(R.id.showNoticeTitle);
            showNoticeImage = itemView.findViewById(R.id.showNoticeImage);
            date = itemView.findViewById(R.id.date);
            time = itemView.findViewById(R.id.time1);
        }
    }
}
