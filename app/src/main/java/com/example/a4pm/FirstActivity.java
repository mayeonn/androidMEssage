package com.example.a4pm;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {
    Button b1,b2,b3;
    EditText e1, e2, e3;
    TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        e1=findViewById(R.id.et1);
        e2=findViewById(R.id.et2);
        e3=findViewById(R.id.et3);

        b1=findViewById(R.id.bt1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callSecondActivity();
            }
        });

        b2 = findViewById(R.id.bt2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callSecondActivityWithMsg();
            }
        });

        b3=findViewById(R.id.bt3);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callThirdActivityWithMsg();
            }
        });
    }

    private void callThirdActivityWithMsg() {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("msg", e3.getText().toString());
        startActivityForResult(intent, 1000);
    }

    private void callSecondActivityWithMsg() {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("msg", e2.getText().toString());
        startActivity(intent);

    }

    private void callSecondActivity() {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1000){
            if(resultCode==RESULT_OK){
                String msg = data.getStringExtra("msg");

                Toast.makeText(this, "from activity2: "+msg,Toast.LENGTH_SHORT).show();
            }
        }
    }
}