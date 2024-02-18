package com.example.recycleviewassignment;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {
    TextView textViewName;
    TextView textViewDescription;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Retrieve the data
        String pictureName = getIntent().getStringExtra("name");
        int imageDrawable = getIntent().getIntExtra("imageDrawable", 0); // Default value 0
        String bio = getIntent().getStringExtra("bio");

        textViewName = findViewById(R.id.textView3);
        textViewDescription = findViewById(R.id.textView4);
        imageView = findViewById(R.id.imageView2);

        // Set the data to the views
        textViewName.setText(pictureName);
        textViewDescription.setText(bio);
        imageView.setImageResource(imageDrawable);
    }

    public void returnButton(View view) {
        finish();
    }
}

