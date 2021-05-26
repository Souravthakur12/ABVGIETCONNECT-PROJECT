package institute.college.abvgietconnect.Department;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import institute.college.abvgietconnect.R;

public class EceDepartment extends AppCompatActivity {

    private RecyclerView  eceDepartment;
    private LinearLayout eceNodata;
    private List<TeacherModel>  list2;

    private DatabaseReference reference, dbRef;

    private TeacherAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ece_department);
        eceDepartment = findViewById(R.id.eceDepartmentrv);

        eceNodata = findViewById(R.id.eceNodata);

        reference = FirebaseDatabase.getInstance().getReference().child("Teacher");

        eceDepartment();

    }


    private void eceDepartment() {
        dbRef = reference.child("ECE");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                list2 = new ArrayList<>();
                if (!snapshot.exists()) {
                    eceNodata.setVisibility(View.VISIBLE);
                    eceDepartment.setVisibility(View.GONE);

                } else {

                    eceNodata.setVisibility(View.GONE);
                    eceDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                        TeacherModel model = snapshot1.getValue(TeacherModel.class);
                        list2.add(model);

                    }
                    eceDepartment.setHasFixedSize(true);
                    eceDepartment.setLayoutManager(new LinearLayoutManager(EceDepartment.this));
                    adapter = new TeacherAdapter(list2, EceDepartment.this);
                    eceDepartment.setAdapter(adapter);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(EceDepartment.this, "" + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}


