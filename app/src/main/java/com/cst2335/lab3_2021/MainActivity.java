package com.cst2335.lab3_2021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sp;
    EditText editText1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp = getSharedPreferences("EmailFile", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        editText1 = findViewById(R.id.edit1);
        editText1.setText(sp.getString("Email",""));
        EditText editText2 = findViewById(R.id.edit2);
        TextView text =  findViewById(R.id.text);
        TextView text2 =  findViewById(R.id.text2);
        Button loginbutton = findViewById(R.id.button1);

        loginbutton.setOnClickListener((v)-> onPause());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onPause() {

        super.onPause();
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("Email",editText1.getText().toString());
       editor.commit();
       Intent intent =  new Intent(MainActivity.this, MainActivity2.class);
       intent.putExtra("Email",editText1.getText().toString());
       startActivity(intent);

    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}