/*  NAMA : Aditya Ilham Subagja
 *  NIM : 10119016
 *  KELAS : IF-1
 */
package com.example.a10119016_adityailhamsubagja;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import com.example.a10119016_adityailhamsubagja.databinding.ActivityMapsBinding;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

public class MapsActivity extends FragmentActivity{

    private ActivityMapsBinding binding;
    private SupportMapFragment mapFragment;
    private FusedLocationProviderClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        client = LocationServices.getFusedLocationProviderClient(this);

        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        getCurrentLocation();
    }

    private void getCurrentLocation() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MapsActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 44);
        }

        Task<Location> task = client.getLastLocation();
        task.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if (location != null ) {
                    mapFragment.getMapAsync(new OnMapReadyCallback() {
                        @Override
                        public void onMapReady(@NonNull GoogleMap googleMap) {
                            LatLng lokasiSaatIni = new LatLng(location.getLatitude(), location.getLongitude());
                            LatLng lokasi1 = new LatLng(-6.974609400318701, 107.63580415324964);
                            LatLng lokasi2 = new LatLng(-6.974899929542455,107.63551145802303);
                            LatLng lokasi3 = new LatLng(-6.976837382514292,107.63515522826438);
                            LatLng lokasi4 = new LatLng(-6.972159372128866,107.63646929590732);
                            LatLng lokasi5 = new LatLng(-6.96690107210134,107.6383191968225);

                            googleMap.addMarker(new MarkerOptions().position(lokasiSaatIni).title("Lokasi Saat Ini"));
                            googleMap.addMarker(new MarkerOptions().position(lokasi1).title("Mcdonald's"));
                            googleMap.addMarker(new MarkerOptions().position(lokasi2).title("Kandang Ayam"));
                            googleMap.addMarker(new MarkerOptions().position(lokasi3).title("Es Teh Indonesia "));
                            googleMap.addMarker(new MarkerOptions().position(lokasi4).title("Bebek Om Aris"));
                            googleMap.addMarker(new MarkerOptions().position(lokasi5).title("Richeese Factory"));

                            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(lokasiSaatIni, 15));
                        }
                    });
                }
            }
        });
    }
}