package com.example.test.appancona;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MappaActivity extends FragmentActivity implements OnMapReadyCallback  {
    private GoogleMap mMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mappa);
        String t =getIntent().getStringExtra("nome");

        setTitle(t);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        String ind =getIntent().getStringExtra("indirizzo");

        LatLng luogo = getSingleLocationFromAddress(ind+" ancona",this);
        mMap.addMarker(new MarkerOptions().position(luogo).title(getIntent().getStringExtra("nome")));
        CameraPosition cameraPosition = new CameraPosition.Builder().target(luogo).zoom(15).build();

        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
    }
    public LatLng getSingleLocationFromAddress(String strAddress, Context c)
    {
        Geocoder coder = new Geocoder(c, Locale.getDefault());
        List<Address> address = null;
        Address location = null;
        LatLng temp = null;
        String strAddresNew = strAddress.replace(",", " ");
        try
        {
            address = coder.getFromLocationName(strAddresNew, 1);
            if (!address.isEmpty())
            {
                location = address.get(0);
                location.getLatitude();
                location.getLongitude();
                temp = new LatLng(location.getLatitude(), location.getLongitude());
                Log.d("Latlng : ", temp + "");
            }
        } catch (IOException e)
        {
            Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
            e.printStackTrace();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return temp;
    }

    public Integer CalcoloDistanza(LatLng start,LatLng end,Context c)
    {

        Location locstart= new Location("undici");
        Location locend= new Location("dodici");
        locstart.setLatitude(start.latitude);
        locstart.setLongitude(start.longitude);
        locend.setLatitude(end.latitude);
        locend.setLongitude(end.longitude);
        Float distanza = locend.distanceTo(locstart);
        return distanza.intValue();
    }

}

