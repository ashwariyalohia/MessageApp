package com.ashwariya.colsaw.message;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void onclickbutton(View v){
        EditText Message = (EditText) findViewById (R.id.Message);
        EditText Number =(EditText) findViewById(R.id.Number);
        ImageButton message = (ImageButton) findViewById(R.id.message);
        ImageButton close = (ImageButton) findViewById(R.id.close);
        ImageButton phone =(ImageButton) findViewById(R.id.phone);
        ImageButton Browser = (ImageButton) findViewById(R.id.Browser);
        ImageButton nextpage = (ImageButton) findViewById(R.id.nextpage);

        switch(v.getId()){
            case R.id.message:
                if(Message.getText().toString().trim().length() > 0 && Number.getText().toString().trim().length() > 0){
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.fromParts(Message.getText().toString(), Number.getText().toString(), null)));

                }else{
                    Toast.makeText(getApplicationContext(), "Feilds cannot be empty", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.close:
                Message.setText("");
                
                break;

            case R.id.phone:
                break;

            case R.id.Browser:
                break;

            case R.id.nextpage:
                break;
        }
    }
}
