package com.example.clara.madlibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class inputWords extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_words);
    }


    public void goToThirdActivity(View view) {
        Intent intent = new Intent(this, ShowStory.class);
        startActivity(intent);
        finish();
    }
}
