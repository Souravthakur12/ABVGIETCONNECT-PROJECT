package institute.college.abvgietconnect.StudentZone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import institute.college.abvgietconnect.MainActivity;
import institute.college.abvgietconnect.R;

public class HomePage extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout1;

    FirebaseAuth mAuth;
    FirebaseUser currentUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();

        NavigationView navigationView = findViewById(R.id.sz_navigation_drawer);
        navigationView.setNavigationItemSelectedListener(this);
        updateNavHeader();

        drawerLayout1 = findViewById(R.id.sz_drawer_user);
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawerLayout1, toolbar, R.string.open, R.string.close);
        drawerLayout1.addDrawerListener(drawerToggle);
        drawerToggle.syncState();






      /*  mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();*/


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

         if (id ==R.id.log_out){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Sacchi me?")
                    .setCancelable(false)
                    .setMessage("Tussi Jaa Re Ho!!")
                    .setPositiveButton("Hanji", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            FirebaseAuth.getInstance().signOut();
                            Intent intToMain = new Intent(HomePage.this, MainActivity.class);
                            startActivity(intToMain);
                            finish();
                        }
                    })
                    .setNegativeButton("Nahi", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            dialog.cancel();
                        }
                    });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();

            /**/

        }



        return false;
    }


    public void updateNavHeader() {

        NavigationView navigationView = (NavigationView) findViewById(R.id.sz_navigation_drawer);
        View headerView = navigationView.getHeaderView(0);
        TextView navUsername = (TextView) headerView.findViewById(R.id.sz_name_of_user);
        TextView navUserMail = (TextView) headerView.findViewById(R.id.sz_email_of_user);
        ImageView navUserPhoto =(ImageView) headerView.findViewById(R.id.sz_userphoto);

        navUserMail.setText(currentUser.getEmail());
        navUsername.setText(currentUser.getDisplayName());

        // now we will use Glide to load user image
        // first we need to import the library


        if (currentUser.getPhotoUrl() !=null){
            Glide.with(this).load(currentUser.getPhotoUrl()).into(navUserPhoto);
        }
        else
        {
            Glide.with(this).load(R.drawable.userphoto).into(navUserPhoto);
        }






    }

    /*FinishAffinity removes the connection of the existing activity to its stack.
   And then finish helps you exit that activity. Which will eventually exit the application.*/
    @Override
    public void onBackPressed() {
        finishAffinity();
        finish();
    }


}