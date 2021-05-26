package institute.college.abvgietconnect.StudentZone;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;

import institute.college.abvgietconnect.Adapter.PostAdapter;
import institute.college.abvgietconnect.Models.StoryModel;
import institute.college.abvgietconnect.R;

public class StoreisTab extends HomePage {
    @Nullable
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.stories_tab, container, false);
        return view;


    }



}
