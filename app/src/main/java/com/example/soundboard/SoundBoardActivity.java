package com.example.soundboard;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SoundBoardActivity extends AppCompatActivity {
    private Button a;
    private Button bFlat;
    private Button b;
    private SoundPool soundPool;
    private Boolean isSoundPoolLoaded;
    private int soundIDa;
    private int soundIDbFlat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound_board);
        wireWidgets();
        initializeMusic();
        setListeners();
    }

    private void initializeMusic() {
        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        soundPool = new SoundPool(10,AudioManager.STREAM_MUSIC,0);
        soundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int i, int i1) {
            isSoundPoolLoaded = true;
            }
        });
        soundIDa = soundPool.load(this, R.raw.scalea,1);
        soundIDbFlat = soundPool.load(this, R.raw.scalebb,1);
    }

    private void setListeners() {
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AudioManager audioManager =(AudioManager) getSystemService(AUDIO_SERVICE);
                float actualVolume = (float) audioManager
                        .getStreamVolume(AudioManager.STREAM_MUSIC);
                float maxVolume = (float) audioManager
                        .getStreamMaxVolume(AudioManager.STREAM_MUSIC);
                float volume = actualVolume / maxVolume;
                if (isSoundPoolLoaded) {
                    soundPool.play(soundIDa, volume, volume, 1, 0, 1f);
                    Log.e("Test", "Played sound");
                }
            }
        });
        bFlat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AudioManager audioManager =(AudioManager) getSystemService(AUDIO_SERVICE);
                float actualVolume = (float) audioManager
                        .getStreamVolume(AudioManager.STREAM_MUSIC);
                float maxVolume = (float) audioManager
                        .getStreamMaxVolume(AudioManager.STREAM_MUSIC);
                float volume = actualVolume / maxVolume;
                if (isSoundPoolLoaded) {
                    soundPool.play(soundIDbFlat, volume, volume, 1, 0, 1f);
                    Log.e("Test", "Played sound");
                }
            }
        });
    }

    private void wireWidgets() {
        a = findViewById(R.id.button_Main_A);
        bFlat = findViewById(R.id.button_main_BFlat);
        b = findViewById(R.id.button_Main_B);
    }
}
