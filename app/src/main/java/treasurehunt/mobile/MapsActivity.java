package treasurehunt.mobile;

import android.location.Address;
import android.location.Geocoder;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import cn.pedant.SweetAlert.SweetAlertDialog;
import treasurehunt.mobile.database.Point;

public class MapsActivity extends FragmentActivity implements
        OnMapReadyCallback, GoogleMap.OnMapClickListener, GoogleMap.OnMapLongClickListener {

    public static List<Point> mPoints ;
    private Map<LatLng, Marker> coordinateMarketMap;

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        mPoints = new ArrayList<>();
        coordinateMarketMap = new HashMap<>();
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */

    @Override
    public void onMapReady(GoogleMap map) {
        LatLng paris = new LatLng(48.8534100, 2.3488000);
        map.setMyLocationEnabled(true);
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(paris, 13));

        map.setOnMapClickListener(this);
        map.setOnMapLongClickListener(this);
        map.getUiSettings().setZoomControlsEnabled(true);
        map.getUiSettings().setZoomGesturesEnabled(true);

        mMap = map;

    }

    @Override
    public void onMapClick(LatLng latLng) {
        if (coordinateMarketMap.keySet().contains(latLng)) {
            Marker marker = coordinateMarketMap.get(latLng);
            marker.remove();
            mPoints.remove(new Point("",latLng.latitude,latLng.longitude)); // ugly
        }
        else {
                showDialog(latLng);
        }
    }

    @Override
    public void onMapLongClick(LatLng latLng) {
        CameraUpdateFactory.zoomIn();
    }

    private String geoDecodeLatLong(LatLng point) {
        Geocoder gcd = new Geocoder(this, Locale.getDefault());
        List<Address> addresses = new ArrayList<>();
        try {
            addresses = gcd.getFromLocation(point.latitude, point.longitude, 1);

        } catch (IOException e) {
        } finally {
            if (addresses.size() > 0) {
                Address address = addresses.get(0);
                return address.getAddressLine(0) + "\n" + address.getAddressLine(1);
            }
            else {
                return "";
            }
        }
    }

    private void showDialog(final LatLng latLng) {
        final String address = geoDecodeLatLong(latLng);
        new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                .setTitleText("Add coordinate")
                .setContentText("Add \n" + address + " \nto the list ?")
                .setConfirmText("Yes!")
                .showCancelButton(true)
                .setCancelText("No.")
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        //
                        sDialog.cancel();
                        mPoints.add(new Point(address, latLng.latitude, latLng.longitude));
                        mMap.setMyLocationEnabled(true);
                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 13));
                        Marker newMarker = mMap.addMarker(new MarkerOptions().title(address)
                                .position(latLng));
                        coordinateMarketMap.put(latLng, newMarker);
                        Toast.makeText(MapsActivity.this, address + " successefully added.", Toast.LENGTH_LONG);
                    }
                })
                .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        sDialog.cancel();
                        Toast.makeText(MapsActivity.this, "Not added", Toast.LENGTH_LONG);
                    }
                })
                .show();
    }
}