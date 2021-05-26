package institute.college.abvgietconnect.Administration;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.facebook.shimmer.Shimmer;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import institute.college.abvgietconnect.R;

public class Staff extends AppCompatActivity {

    RecyclerView recyclerView;

    private StaffAdapter adapter;

    ShimmerFrameLayout shimmerFrameLayout;

    LinearLayout shimmerlayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff);

        recyclerView = findViewById(R.id.recycler_view);
        /*shimmerFrameLayout = findViewById(R.id.shimmer_view_container);
        shimmerlayout = findViewById(R.id.shimmer_layout);*/



        FirebaseRecyclerOptions<Staffmodel> options =
                new FirebaseRecyclerOptions.Builder<Staffmodel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference("StaffDetails"), Staffmodel.class)
                        .build();
        adapter = new StaffAdapter(options,this);
        recyclerView.setAdapter(adapter);






        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);



    }


    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();



    }

  /*  @Override
    protected void onPause() {
        shimmerFrameLayout.stopShimmer();
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        shimmerFrameLayout.startShimmer();
    }*/

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}