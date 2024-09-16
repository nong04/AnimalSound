package com.example.animalsound;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    TextView textView;
    ConstraintLayout layout;
    int ngauNhien;
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
        randomizeBackground();
    }
    final int[] imgID = {
            R.drawable.pig,
            R.drawable.axolotl,
            R.drawable.cat,
            R.drawable.chicken,
            R.drawable.fox,
    };
    final int[] layoutID = {
            R.color.purple_200,
            R.color.purple_500,
            R.color.purple_700,
            R.color.teal_200,
            R.color.teal_700
    };
    final int[] textID = {
            R.string.pig,
            R.string.axolotl,
            R.string.cat,
            R.string.chicken,
            R.string.fox
    };
    private void randomizeBackground() {
        layout = findViewById(R.id.main);
        ngauNhien = new Random().nextInt(imgID.length);
        imageView = findViewById(R.id.iVImage);
        imageView.setImageResource(imgID[ngauNhien]);
        textView = findViewById(R.id.tVText);
        textView.setText(textID[ngauNhien]);
        layout.setBackgroundResource(layoutID[new Random().nextInt(layoutID.length)]);
    }
}