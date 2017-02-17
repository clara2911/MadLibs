package com.example.clara.madlibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class inputWords extends AppCompatActivity {

    ArrayList<String> words;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_words);
        Intent intent = getIntent();
        words = intent.getStringArrayListExtra("words");
    }

    public void goToSecondActivityAgain(View view) {
        EditText wordObject = (EditText) findViewById(R.id.editText2);
        String word = wordObject.getText().toString();
        words.add(word);
        Intent intent;
        if(words.size() < 3) {
            intent = new Intent(this, inputWords.class);
        } else {
            intent = new Intent(this, ShowStory.class);
        }
        intent.putExtra("words", words);
        startActivity(intent);
        finish();


    }


    public void goToThirdActivity(View view) {
        Intent intent = new Intent(this, ShowStory.class);
        intent.putExtra("wordsList", words);
        startActivity(intent);
        finish();
    }
}
