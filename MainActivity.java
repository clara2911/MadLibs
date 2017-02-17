package com.example.clara.madlibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> words;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void goToSecondActivity(View view) {
        ArrayList<String> words = new ArrayList<String>();
        Intent intent = new Intent(this, inputWords.class);
        intent.putExtra("words", words);
        startActivity(intent);
        finish();
    }
}
