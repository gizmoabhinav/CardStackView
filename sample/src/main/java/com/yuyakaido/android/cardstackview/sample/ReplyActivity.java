package com.yuyakaido.android.cardstackview.sample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ReplyActivity extends AppCompatActivity {
    private String subject;
    private String summary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        setContentView(R.layout.activity_reply);
        subject = intent.getStringExtra("subject");
        summary = intent.getStringExtra("summary");

        ((TextView)findViewById(R.id.subject)).setText(subject);
        ((TextView)findViewById(R.id.summary)).setText(summary);

        findViewById(R.id.send).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        findViewById(R.id.cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
