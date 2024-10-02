package vn.edu.usth.weather.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Looper;
import android.os.Handler;
import android.os.Message;
import android.os.AsyncTask;
import android.util.Log;

import android.content.Intent;
import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager.widget.ViewPager;

import android.widget.ExpandableListAdapter;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import vn.edu.usth.weather.adapter.HomeFragmentPagerAdapter;
import vn.edu.usth.weather.R;

public class WeatherActivity extends AppCompatActivity {
    public static final String TAG = "Weathering";
    public static final String RESPONSE_KEY = "RESPONSE_KEY";
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
        /*requestNetwork();*/
        requestAsyncTask();
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

    /*private void requestNetwork() {
        final Handler handler = new Handler(Looper.getMainLooper()) {
            @Override
            public void handleMessage(@NonNull Message msg) {
                String content = msg.getData().getString(RESPONSE_KEY);
                Toast.makeText(getApplicationContext(), content, Toast.LENGTH_SHORT).show();
            }
        };
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Bundle mBundle = new Bundle();
                mBundle.putString(RESPONSE_KEY, "Request Network thread");
                Message msg = new Message();
                msg.setData(mBundle);
                handler.sendMessage(msg);
            }
        });
        thread.start();
    }*/


    private void requestAsyncTask() {
        AsyncTask<String, Integer, Bitmap> aTask = new AsyncTask<String, Integer, Bitmap>() {
            @Override
            protected Bitmap doInBackground(String... strings) {
                try {
                    Thread.sleep(1000);
                    URL url = new URL("https://usth.edu.vn/wp-content/uploads/2022/08/logo-165.jpg");

                    HttpURLConnection connection =
                            (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setDoInput(true);
                    connection.connect();

                    int response = connection.getResponseCode();
                    Log.i("USTHWeather", "The response is: " + response);
                    InputStream is = connection.getInputStream();

                    Bitmap bitmap = BitmapFactory.decodeStream(is);

                    connection.disconnect();

                    return bitmap;

                }   catch (InterruptedException | IOException e) {
                    e.printStackTrace();
                    return null;
                }
            }

            protected void onPostExecute(Bitmap bitmap)  {
                Toast.makeText(getApplicationContext(),
                        "ASync USTH Logo downloaded ", Toast.LENGTH_SHORT).show();

                ImageView logo = findViewById(R.id.logo);
                logo.setImageBitmap(bitmap);
            }
        };
        aTask.execute();
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

