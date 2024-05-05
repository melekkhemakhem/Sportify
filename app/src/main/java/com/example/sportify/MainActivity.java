package com.example.sportify;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText weightEditText, heightEditText;
    private RadioButton maleRadioButton, femaleRadioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weightEditText = findViewById(R.id.weight_edit_text);
        heightEditText = findViewById(R.id.height_edit_text);
        maleRadioButton = findViewById(R.id.rbtOui);
        femaleRadioButton = findViewById(R.id.rbtNon);

        Button calculateImcButton = findViewById(R.id.buttonNavigateToSecondActivity);
        calculateImcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String weightString = weightEditText.getText().toString().trim();
                String heightString = heightEditText.getText().toString().trim();

                if (TextUtils.isEmpty(weightString) || TextUtils.isEmpty(heightString)) {
                    Toast.makeText(MainActivity.this, "Veuillez saisir tous les champs.", Toast.LENGTH_SHORT).show();
                    return;
                }

                double weight = Double.parseDouble(weightString);
                double height = Double.parseDouble(heightString);

                if (weight <= 0 || height <= 0) {
                    Toast.makeText(MainActivity.this, "Les valeurs de poids et de taille doivent être positives.", Toast.LENGTH_SHORT).show();
                    return;
                }

                double imc = calculateImc(weight, height);
                String imcFormatted = String.format("%.2f", imc);

                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("imc", imcFormatted);
                startActivity(intent);
            }
        });
    }

    private double calculateImc(double weight, double height) {
        double heightInMeters = height / 100;
        return weight / (heightInMeters * heightInMeters);
    }
}