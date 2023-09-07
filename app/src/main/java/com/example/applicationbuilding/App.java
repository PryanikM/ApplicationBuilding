package com.example.applicationbuilding;

import android.app.Application;

import com.yandex.mapkit.MapKitFactory;

public class App extends Application {

    private final String MAPKIT_API_KEY = "32cd3296-1971-4c97-8b5f-45847d405e5c";

    @Override
    public void onCreate() {
        super.onCreate();

        MapKitFactory.setApiKey(MAPKIT_API_KEY);
    }
}
