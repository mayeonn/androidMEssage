package com.example.a4pm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    Button b1,b2;
    TextView m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        b1=findViewById(R.id.back);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callBack();
            }
        });

        b2=findViewById(R.id.send);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callMessage();
            }
        });

        m=findViewById(R.id.msg);
        Intent intent = getIntent();
        String msg=intent.getStringExtra("msg");
        m.setText(msg);

    }

    private void callMessage() {
        Intent intent = new Intent(this, FirstActivity.class);
        intent.putExtra("msg", m.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }

    private void callBack() {
        finish();
    }
}