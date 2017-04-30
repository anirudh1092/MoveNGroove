package com.example.anirudh.moovengroove.ActivityDetection;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.GoogleApiClient;

/**
 * Created by anirudh on 4/25/2017.
 */

class ActivityRecognition implements Runnable, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener{
   GoogleApiActivity myClient;
    String currentActivity;
    String[] ActivityList={"Walking","Standing","Sitting","Running","Driving"};
    public ActivityRecognition() {
    }

    @Override
    public void run() {

    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
//public static final Api<Api.ApiOptions.NoOptions> API;
}
