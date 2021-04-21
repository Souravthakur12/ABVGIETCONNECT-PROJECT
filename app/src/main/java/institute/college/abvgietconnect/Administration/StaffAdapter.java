package institute.college.abvgietconnect.Administration;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import java.util.List;

import institute.college.abvgietconnect.R;

public class StaffAdapter extends FirebaseRecyclerAdapter<Staffmodel,StaffAdapter.StaffViewHolder> {

    Context mcontext;


    public StaffAdapter(@NonNull FirebaseRecyclerOptions<Staffmodel> options,Context mcontext) {
        super(options);
        this.mcontext = mcontext;
    }


    @Override
    protected void onBindViewHolder(@NonNull StaffAdapter.StaffViewHolder holder, int position, @NonNull Staffmodel model) {

        holder.textView1.setText(model.getName());
        holder.textView2.setText(model.getDesignation());

    }

    @NonNull
    @Override
    public StaffAdapter.StaffViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.staff_list_view, parent, false);
        return new StaffViewHolder(view);


    }

    public static class StaffViewHolder extends RecyclerView.ViewHolder {

        TextView textView1,textView2;


        public StaffViewHolder(@NonNull final View itemView) {
            super(itemView);

            textView1 = itemView.findViewById(R.id.fac_name);
            textView2 = itemView.findViewById(R.id.fac_des);
        }
    }
}


