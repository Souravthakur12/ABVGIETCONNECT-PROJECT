package institute.college.abvgietconnect;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class GalleryActivity extends AppCompatActivity {

    private RecyclerView staggeredRv;
    private StaggeredRecyclerAdapter adapter;
    private StaggeredGridLayoutManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);


        staggeredRv = findViewById(R.id.staggered_rv);
        manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        staggeredRv.setLayoutManager(manager);

        List<row> list = new ArrayList<>();
        list.add(new row(R.drawable.photo));
        list.add(new row(R.drawable.labs));
        list.add(new row(R.drawable.pic1));
        list.add(new row(R.drawable.pic2));
        list.add(new row(R.drawable.pic3));
        list.add(new row(R.drawable.pic4));
        list.add(new row(R.drawable.pic3));
        list.add(new row(R.drawable.pic2));
        list.add(new row(R.drawable.pic1));
        list.add(new row(R.drawable.pic4));
        list.add(new row(R.drawable.pic2));
        list.add(new row(R.drawable.labs));

        adapter = new StaggeredRecyclerAdapter(this, list);
        staggeredRv.setAdapter(adapter);

    }
}