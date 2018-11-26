package com.example.festu.project;

import android.app.Service;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import android.content.Intent;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        //Method To Generate Notification.
        FirebaseCloudMessageFunction(remoteMessage.getData().get("title"), remoteMessage.getData().get("body"));
    }

    // Function to Generate Push Notification After Receiving Response from Server.
    private void FirebaseCloudMessageFunction(String messageTitle, String messageBody) {

        // Creating Intent.
        Intent intent = new Intent(this, MainActivity.class);

        // Device vibrate pattern.
        long[] pattern = {500,500,500,500,500};

        // Adding FLAG_ACTIVITY_CLEAR_TOP to intent.
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        // Creating Pending Intent object.
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0 , intent,PendingIntent.FLAG_UPDATE_CURRENT);


        // Creating URI to access the default Notification Ringtone.
        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        // Converting drawable icon to bitmap for default notification ICON.
        Bitmap DefaultIconBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);

        // Building Notfication.
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)

                // Adding Default Icon to Notification bar.
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))

                // Setting up Title.
                .setContentTitle(messageTitle)

                // Setting the default msg coming from server into Notification.
                .setContentText(messageBody)

                .setAutoCancel(true)

                .setVibrate(pattern)

                .setSound(defaultSoundUri)

                .setContentIntent(pendingIntent);

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        notificationManager.notify(0, builder.build());
    }
}
