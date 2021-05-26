package institute.college.abvgietconnect;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.google.android.material.navigation.NavigationView;
import com.smarteist.autoimageslider.SliderView;

import java.util.List;

import institute.college.abvgietconnect.Administration.AdministrationActivity;
import institute.college.abvgietconnect.Department.Departments;
import institute.college.abvgietconnect.Fragments.GalleryFragment;
import institute.college.abvgietconnect.Fragments.HomeFragment;
import institute.college.abvgietconnect.Fragments.NoticeFragment;
import institute.college.abvgietconnect.Models.ImageSliderModel;
import institute.college.abvgietconnect.StudentZone.LoginActivity;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    private DrawerLayout drawerLayout;

    private final int ID_HOME = 1;
    private final int ID_NOTICE = 2;
    private final int ID_NOTIFICATION = 3;
    private final int ID_GALLERY = 4;
    private FrameLayout frameLayout;
    private FragmentManager fragmentManager;
    Fragment fragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        Toolbar toolbar = findViewById(R.id.toolbar);
        frameLayout = findViewById(R.id.frame_layout);
        fragmentManager = getSupportFragmentManager();

        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new HomeFragment()).commit();


        MeowBottomNavigation bottomNavigation = findViewById(R.id.bottomNavigation);
        bottomNavigation.add(new MeowBottomNavigation.Model(ID_HOME, R.drawable.ic_baseline_home_24));
        bottomNavigation.add(new MeowBottomNavigation.Model(ID_NOTICE, R.drawable.ic_baseline_assignment_24));
        /* bottomNavigation.add(new MeowBottomNavigation.Model(ID_NOTIFICATION, R.drawable.ic_baseline_notifications_24));*/
        bottomNavigation.add(new MeowBottomNavigation.Model(ID_GALLERY, R.drawable.ic_baseline_image_24));
        bottomNavigation.setOnClickMenuListener(item -> {
        });


        bottomNavigation.setOnShowListener(item -> {
            switch (item.getId()) {
                case ID_HOME: {
                    fragment = new HomeFragment();
                    Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show();
                    break;

                }
                case ID_NOTICE: {
                    fragment = new NoticeFragment();
                    Toast.makeText(this, "Notice", Toast.LENGTH_SHORT).show();
                    break;

                }
               /* case ID_NOTIFICATION: {
                    name = "Notification";

                }*/
                case ID_GALLERY: {

                    fragment = new GalleryFragment();
                    Toast.makeText(this, "Gallery", Toast.LENGTH_SHORT).show();
                    break;
                }
                default: {
                }
            }

            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.frame_layout, fragment).commit();

        });

        bottomNavigation.setOnReselectListener(new MeowBottomNavigation.ReselectListener() {
            @Override
            public void onReselectItem(MeowBottomNavigation.Model item) {

            }
        });


        drawerLayout = findViewById(R.id.drawer_user);
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

        NavigationView navigationView = findViewById(R.id.navigation_drawer);
        navigationView.setNavigationItemSelectedListener(this);


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.gallery) {
            Intent intent = new Intent(MainActivity.this, GalleryActivity.class);
            startActivity(intent);


        } else if (id == R.id.administration) {
            Intent intent = new Intent(MainActivity.this, AdministrationActivity.class);
            startActivity(intent);


        } else if (id == R.id.departments) {
            Intent intent = new Intent(MainActivity.this, Departments.class);
            startActivity(intent);

        } else if (id == R.id.site) {
            Url("http://www.abvgiet.org/");

        } else if (id == R.id.reach) {


            MapUrl("google.navigation:q=Atal Bihari Vajpayee Government Institute of Engineering and technology,Himachal Pradesh");
        } else if (id == R.id.stud_zone) {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);

        }
        else if (id ==R.id.share){
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            String sharbody ="Link of the Application will be here!!";
            intent.putExtra(Intent.EXTRA_TEXT,sharbody);
            startActivity(Intent.createChooser(intent,"Share Using"));

        }


        return false;
    }


    private void Url(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));

    }

    private void MapUrl(String s1) {
        Uri uri1 = Uri.parse(s1);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri1);
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);


    }


}