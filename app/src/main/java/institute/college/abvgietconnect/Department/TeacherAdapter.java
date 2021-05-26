package institute.college.abvgietconnect.Department;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.List;

import institute.college.abvgietconnect.R;

public class TeacherAdapter extends RecyclerView.Adapter<TeacherAdapter.TeacherViewAdapter> {

    private List<TeacherModel> list;
    private Context context;

    public TeacherAdapter(List<TeacherModel> list, Context context) {
        this.list = list;
        this.context = context;

    }

    @NonNull
    @Override
    public TeacherViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.faculty_item_layout, parent, false);
        return new TeacherViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeacherViewAdapter holder, int position) {

        TeacherModel item = list.get(position);
        holder.name.setText(item.getName());
        holder.email.setText(item.getEmail());
        holder.des.setText(item.getDesignation());


        try {
            Glide.with(context).load(item.getImage()).into(holder.imageView);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class TeacherViewAdapter extends RecyclerView.ViewHolder {

        private final TextView name;
        private final TextView email;
        private final TextView des;
        private final ImageView imageView;

        public TeacherViewAdapter(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.teacherName);
            email = itemView.findViewById(R.id.teacherEmail);
            des = itemView.findViewById(R.id.teacherDes);

            imageView = itemView.findViewById(R.id.teacherImage);


        }
    }

}
