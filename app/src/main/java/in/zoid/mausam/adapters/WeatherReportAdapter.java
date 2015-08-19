package in.zoid.mausam.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import in.zoid.mausam.R;
import in.zoid.mausam.pojo.WeatherDataComplex;

/**
 * Created by divyendusingh on 8/17/15.
 */
public class WeatherReportAdapter extends RecyclerView.Adapter<WeatherReportAdapter.ViewHolder> {
    WeatherDataComplex.WeatherData mData;

    public WeatherReportAdapter(WeatherDataComplex.WeatherData data) {
        mData = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.widget_weather_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        WeatherDataComplex.WeatherReport report = mData.getList().get(position);
        holder.cityTextView.setText(mData.getCity().getName());

        long created = report.getDt();
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM", Locale.US);
        String dateString = formatter.format(new Date(created * 1000L));

        holder.dayTextView.setText(String.valueOf(dateString));
        String max = String.valueOf(report.getTemp().getMax());
        String min = String.valueOf(report.getTemp().getMin());
        holder.maxTempTextView.setText(String.valueOf((max.length() == 4 ? max + "0" : max) + " \u2103"));
        holder.minTempTextView.setText(String.valueOf((min.length() == 4 ? min + "0" : min) + " \u2103"));
    }

    @Override
    public int getItemCount() {
        return mData.getList().size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView cityTextView;
        public TextView dayTextView;
        public TextView maxTempTextView;
        public TextView minTempTextView;

        public ViewHolder(View view) {
            super(view);
            cityTextView = (TextView) view.findViewById(R.id.cityTextView);
            dayTextView = (TextView) view.findViewById(R.id.dayTextView);
            maxTempTextView = (TextView) view.findViewById(R.id.maxTempTextView);
            minTempTextView = (TextView) view.findViewById(R.id.minTempTextView);
        }
    }

}
