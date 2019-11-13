package com.example.therealgeofence;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingClient;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

import java.util.ArrayList;
import java.util.List;

public class FenceActivity extends AppCompatActivity {
    private GeofencingClient geofencingClient;
    List<Geofence> geofences = new ArrayList<>();
    PendingIntent geofencePendingIntent;
    public static final String TAG = FenceActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        geofencingClient = LocationServices.getGeofencingClient(this);
        geofences.add(new Geofence.Builder()
                .setRequestId("geofenceID")
                .setCircularRegion(12.9684076, 77.5320905, 100)
                .setExpirationDuration(Geofence.NEVER_EXPIRE)
                .setTransitionTypes((Geofence.GEOFENCE_TRANSITION_ENTER) | (Geofence.GEOFENCE_TRANSITION_EXIT))
                .build());
        geofencingClient.addGeofences(getGeofencingClient(), getGeofencePendingIntent())
        .addOnSuccessListener(this, new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Log.e(TAG, "Geofence successfully added");
            }
        })
        .addOnFailureListener(this, new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.e(TAG, "Failed with exception: " +e.getMessage());
            }
        });
    }

    //TODO: or use dwell..
    private GeofencingRequest getGeofencingClient() {
        GeofencingRequest.Builder builder = new GeofencingRequest.Builder()
                .setInitialTrigger(GeofencingRequest.INITIAL_TRIGGER_ENTER)
                .addGeofences(geofences);
        return builder.build();
    }

    private PendingIntent getGeofencePendingIntent(){
        if(geofencePendingIntent!=null){
            return geofencePendingIntent;
        }
        Intent intent = new Intent(this, GeofenceReceiver.class);
        geofencePendingIntent = PendingIntent.getBroadcast(this, 20, intent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        return geofencePendingIntent;
    }

}
