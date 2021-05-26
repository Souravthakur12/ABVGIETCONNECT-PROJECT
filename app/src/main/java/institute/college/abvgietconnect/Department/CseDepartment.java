package institute.college.abvgietconnect.Department;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
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

public class CseDepartment extends AppCompatActivity {

    private RecyclerView csDepartment, eceDepartment;
    private LinearLayout csNodata, eceNodata;
    private List<TeacherModel> list1, list2;

    private DatabaseReference reference, dbRef;

    private TeacherAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cse_department);
        csDepartment = findViewById(R.id.csDepartmentrv);
        eceDepartment = findViewById(R.id.eceDepartmentrv);

        csNodata = findViewById(R.id.csNodata);
        eceNodata = findViewById(R.id.eceNodata);

        reference = FirebaseDatabase.getInstance().getReference().child("Teacher");

        csDepartment();

    }

    private void csDepartment() {
        dbRef = reference.child("CSE");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                list1 = new ArrayList<>();
                if (!snapshot.exists()) {
                    csNodata.setVisibility(View.VISIBLE);
                    csDepartment.setVisibility(View.GONE);

                } else {

                    csNodata.setVisibility(View.GONE);
                    csDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                        TeacherModel model = snapshot1.getValue(TeacherModel.class);
                        list1.add(model);

                    }
                    csDepartment.setHasFixedSize(true);
                    csDepartment.setLayoutManager(new LinearLayoutManager(CseDepartment.this));
                    adapter = new TeacherAdapter(list1, CseDepartment.this);
                    csDepartment.setAdapter(adapter);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(CseDepartment.this, "" + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


}


