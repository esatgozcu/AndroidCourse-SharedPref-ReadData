package com.esatgozcu.sharedprefreaddata;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.readData);
        textView = findViewById(R.id.textData);

        final SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("key","apple");
        editor.apply();


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String text = sharedPreferences.getString("key","Not Found Data");
                textView.setText(text);
            }
        });
    }
}
