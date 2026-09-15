package com.example.kamilpoplawski4pt;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button wlacz;
    private Button zatwierdz;
    private TextView odkurzac;
    private TextView status;
    private TextView numer;
    private boolean isVacuumOn = false;

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
        init();
        ustawNumer();
        wlaczanie();
    }
    private void init() {
        editText = findViewById(R.id.eTPralka);
        wlacz = findViewById(R.id.btnWlacz);
        zatwierdz = findViewById(R.id.btnPralka);
        odkurzac = findViewById(R.id.tVOdkurzaczStatus);
        status = findViewById(R.id.tVStatus);
        numer = findViewById(R.id.tvNumber);
    }

    private void ustawNumer() {
        zatwierdz.setOnClickListener(view -> {
            String sciagnietyTekst = editText.getText().toString();

            String tekstDalej = sciagnietyTekst.replaceAll("[^0-9]", "");

            if (tekstDalej.isEmpty()) {
                numer.setText("Zle");
                return;
            }
            int sciagnietyTekstParsed = Integer.parseInt(tekstDalej);

            if (sciagnietyTekstParsed >= 1 && sciagnietyTekstParsed <= 12) {
                numer.setText("Numer prania: " + sciagnietyTekstParsed);
            } else {
                numer.setText("Zle");
            }
        });
    }
    private void wlaczanie() {
        wlacz.setOnClickListener(v -> {
            isVacuumOn = !isVacuumOn;
            if (isVacuumOn) {
                wlacz.setText("Wyłącz");
                odkurzac.setText("Odkurzacz włączony");
            } else {
                wlacz.setText("Włącz");
                odkurzac.setText("Odkurzacz wyłączony");
            }
        });
    }


}