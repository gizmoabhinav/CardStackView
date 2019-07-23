package com.yuyakaido.android.cardstackview.sample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class CardFullViewActivity extends AppCompatActivity {
    private String name;
    private String subject;
    private String content;
    private String summary;
    private String source;
    private String[] tags;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_full_view);
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        subject = intent.getStringExtra("subject");
        content = intent.getStringExtra("content");
        summary = intent.getStringExtra("summary");
        source = intent.getStringExtra("source");
        tags =  intent.getStringArrayExtra("tags");

        setupUI();
    }

    private void setupUI(){
        ((TextView)findViewById(R.id.sender_name)).setText(name);
        int sourceRes = 0;
        if(source.equals("teams")){
            sourceRes = R.drawable.teams;
        }else if(source.equals("email")){
            sourceRes = R.drawable.outlook;
        }else if(source.equals("excel")){
            sourceRes = R.drawable.excel;
        }

        ((ImageView)findViewById(R.id.source_icon)).setImageResource(sourceRes);

        ((TextView)findViewById(R.id.subject)).setText(subject);

        ((TextView)findViewById(R.id.summary)).setText(summary);

        ((TextView)findViewById(R.id.content)).setText(content);

        ((TextView)findViewById(R.id.tag1)).setText(tags[0]);

        if(tags.length > 1){
            ((TextView)findViewById(R.id.tag2)).setText(tags[1]);
            findViewById(R.id.tag2).setVisibility(View.VISIBLE);
        }
    }
}
