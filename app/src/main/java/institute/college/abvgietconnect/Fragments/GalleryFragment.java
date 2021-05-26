 package institute.college.abvgietconnect.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import institute.college.abvgietconnect.Adapter.GalleryAdapter;
import institute.college.abvgietconnect.R;

 /**
 * A simple {@link Fragment} subclass.
 * Use the {@link GalleryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GalleryFragment extends Fragment {


    private StaggeredGridLayoutManager manager;


    RecyclerView manaliRecycler;
    RecyclerView convoRecycler;
    RecyclerView teacherRecycler;
    GalleryAdapter adapter;

    DatabaseReference reference;



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public GalleryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment galleryimage_fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GalleryFragment newInstance(String param1, String param2) {
        GalleryFragment fragment = new GalleryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);
        manaliRecycler=view.findViewById(R.id.manaliRecycler);
        convoRecycler=view.findViewById(R.id.convoRecycler);
        teacherRecycler = view.findViewById(R.id.teacherDayRecycler);


        reference =FirebaseDatabase.getInstance().getReference().child("Gallery");
        getManaliImage();
        getConvoImage();
        getTeacherDayImage();
        return view;
    }

     private void getTeacherDayImage() {

         reference.child("Teacher Day").addValueEventListener(new ValueEventListener() {

             List<String> imageList =new ArrayList<>();
             @Override
             public void onDataChange(@NonNull DataSnapshot snapshot) {

                 for (DataSnapshot snapshot1: snapshot.getChildren())
                 {
                     String data = (String)snapshot1.getValue();
                     imageList.add(data);
                 }
                 adapter=new GalleryAdapter(getContext(),imageList);

                 manager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
                 teacherRecycler.setLayoutManager(manager);
                 teacherRecycler.setAdapter(adapter);

             }

             @Override
             public void onCancelled(@NonNull DatabaseError error) {

             }
         });
     }


     private  void getConvoImage()
    {
        reference.child("Convocation").addValueEventListener(new ValueEventListener() {

            List<String> imageList =new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot snapshot1: snapshot.getChildren())
                {
                    String data = (String)snapshot1.getValue();
                    imageList.add(data);
                }
                adapter=new GalleryAdapter(getContext(),imageList);

                manager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
                convoRecycler.setLayoutManager(manager);
                convoRecycler.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }



    private  void getManaliImage()
    {
        reference.child("Manali Trip").addValueEventListener(new ValueEventListener() {

            List<String> imageList =new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot snapshot1: snapshot.getChildren())
                {
                    String data = (String)snapshot1.getValue();
                    imageList.add(data);
                }
                adapter=new GalleryAdapter(getContext(),imageList);
                manager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
                manaliRecycler.setLayoutManager(manager);
                manaliRecycler.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            //    Toast.makeText(galleryimage_fragment.this,""+error.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });


    }

    }
