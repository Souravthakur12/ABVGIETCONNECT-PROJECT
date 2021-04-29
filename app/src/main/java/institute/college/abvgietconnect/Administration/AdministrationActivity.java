package institute.college.abvgietconnect.Administration;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import institute.college.abvgietconnect.R;

public class AdministrationActivity extends AppCompatActivity {

    CardView c1,c2,c3,c4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administration);

        c1 = findViewById(R.id.director_desk);
        c2 = findViewById(R.id.principal);
        c3 = findViewById(R.id.staff);
        c4 = findViewById(R.id.bog);


        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdministrationActivity.this,Staff.class);
                startActivity(intent);
            }
        });

    }
}