package com.example.imageswitch;

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
    ImageView img;
    Button previous, next;
    int[] resource = {R.drawable.one,R.drawable.two,R.drawable.three,R.drawable.four,R.drawable.five,R.drawable.six};
    int count = 0;
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
        img = findViewById(R.id.img);
        previous = findViewById(R.id.previous);
        next = findViewById(R.id.next);
        img.setImageResource(resource[count]);
        if (count<=0) previous.setVisibility(View.INVISIBLE);
        if (count>=resource.length) next.setVisibility(View.INVISIBLE);
        previous.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                count--;
                next.setVisibility(View.VISIBLE);
                img.setImageResource(resource[count]);
                if (count<=0) previous.setVisibility(View.INVISIBLE);
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                if (count==resource.length-1) next.setVisibility(View.INVISIBLE);
                previous.setVisibility(View.VISIBLE);
                img.setImageResource(resource[count]);
                if (count>=resource.length) next.setVisibility(View.INVISIBLE);
            }
        });
    }
}