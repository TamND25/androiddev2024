package vn.edu.usth.weather.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import vn.edu.usth.weather.R;

public class ForecastFragment extends Fragment {

    public ForecastFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_forecast, container, false);
    /*
        // Create LinearLayout
        LinearLayout linearLayout = new LinearLayout(getActivity());
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        // TextView "Thursday"
        TextView date = new TextView(getActivity());
        date.setText(R.string.thursday);
        date.setTextSize(60);
        date.setGravity(View.TEXT_ALIGNMENT_GRAVITY);
        date.setTextColor(Color.parseColor("#FF0000"));

        // ImageView
        ImageView weatherIcon = new ImageView(getActivity());
        weatherIcon.setImageResource(R.drawable.weather_icon);

        // Add TextView and ImageView to LinearLayout
        linearLayout.addView(date);
        linearLayout.addView(weatherIcon);

        // Add LinearLayout to FrameLayout
        view.addView(linearLayout);
    */
        return view;
    }

}