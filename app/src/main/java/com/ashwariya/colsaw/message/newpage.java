package com.ashwariya.colsaw.message;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class newpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitytwo);
        TextView Message = findViewById(R.id.textView);
        TextView Number = findViewById(R.id.textView4);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        assert extras != null;
        Message.setText(extras.getString("message"));
        Number.setText(extras.getString("number"));

    }
}
