package com.example.sportify;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    private GoogleFitService googleFitService;
    private TextView stepCountTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        googleFitService = new GoogleFitService(this);
        googleFitService.connect();

        stepCountTextView = findViewById(R.id.step_count_text_view);

        googleFitService.readStepsData(new GoogleFitService.DataReadResultListener() {
            @Override
            public void onStepsRead(int steps) {
                stepCountTextView.setText("Nombre de pas : " + steps);
            }

            @Override
            public void onError(int status) {
                stepCountTextView.setText("Erreur de lecture des pas");
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        googleFitService.disconnect();
    }
}
