package com.yoesuv.demomapstyle;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;

/**
 * Created by yusuf on 1/31/17.
 */

public class MapsFragment extends SupportMapFragment implements OnMapReadyCallback {

    private Context context;
    private GoogleMap gMap;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.context = view.getContext();
        setHasOptionsMenu(true);
        getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.gMap = googleMap;

        googleMap.getUiSettings().setZoomControlsEnabled(true);
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(-7.982914, 112.630875)));
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(9));

        loadMap(googleMap, 0);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.map_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.map_normal){
            loadMap(gMap, 0);
        }else if(id==R.id.map_silver) {
            loadMap(gMap, 1);
        }else if(id==R.id.map_retro) {
            loadMap(gMap, 2);
        }else if(id==R.id.map_dark) {
            loadMap(gMap, 3);
        }else if(id==R.id.map_night) {
            loadMap(gMap, 4);
        }else if(id==R.id.map_aubergine) {
            loadMap(gMap, 5);
        }else if(id==R.id.map_pastel){
            loadMap(gMap, 6);
        }else{
            loadMap(gMap, 0);
        }
        item.setChecked(true);
        return super.onOptionsItemSelected(item);
    }

    /**
     * load map style here
     * @param googleMap
     * @param style
     */
    private void loadMap(GoogleMap googleMap, int style){
        if(style==0){
            googleMap.setMapStyle(MapStyleOptions.loadRawResourceStyle(context, R.raw.style_map_normal));
        }else if(style==1) {
            googleMap.setMapStyle(MapStyleOptions.loadRawResourceStyle(context, R.raw.style_map_silver));
        }else if(style==2) {
            googleMap.setMapStyle(MapStyleOptions.loadRawResourceStyle(context, R.raw.style_map_retro));
        }else if(style==3) {
            googleMap.setMapStyle(MapStyleOptions.loadRawResourceStyle(context, R.raw.style_map_dark));
        }else if(style==4) {
            googleMap.setMapStyle(MapStyleOptions.loadRawResourceStyle(context, R.raw.style_map_night));
        }else if(style==5) {
            googleMap.setMapStyle(MapStyleOptions.loadRawResourceStyle(context, R.raw.style_map_aubergine));
        }else if(style==6){
            googleMap.setMapStyle(MapStyleOptions.loadRawResourceStyle(context, R.raw.style_map_pastel));
        }else{
            googleMap.setMapStyle(MapStyleOptions.loadRawResourceStyle(context, R.raw.style_map_normal));
        }

    }
}
