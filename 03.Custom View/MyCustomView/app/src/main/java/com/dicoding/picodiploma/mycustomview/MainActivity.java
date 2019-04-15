package com.dicoding.picodiploma.mycustomview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MyButton myButton;
    private MyEditText myEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myButton = findViewById(R.id.my_button);
        myEditText = findViewById(R.id.my_edit_text);

        // Melakukan pengecekan saat pertama kali activity terbentuk
        if (myEditText.getText()!=null){
            setMyButtonEnable(myEditText.getText().toString());
        }

        // Menambahkan metode ketika text terjadi perubahan
        myEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                setMyButtonEnable(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        // Menambahkan aksi klik kepada button
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, myEditText.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Metode untuk mengubah disable dan enable pada button
    private void setMyButtonEnable(String string){
        if (string.isEmpty()){
            myButton.setEnabled(false);
        }else{
            myButton.setEnabled(true);
        }
    }
}
