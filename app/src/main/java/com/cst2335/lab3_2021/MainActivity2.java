package com.cst2335.lab3_2021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.jar.Attributes;

public class MainActivity2 extends AppCompatActivity {
 static final int REQUEST_IMAGE_CAPTURE =1;
    private ImageButton image;
public static final String ACTIVITY_NAME="PROFILE_ACTIVITY";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e(ACTIVITY_NAME,"onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_activity);
        TextView text1 =findViewById(R.id.text3);
        TextView text2 =findViewById(R.id.text);
        TextView text3 =findViewById(R.id.text2);
        TextView text4 =findViewById(R.id.text4);
        EditText edit1 = findViewById(R.id.edit1);
        EditText edit2 = findViewById(R.id.edit2);
        Intent Email = getIntent();
        edit2.setText(Email.getStringExtra("Email"));
         image =findViewById(R.id.image);
      image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dispatchTakePictureIntent();
            }
        });
    };

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
    };
    }

    @Override
    protected void onDestroy() {
        Log.e(ACTIVITY_NAME,"onDestroy");
        super.onDestroy();
    }

    @Override
    protected void onStop() {
        Log.e(ACTIVITY_NAME,"onStop");
        super.onStop();
    }

    @Override
    protected void onPause() {
        Log.e(ACTIVITY_NAME,"onPause");
        super.onPause();
    }

    @Override
    protected void onPostResume() {
        Log.e(ACTIVITY_NAME,"onResume");
        super.onPostResume();
    }

    @Override
    protected void onStart() {
        Log.e(ACTIVITY_NAME,"onStart");
        super.onStart();
    }

    @Override
       protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.e(ACTIVITY_NAME,"onActivityResult");
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
                Bundle extras = data.getExtras();
                Bitmap imageBitmap = (Bitmap) extras.get("data");
                image.setImageBitmap(imageBitmap);
            }
        }








}