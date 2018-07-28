package com.ashwariya.colsaw.message;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Parcelable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
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

    public void onclickbutton(View v) {
        EditText Message = (EditText) findViewById(R.id.Message);
        EditText Number = (EditText) findViewById(R.id.Number);

        switch (v.getId()) {
            case R.id.message:
                Toast.makeText(this, "HErer",Toast.LENGTH_SHORT).show();
                if (ContextCompat.checkSelfPermission(MainActivity.this,Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.SEND_SMS}, 1);
                } else {
                    if(Number.getText().toString().isEmpty() || Message.getText().toString().isEmpty()){
                        // skipped TODO
                    }else {
                        SmsManager smsManager = SmsManager.getDefault();
                        smsManager.sendTextMessage(Number.getText().toString(), null, Message.getText().toString(), null, null);
//                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:" + Number));
//                    intent.putExtra("sms_body", (Parcelable) Message);
//                    startActivity(intent);
                        Toast.makeText(getApplicationContext(), "Message Sent", Toast.LENGTH_SHORT).show();
                    }
                }
                break;

            case R.id.close:
                Message.setText("");
                Number.setText("");
                break;

            case R.id.phone:
                if (Number.getText().toString().trim().length() > 0) {
                    Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "Your Phone_number"));

                    try {
                        if (ContextCompat.checkSelfPermission(MainActivity.this,Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                            ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.CALL_PHONE}, 1);
                        } else {
                            Toast.makeText(getApplicationContext(), Number.getText().toString(), Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+Number.getText().toString())));
                        }

                    }catch(Exception e){
                        Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(getApplicationContext(), "Feilds cannot be empty", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.Browser:
                if(Message.getText().toString().trim().length() > 0){
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(Message.getText().toString()));
                    startActivity(i);
                }else{
                    Toast.makeText(getApplicationContext(), "Feilds cannot be empty", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.nextpage:
                if(Message.getText().toString().trim().length() > 0 && Number.getText().toString().trim().length() > 0){
                    Intent intent = new Intent(this, newpage.class);
                    Bundle extras = new Bundle();
                    extras.putString("message",Message.getText().toString());
                    extras.putString("number", Number.getText().toString());
                    intent.putExtras(extras);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(), "Feilds cannot be empty", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
