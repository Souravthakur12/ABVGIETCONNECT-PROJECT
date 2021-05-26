package institute.college.abvgietconnect.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import institute.college.abvgietconnect.Adapter.NoticeAdapter;
import institute.college.abvgietconnect.Models.NoticeModel;
import institute.college.abvgietconnect.R;

public class NoticeFragment extends Fragment {

    private RecyclerView showNoticeRecycler;
    private ProgressBar progressBar;
    private ArrayList<NoticeModel> list;
    private NoticeAdapter adapter;

    private DatabaseReference reference;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_notice, container, false);
        showNoticeRecycler = view.findViewById(R.id.showNoticeRecycler);
        progressBar = view.findViewById(R.id.progressBar);
        reference= FirebaseDatabase.getInstance().getReference().child("Notice");


        showNoticeRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        showNoticeRecycler.setHasFixedSize(true);
        getNotice();
        return view;
    }

    private void getNotice() {
        reference.addValueEventListener(new ValueEventListener(){

            public void onDataChange(DataSnapshot dataSnapshot)
            {
                list = new ArrayList<>();
                for (DataSnapshot  snapshot: dataSnapshot.getChildren())
                {
                    NoticeModel data = snapshot.getValue(NoticeModel.class);
                    list.add(data);
                }
                adapter = new NoticeAdapter(getContext(),list);
                adapter.notifyDataSetChanged();
                progressBar.setVisibility(View.GONE);
                showNoticeRecycler.setAdapter(adapter);
            }
            public  void onCancelled(DatabaseError databaseError)
            {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(getContext(),databaseError.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }

}

