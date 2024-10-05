package com.example.traffic;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    ImageView red , yellow , green;
    Button redbtn , yellowbtn , greenbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        red = findViewById(R.id.red);
        yellow = findViewById(R.id.yellow);
        green = findViewById(R.id.green);
        redbtn = findViewById(R.id.redbtn);
        yellowbtn = findViewById(R.id.yellowbtn);
        greenbtn = findViewById(R.id.greenbtn);
        redbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                red.setVisibility(View.VISIBLE);
                yellow.setVisibility(View.INVISIBLE);
                green.setVisibility(View.INVISIBLE);

            }
        });
        yellowbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                red.setVisibility(View.INVISIBLE);
                yellow.setVisibility(View.VISIBLE);
                green.setVisibility(View.INVISIBLE);

            }
        });
        greenbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                red.setVisibility(View.INVISIBLE);
                yellow.setVisibility(View.INVISIBLE);
                green.setVisibility(View.VISIBLE);

            }
        });
        }
    }
