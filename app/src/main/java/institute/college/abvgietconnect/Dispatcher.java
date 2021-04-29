package institute.college.abvgietconnect;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import institute.college.abvgietconnect.StudentZone.HomePage;

public class Dispatcher extends HomePage {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Class<?> activityClass;

        try {
            SharedPreferences prefs = getSharedPreferences("X", MODE_PRIVATE);
            activityClass = Class.forName(
                    prefs.getString("lastActivity",HomePage.class.getName()));
        } catch(ClassNotFoundException ex) {
            activityClass = HomePage.class;
        }

        startActivity(new Intent(this, activityClass));
    }



}
