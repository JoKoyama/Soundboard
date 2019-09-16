package com.example.soundboard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class SoundBoardActivity extends AppCompatActivity {
    private Button a;
    private Button bFlat;
    private Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound_board);
        wireWidgets();
        setListeners();
    }

    private void setListeners() {
    }

    private void wireWidgets() {
        a = findViewById(R.id.button_Main_A);
        bFlat = findViewById(R.id.button_main_BFlat);
        b = findViewById(R.id.button_Main_B);
    }
}
