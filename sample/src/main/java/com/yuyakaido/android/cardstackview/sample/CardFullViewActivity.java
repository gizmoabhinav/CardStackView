package com.yuyakaido.android.cardstackview.sample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class CardFullViewActivity extends AppCompatActivity {
    private String name;
    private String subject;
    private String content;
    private String summary;
    private String source;

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
    }
}
