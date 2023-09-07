package com.example.applicationbuilding;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.yandex.mapkit.Animation;
import com.yandex.mapkit.MapKitFactory;
import com.yandex.mapkit.geometry.Point;
import com.yandex.mapkit.map.CameraPosition;
import com.yandex.mapkit.map.MapObject;
import com.yandex.mapkit.map.MapObjectCollection;
import com.yandex.mapkit.map.MapObjectTapListener;
import com.yandex.mapkit.map.PlacemarkMapObject;
import com.yandex.mapkit.map.TextStyle;
import com.yandex.mapkit.mapview.MapView;
import com.yandex.runtime.image.ImageProvider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MapsActivity extends AppCompatActivity {

    FusedLocationProviderClient fusedLocationProviderClient;
    private MapView mapView;

    private String TAG = "check position";
    Location current_location = null;

    private MapObjectCollection mapObjects;

    private final float ZOOM = 10f;

    private List<MapObjectTapListener> mapObjectTapListeners = new ArrayList<>();

    private Point marker_point = new Point(54.728394, 55.970657);

    private FrameLayout frameLayout;
    private FragmentWindowMap fragmentWindowMap;
    private FragmentTransaction fragmentTransaction;

    private List<Point> marker_points = Arrays.asList(new Point(54.728394, 55.970657),
            new Point(54.724294, 55.970657),
            new Point(54.728394, 55.970157),
            new Point(54.738394, 55.970657));

    private List<String> marker_name = Arrays.asList("Point 1",
            "Point 2", "Point 3", "Point 4");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MapKitFactory.initialize(this);
        setContentView(R.layout.activity_maps);

        createFragment();

        mapView = findViewById(R.id.map_view);

        moveCamera(new Point(54.7431, 55.9678), ZOOM);
        mapObjects = mapView.getMap().getMapObjects();
        List<PlacemarkMapObject> placemarkMapObjects = new ArrayList<>();

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.marker);
        TextStyle textStyle = new TextStyle();
        textStyle.setColor(Color.RED);
        textStyle.setSize(10f);
        textStyle.setOffset(5f);
        textStyle.setPlacement(TextStyle.Placement.TOP);

        for (int i = 0; i < marker_points.size(); ++i) {
            int finalI = i;
            PlacemarkMapObject placemarkMapObject =
                    mapObjects.addPlacemark(marker_points.get(i));

            int finalI1 = i;

            mapObjectTapListeners.add(new MapObjectTapListener() {
                @Override
                public boolean onMapObjectTap(@NonNull MapObject mapObject, @NonNull Point point) {

                    changeFragment(marker_name.get(finalI1).toString());

                    return true;
                }
            });
            placemarkMapObject.addTapListener(mapObjectTapListeners.get(i));
            placemarkMapObject.setText(marker_name.get(i));
            placemarkMapObject.setIcon(ImageProvider.fromBitmap(bitmap));
            placemarkMapObject.setTextStyle(textStyle);


            placemarkMapObjects.add(placemarkMapObject);

        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        MapKitFactory.getInstance().onStart();
        mapView.onStart();
    }

    @Override
    protected void onStop() {
        mapView.onStop();
        MapKitFactory.getInstance().onStop();
        super.onStop();
    }

    private void moveCamera(Point point, float zoom) {
        Log.d(TAG, "camera move");
        mapView.getMap().move(new CameraPosition(point,
                        zoom, 0.0f, 0.0f),
                new Animation(Animation.Type.SMOOTH, 1), null);
    }

    private void createFragment(){

        fragmentWindowMap = new FragmentWindowMap();
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.window_up_frame, fragmentWindowMap);
        fragmentTransaction.commit();
    }

    private void changeFragment(String text){
        fragmentWindowMap.setText(text);
    }
}

///////////////////////////////////////////////////////////////////
