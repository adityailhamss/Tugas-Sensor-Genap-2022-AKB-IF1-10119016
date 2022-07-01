/*  NAMA : Aditya Ilham Subagja
 *  NIM : 10119016
 *  KELAS : IF-1
 */
package com.example.a10119016_adityailhamsubagja;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.example.a10119016_adityailhamsubagja.databinding.ActivityMapsBinding;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.a10119016_adityailhamsubagja.databinding.ActivityMapsBinding;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

public class MapsFragment extends Fragment {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    private SupportMapFragment mapFragment;
    private FusedLocationProviderClient client;


    private OnMapReadyCallback callback = new OnMapReadyCallback() {

        @Override
        public void onMapReady(GoogleMap googleMap) {
            LatLng sydney = new LatLng(-34, 151);
            googleMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 15));

            LatLng lokasiSaatIni = new LatLng(-6.975405577140078, 107.63589306846534);
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
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_maps, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(callback);
    }
}