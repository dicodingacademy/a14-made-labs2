package com.dicoding.picodiploma.learnespresso;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener {

    EditText edtText;
    Button btnChangeText, btnSwitchActivity;
    TextView tvPrintedText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Learn Espresso");
        }

        edtText = findViewById(R.id.edt_text);
        btnChangeText = findViewById(R.id.btn_change_text);
        btnSwitchActivity = findViewById(R.id.btn_swicth_activity);
        tvPrintedText = findViewById(R.id.tv_printed_text);

        btnChangeText.setOnClickListener(this);
        btnSwitchActivity.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_change_text:
                String lalalaText = "Lalala";
                edtText.setText(lalalaText);
                String input = edtText.getText().toString().trim();
                tvPrintedText.setText(input);
                break;

            case R.id.btn_swicth_activity:
                String text = edtText.getText().toString().trim();
                Intent intent = new Intent(this, SecondActivity.class);
                intent.putExtra(SecondActivity.EXTRA_INPUT, text);
                startActivity(intent);
                break;
        }
    }
}
