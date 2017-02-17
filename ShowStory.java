package com.example.clara.madlibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class ShowStory extends AppCompatActivity {

    ArrayList<String> words;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_story);
        Intent intent = getIntent();
        words = intent.getStringArrayListExtra("words");
        TextView textview1 = (TextView) findViewById(R.id.displayedText1);
        textview1.setText(words.get(0));
        TextView textview2 = (TextView) findViewById(R.id.displayedText2);
        textview2.setText(words.get(1));
        TextView textview3 = (TextView) findViewById(R.id.displayedText3);
        textview3.setText(words.get(2));
    }
}
