package com.example.festu.project;

import android.app.Service;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

import android.util.Log;

public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {

    private static final String Firebase_Tag = "FirebaseIDService";

    @Override
    public void onTokenRefresh() {

        //Getting token.
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();

        //Show token on logcat
        Log.d(Firebase_Tag, "Refreshed token: " + refreshedToken);

    }

    private void sendRegistrationToServer(String token) {
        // Write down your code here to do anything with toke like sending on server or save locally.
    }
}