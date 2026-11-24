package com.example.funtax;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    RadioButton benzinenButton;
    RadioButton dieselButton;
    RadioButton lpgButton;

    TextView wynikTextView;
    Button obliczButton;

    EditText liczbaPasazEditText;
    EditText zuzycieEditText;
    EditText dystansEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        benzinenButton = findViewById(R.id.benzinenButton);
        benzinenButton.setChecked(true);

        dieselButton = findViewById(R.id.dieselButton);
        lpgButton = findViewById(R.id.lpgButton);
        wynikTextView = findViewById(R.id.wynikTextView);
        obliczButton = findViewById(R.id.obliczButton);
        liczbaPasazEditText = findViewById(R.id.liczbaPasazEditText);
        zuzycieEditText = findViewById(R.id.zuzycieEditText);
        dystansEditText = findViewById(R.id.dystansEditText);

        obliczButton.setOnClickListener(v -> {
            double dystans = Double.parseDouble(dystansEditText.getText().toString());
            double zuzycie = Double.parseDouble(zuzycieEditText.getText().toString());
            double paliwo;
            int pasarz = Integer.parseInt(liczbaPasazEditText.getText().toString());

            if (dieselButton.isChecked()) {
                paliwo = 6.7;
            } else if (lpgButton.isChecked()) {
                paliwo = 3.1;
            }else {
                paliwo = 6.5;
            }

            double wynik = (dystans * (zuzycie/100) * paliwo);

            wynikTextView.setText(
                   "Całkowity koszt: " + Double.toString(wynik) + " Koszt na os: " + Double.toString(wynik/pasarz)
            );
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}