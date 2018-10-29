package com.itskshitizsh.bhukhad;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ListenOrderNotification extends Service implements ChildEventListener {

    FirebaseDatabase db;
    DatabaseReference requests;

    public ListenOrderNotification() {
    }

    public static String convertCodeToStatus(String s) {
        if (s != null) {
            switch (s) {
                case "0":
                    return "Placed";
                case "1":
                    return "Ready";
                case "2":
                    return "Delivered";
                default:
                    return "Something else";
            }
        } else {
            return "------";
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        db = FirebaseDatabase.getInstance();
        requests = db.getReference("Requests");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("Bhukkad", "Bukkad", NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription("Bhukkad Desc");
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        requests.addChildEventListener(this);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

    }

    @Override
    public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
        OrderAtVendor request = dataSnapshot.getValue(OrderAtVendor.class);
        if (request != null) {
            showNotification(dataSnapshot.getKey(), request);
        }
    }

    private void showNotification(String key, OrderAtVendor request) {
        Intent intent = new Intent(getBaseContext(), OrderActivity.class);
        intent.putExtra("orderId", request.getOrderId());
        PendingIntent contentIntent = PendingIntent.getActivity(getBaseContext(), 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(getBaseContext(), "Bhukkad");
        builder.setAutoCancel(true).setDefaults(Notification.DEFAULT_ALL)
                .setWhen(System.currentTimeMillis())
                .setTicker(getString(R.string.app_name))
                .setContentInfo("Your order status was updated.")
                .setContentText("Order No." + key + "was updated status to \n" + convertCodeToStatus(request.getOrderStatus()))
                .setContentIntent(contentIntent)
                .setContentInfo("Info").setSmallIcon(R.drawable.ic_message_black_24dp);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0, builder.build());

    }

    @Override
    public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

    }

    @Override
    public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }
}
