package institute.college.abvgietconnect;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

import institute.college.abvgietconnect.Administration.AdministrationActivity;
import institute.college.abvgietconnect.StudentZone.LoginActivity;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    SliderView sliderView;
    List<ImageSliderModel> slideModelList;

    private DrawerLayout drawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        drawerLayout = findViewById(R.id.drawer_user);
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

        NavigationView navigationView = findViewById(R.id.navigation_drawer);
        navigationView.setNavigationItemSelectedListener(this);


        sliderView = findViewById(R.id.imageSlider);
        slideModelList = new ArrayList<>();
        slideModelList.add(new ImageSliderModel(R.drawable.labs));
        slideModelList.add(new ImageSliderModel(R.drawable.photo));

        sliderView.setSliderAdapter(new ImageSliderAdapter(this,slideModelList));





        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);

        sliderView.setIndicatorSelectedColor(Color.WHITE);

        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.setScrollTimeInSec(3);
        sliderView.startAutoCycle();

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item)
    {
        int id = item.getItemId();
        if (id == R.id.gallery)
        {
            Intent intent = new Intent(MainActivity.this,GalleryActivity.class);
            startActivity(intent);


        }
        else if (id == R.id.administration)
        {
            Intent intent = new Intent(MainActivity.this, AdministrationActivity.class);
            startActivity(intent);


        }
        else if (id == R.id.site)
        {
            Url("http://www.abvgiet.org/");

        }
        else if (id == R.id.reach)
        {


            MapUrl("google.navigation:q=Atal Bihari Vajpayee Government Institute of Engineering and technology,Himachal Pradesh");
        }
        else if (id == R.id.stud_zone)
        {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);

        }


        return false;
    }


    private void Url(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));

    }

    private void MapUrl(String s1)
    {
        Uri uri1 = Uri.parse(s1);
        Intent intent = new Intent(Intent.ACTION_VIEW,uri1);
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);


    }






}