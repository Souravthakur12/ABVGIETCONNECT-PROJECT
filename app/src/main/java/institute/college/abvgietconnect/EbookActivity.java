package institute.college.abvgietconnect;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import institute.college.abvgietconnect.Adapter.EbookAdapter;
import institute.college.abvgietconnect.Models.EbookModel;

public class EbookActivity extends AppCompatActivity {
    private RecyclerView ebookRecycler;
    private DatabaseReference reference;
    private List<EbookModel> list;
    private EbookAdapter adaptor;
    private ProgressDialog progressDialog;

    ShimmerFrameLayout shimmerFrameLayout;

    LinearLayout shimmerlayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ebook);
        ebookRecycler=findViewById(R.id.ebookRecycler);
        shimmerFrameLayout = findViewById(R.id.shimmer_view_container_pdf);
        shimmerlayout = findViewById(R.id.shimmer_layout_pdf);

        reference= FirebaseDatabase.getInstance().getReference().child("pdf");
        getData();


        progressDialog = new ProgressDialog(this);

    }

    private void getData() {

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                progressDialog.show();

                list= new ArrayList<>();
                for(DataSnapshot snapshot1: snapshot.getChildren()){
                    EbookModel data =snapshot1.getValue(EbookModel.class);
                    list.add(data);

                }
                adaptor=new EbookAdapter(EbookActivity.this,list);
                ebookRecycler.setLayoutManager(new LinearLayoutManager(EbookActivity.this));
                ebookRecycler.setAdapter(adaptor);
                progressDialog.dismiss();
                shimmerlayout.setVisibility(View.GONE);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                progressDialog.dismiss();
                Toast.makeText(EbookActivity.this,error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id ==R.id.sort1)
        {
            Collections.sort(list, new Comparator<EbookModel>() {
                @Override
                public int compare(EbookModel o1, EbookModel o2) {
                    return o1.getPdftitle().compareTo(o2.getPdftitle());
                }
            });

            adaptor.notifyDataSetChanged();

        }
       else if (id == R.id.sort2)
        {
            Collections.sort(list, new Comparator<EbookModel>() {
                @Override
                public int compare(EbookModel o1, EbookModel o2) {
                    return o2.getPdftitle().compareTo(o1.getPdftitle());
                }
            });

            adaptor.notifyDataSetChanged();

        }
        return true;
    }

      @Override
    protected void onPause() {
        shimmerFrameLayout.stopShimmer();
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        shimmerFrameLayout.startShimmer();
    }

}