package com.example.computervision;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;

import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MainActivity extends AppCompatActivity {

    private static final int IMAGE_PICK_CODE = 1000;
    private static final int CURRENCY_CONVERTER_REQUEST = 1;
    private static final int NUMBER_PLATE_DETECTION_REQUEST = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CardView cardCurrency = findViewById(R.id.card_currency);
        CardView cardNumberPlate = findViewById(R.id.card_number_plate);

        cardCurrency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start CurrencyConverterActivity
                Intent intent = new Intent(MainActivity.this, CurrencyConverterActivity.class);
                startActivityForResult(intent, CURRENCY_CONVERTER_REQUEST);
            }
        });

        cardNumberPlate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start NumberPlateDetectionActivity
                Intent intent = new Intent(MainActivity.this, NumberPlateDetectionActivity.class);
                startActivityForResult(intent, NUMBER_PLATE_DETECTION_REQUEST);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && data != null) {
            Uri imageUri = data.getData();
            if (requestCode == CURRENCY_CONVERTER_REQUEST) {
                // Handle currency converter logic
            } else if (requestCode == NUMBER_PLATE_DETECTION_REQUEST) {
                // Start the number plate detection activity with the selected image
                Intent intent = new Intent(MainActivity.this, NumberPlateDetectionActivity.class);
                intent.putExtra("imageUri", imageUri.toString());
                startActivity(intent);
            }
        }
    }
}
