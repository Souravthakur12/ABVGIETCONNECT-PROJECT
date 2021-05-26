package institute.college.abvgietconnect.StudentZone;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.squareup.picasso.Picasso;

import institute.college.abvgietconnect.Models.StoryModel;
import institute.college.abvgietconnect.R;

public class StoryViewHolder  extends RecyclerView.ViewHolder {

    ImageView imageView ;
    TextView textView;

    FirebaseUser user;
    Context context;
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    public StoryViewHolder(@NonNull View itemView) {
        super(itemView);
    }
    public void setStory(Activity activity, String postUri,
                         String name, long timeEnd, String timeUpload, String type, String caption, String url, String uid){

        imageView = itemView.findViewById(R.id.iv_story);
        textView = itemView.findViewById(R.id.tv_unamestory);

      //  Glide.with(context).load(user.getPhotoUrl()).into(imageView);

        //Picasso.get().load(url).into(imageView);
        textView.setText(name);

    }

    public void onBindViewHolder(@NonNull StoryViewHolder holder, int position,@NonNull StoryModel model) {
        holder.textView.setText(model.getName());
    }


}
