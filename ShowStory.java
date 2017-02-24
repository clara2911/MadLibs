package com.example.clara.madlibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.stepp.madlibs.Story;

import java.util.ArrayList;

public class ShowStory extends AppCompatActivity {

    Story story;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_story);
        Intent intent = getIntent();
        story = (Story) intent.getSerializableExtra("story");
        TextView textview1 = (TextView) findViewById(R.id.storyTextView);
        textview1.setText(story.toString());
    }

    public void goToFirstActivity(View view) {
        story.clear();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
