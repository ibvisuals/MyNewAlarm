package com.ibvisuals.mynewalarm;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class StandUp extends BroadcastReceiver {
    public StandUp(){

    }

    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context,"Inside Receiver",Toast.LENGTH_SHORT).show();

        NotificationManagerCompat myManager = NotificationManagerCompat.from(context);

        NotificationCompat.Builder myNoti = new NotificationCompat.Builder(context);
        myNoti.setContentTitle("Stand Up Notification");
        myNoti.setContentText("You need to stand up");
        myNoti.setSmallIcon(android.R.drawable.ic_btn_speak_now);

        Intent i1 = new Intent(context,StandUpActivity.class);
        PendingIntent pd = PendingIntent.getActivity(context,0,i1,0);
        myNoti.setContentIntent(pd);

        myNoti.setAutoCancel(true);

        myManager.notify(1,myNoti.build());

    }
}