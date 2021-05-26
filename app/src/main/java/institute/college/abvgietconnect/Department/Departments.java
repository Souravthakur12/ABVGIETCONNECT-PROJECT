package institute.college.abvgietconnect.Department;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import institute.college.abvgietconnect.R;
import soup.neumorphism.NeumorphCardView;

public class Departments extends AppCompatActivity {

    NeumorphCardView csedepartment,ecedepartment;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_departments);


       /* getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,

                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        getWindow().setStatusBarColor(Color.TRANSPARENT);*/


        csedepartment = findViewById(R.id.csedepartment);
        ecedepartment = findViewById(R.id.ecedepartment);

        csedepartment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Departments.this,CseDepartment.class);
                startActivity(intent);
            }
        });
        ecedepartment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Departments.this,EceDepartment.class);
                startActivity(intent);
            }
        });




    }
}