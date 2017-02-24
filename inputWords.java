package com.example.clara.madlibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.stepp.madlibs.Story;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

public class inputWords extends AppCompatActivity {
    Story story;
    String storytext;
    InputStream inFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_words);


        // get wordslist variable from homepage
        Intent intent = getIntent();
        if(intent.getStringExtra("storytext") != null) {
            storytext = intent.getStringExtra("storytext");
            story = (Story) intent.getSerializableExtra("story");
        } else {
            getStorytext();
            story.read(inFile);
        }
        TextView categoryText = (TextView) findViewById(R.id.category);
        categoryText.setText(story.getNextPlaceholder());
        TextView numberRemainingText = (TextView) findViewById(R.id.numberRemaining);
        String count = Integer.toString(story.getPlaceholderRemainingCount());
        numberRemainingText.setText(count);
    }

    public void getStorytext() {
        inFile = null;
        try {
            inFile = txtToStream();
        } catch(FileNotFoundException e) {
            Log.d("File not found", "File not found");
        }
        story = new Story(inFile);
        storytext = story.toString();
    }

    public InputStream txtToStream()
        throws FileNotFoundException {
//            File initialFile = new File("res/raw/simp.txt");
//            InputStream is = null;
//            try {
//                is = new FileInputStream(initialFile);
//            } catch(FileNotFoundException e) {
//                Log.d("FileNotFoundException","File not found");
//            }
//        return is;
        String str = "<Male-Name> has announced that his <adjective>\n" +
                "clothing store in the heart of downtown <CITY> is having\n" +
                "a/an <adjective> sale of all merchandise, including\n" +
                "<unusual-adjective> suits and slightly irregular <plural-noun>\n" +
                "available. Men's cable-knit <plural-noun> , only $15.99.\n" +
                "Hand-woven Italian <plural-noun> , 1/2-price. Double-\n" +
                "breasted cashmere <plural-noun> , $50.00. Genuine imported\n" +
                "<Color!> <adjective> shoes, <Exciting-adjective> handerchiefs,\n" +
                "and women's embroidered <plural-noun> , all at rock-bottom prices.\n" +
                "This is a chance to get some really <Interesting-Adjective> bargains.";
        return new ByteArrayInputStream(str.getBytes());
    }

    public void goToSecondActivityAgain(View view) {
        EditText wordObject = (EditText) findViewById(R.id.editText2);
        String word = wordObject.getText().toString();
        story.fillInPlaceholder(word);
        Intent intent;
        if(story.getPlaceholderRemainingCount() > 0) {
            intent = new Intent(this, inputWords.class);
        } else {
            intent = new Intent(this, ShowStory.class);
        }
        intent.putExtra("storytext", storytext);
        intent.putExtra("story", story);
        startActivity(intent);
        finish();
    }

}
