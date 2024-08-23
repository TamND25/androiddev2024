package vn.edu.usth.weather;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

public class WeatherActivity extends AppCompatActivity {
    public static final String TAG = "Weathering";
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

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragmentContainerView2,ForecastFragment.class,null)
                .commit();
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

