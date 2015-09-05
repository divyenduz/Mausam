package in.zoid.mausam.activities;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.crashlytics.android.Crashlytics;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

import butterknife.Bind;
import butterknife.ButterKnife;
import in.zoid.mausam.BuildConfig;
import in.zoid.mausam.R;
import in.zoid.mausam.adapters.TabFragmentAdapter;
import in.zoid.mausam.interfaces.OpenWeatherMapService;
import in.zoid.mausam.pojo.WeatherDataComplex;
import io.fabric.sdk.android.Fabric;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class MainActivity extends BaseActivity implements
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        LocationListener {
    private static final String TAG = "MainActivity";

    private GoogleApiClient mGoogleApiClient;

    @Bind(R.id.pager)
    private ViewPager mPager;

    private OpenWeatherMapService mService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.v(TAG, "Mode: " + BuildConfig.BUILD_TYPE);
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint(API_ENDPOINT)
                .build();

        mService = restAdapter.create(OpenWeatherMapService.class);

        buildGoogleApiClient();
    }

    /**
     * Lifecycle method. GoogleApiClient is connected in this part.
     */
    @Override
    protected void onStart() {
        super.onStart();
        // Connect the client.
        mGoogleApiClient.connect();
    }

    /**
     * Lifecycle method. GoogleApiClient is disconnected in this part.
     */
    @Override
    protected void onStop() {
        // Disconnecting the client invalidates it.
        mGoogleApiClient.disconnect();
        super.onStop();
    }

    /**
     * Method is called onCreate() in lifecycle. It builds a GoogleApiClient and tells it to use
     * LocationServices.API
     */
    protected synchronized void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
    }

    private void getAPIData(String lat, String lon) {
        mService.getWeatherDataByCityName(lat, lon, new Callback<WeatherDataComplex>() {
            @Override
            public void success(WeatherDataComplex data, Response response) {
                setTitle("Mausam @" + " " + data.getCity().getName() + " (" + data.getCity().getCountry() + ")");
                mPager.setAdapter(new TabFragmentAdapter(getSupportFragmentManager(), data));
            }

            @Override
            public void failure(RetrofitError error) {
                Log.e(TAG, "RetrofitError: " + error.toString());
            }
        });
    }

    /**
     * GoogleApiClient onConnected() callback. Called when GoogleApiClient is able to connect to
     * respective API
     *
     * @param bundle N/A
     */
    @Override
    public void onConnected(Bundle bundle) {
        LocationRequest mLocationRequest = LocationRequest.create();
        mLocationRequest.setPriority(LocationRequest.PRIORITY_LOW_POWER);
        mLocationRequest.setInterval(60000 * 60); // Update location every hour

        Location mLastLocation = LocationServices.FusedLocationApi.getLastLocation(
                mGoogleApiClient);

        getAPIData(
                String.valueOf(mLastLocation.getLatitude()),
                String.valueOf(mLastLocation.getLongitude()));
    }

    @Override
    public void onConnectionSuspended(int i) {
        Log.i(TAG, "onConnectionSuspended: " + i);
    }

    @Override
    public void onLocationChanged(Location location) {
        Log.v(TAG, "onLocationChanged: " + location.toString());
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        Log.i(TAG, "onStatusChanged: " + provider + " " + status + " " + extras.toString());
    }

    @Override
    public void onProviderEnabled(String provider) {
        Log.i(TAG, "onProviderEnabled: " + provider);
    }

    @Override
    public void onProviderDisabled(String provider) {
        Log.e(TAG, "onProviderDisabled: " + provider);
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        Log.e(TAG, "onConnectionFailed: " + connectionResult.toString());
    }
}