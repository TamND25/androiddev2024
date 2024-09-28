package vn.edu.usth.weather.activity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;

import android.content.Intent;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager.widget.ViewPager;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import vn.edu.usth.weather.adapter.HomeFragmentPagerAdapter;
import vn.edu.usth.weather.R;

public class WeatherActivity extends AppCompatActivity {
    public static final String TAG = "Weathering";
    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_weather);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Log.i(TAG, "onCreate");

        ViewPager pager = findViewById(R.id.pager);
        HomeFragmentPagerAdapter adapter = new HomeFragmentPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);
        TabLayout tablayout = findViewById(R.id.tab_layout);
        tablayout.setupWithViewPager(pager);

        mp = MediaPlayer.create(this, R.raw.dundundun);
        mp.setLooping(true);
        mp.start();

        initToolBar();
    }

    private void initToolBar() {
        Toolbar toolbar = findViewById(R.id.weather_toolbar);
        toolbar.inflateMenu(R.menu.menu_tool_bar);
        toolbar.setTitle(R.string.app_name);
        toolbar.setOnMenuItemClickListener(item -> {
            int itemMenuId = item.getItemId();
            if (itemMenuId == R.id.ic_refresh) {
                Toast.makeText(this, "Refreshing process...", Toast.LENGTH_SHORT).show();
                return true;
            } else if (itemMenuId == R.id.ic_more) {
                Intent intent = new Intent(this, PrefActivity.class);
                startActivity(intent);
                return true;
            } else {
                Toast.makeText(this, "Not found menu item", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    @Override
    protected void onStart()    {
        super.onStart();
        Log.i(TAG, "onStart");
    }

    @Override
    protected void onResume()    {
        super.onResume();
        Log.i(TAG, "onResume");
    }

    @Override
    protected void onPause()    {
        super.onPause();
        Log.i(TAG, "onPause");
    }

    @Override
    protected void onStop()    {
        super.onStop();
        Log.i(TAG, "onStop");
    }

    @Override
    protected void onDestroy()    {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
    }
}

