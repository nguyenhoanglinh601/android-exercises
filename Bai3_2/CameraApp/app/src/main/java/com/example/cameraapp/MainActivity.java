package com.example.cameraapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.content.FileProvider;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;


public class MainActivity extends AppCompatActivity {

    Button bt_notifi;
    ImageButton bt_camera;
    int REQUEST_IMAGE_CAPTURE=1;
    ImageView imageView;
    String pathtoFile;
    public final int CODE_REQUEST=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_camera=(ImageButton) findViewById(R.id.camera);
        imageView=(ImageView) findViewById(R.id.results);
        bt_notifi=(Button) findViewById(R.id.bt);

        //tạo quyền cho phép
        if(Build.VERSION.SDK_INT>=23){
            requestPermissions(new String[] { Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE},2);
        }

        bt_notifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    sendNotification();
                /*AlarmManager alarmManager=(AlarmManager) getSystemService(ALARM_SERVICE);
                long l= System.currentTimeMillis();
                long l1= 100*10;
                Intent intent= new Intent(MainActivity.this, MainActivity.class);
                PendingIntent pendingIntent= PendingIntent.getBroadcast(MainActivity.this,0,intent,0);
                alarmManager.set(AlarmManager.RTC_WAKEUP,l1+l,pendingIntent);*/
            }
        });

        bt_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dispatchPictureTakerAction();
            }
        });
    }



    private void dispatchPictureTakerAction() {
        Intent takepiture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(takepiture.resolveActivity(getPackageManager())!=null){
            File photofile=null;
            photofile=createphotoFile();
            if(photofile!=null){
                String pathtoFile=photofile.getAbsolutePath();
                Uri photoUri=FileProvider.getUriForFile(MainActivity.this,"com.thecodecity.cameraandroid.fileprovider",photofile);
                takepiture.putExtra(MediaStore.EXTRA_OUTPUT,photoUri);
                startActivityForResult(takepiture,CODE_REQUEST);
            }
        }
    }

    private File createphotoFile() {
        String name=new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File strorageDir= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        File image=null;
        try {
            image= File.createTempFile(name,".jpg",strorageDir);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==RESULT_OK && requestCode==CODE_REQUEST){
            Bitmap bitmap= (Bitmap) data.getExtras().get("data");
            //Bitmap bitmap= BitmapFactory.decodeFile(pathtoFile);
            imageView.setImageBitmap(bitmap);
        }
    }
    private void sendNotification() {
        android.app.Notification notification= new NotificationCompat.Builder(this, com.example.cameraapp.Notification.CHANNEL_ID).setContentTitle("Camera").setContentText("Time to take a photo").build();
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        if(notificationManager!=null){
            notificationManager.notify(123,notification);
        }
    }

    private int getNotificationId() {
        return (int) new Date().getTime();
    }



}