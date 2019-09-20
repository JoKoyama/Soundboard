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
    private Button c;
    private Button cSharp;
    private Button d;
    private Button dSharp;
    private Button e;
    private Button f;
    private Button fSharp;
    private Button g;
    private Button gSharp;
    private SoundPool soundPool;
    private Boolean isSoundPoolLoaded;
    private int soundIDa;
    private int soundIDbFlat;
    private int soundIDb;
    private int soundIDc;
    private int soundIDcSharp;
    private int soundIDd;
    private int soundIDdSharp;
    private int soundIDe;
    private int soundIDf;
    private int soundIDfSharp;
    private int soundIDg;
    private int soundIDgSharp;

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
        soundIDb = soundPool.load(this, R.raw.scaleb,1);
        soundIDc = soundPool.load(this, R.raw.scalec,1);
        soundIDcSharp = soundPool.load(this, R.raw.scalecs,1);
        soundIDd = soundPool.load(this, R.raw.scaled,1);
        soundIDdSharp = soundPool.load(this, R.raw.scaleds,1);
        soundIDe = soundPool.load(this, R.raw.scalee,1);
        soundIDf = soundPool.load(this, R.raw.scalef,1);
        soundIDfSharp = soundPool.load(this, R.raw.scalefs,1);
        soundIDg = soundPool.load(this, R.raw.scaleg,1);
        soundIDgSharp = soundPool.load(this, R.raw.scalegs,1);
    }


    private void setListeners() {
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playSound(soundIDa);
                }
        });
        bFlat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playSound(soundIDbFlat);
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playSound(soundIDb);
            }
        });
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playSound(soundIDc);
            }
        });
        cSharp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playSound(soundIDcSharp);
            }
        });
        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playSound(soundIDd);
            }
        });
        dSharp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playSound(soundIDdSharp);
            }
        });
        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playSound(soundIDe);
            }
        });
        f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playSound(soundIDf);
            }
        });
        fSharp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playSound(soundIDfSharp);
            }
        });
        g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playSound(soundIDg);
            }
        });
        gSharp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playSound(soundIDgSharp);
            }
        });
    }

    private void playSound(int soundID) {
        AudioManager audioManager =(AudioManager) getSystemService(AUDIO_SERVICE);
        float actualVolume = (float) audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        float maxVolume = (float) audioManager
                .getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        float volume = actualVolume / maxVolume;
        if (isSoundPoolLoaded) {
            soundPool.play(soundID, volume, volume, 1, 0, 1f);
            Log.e("Test", "Played sound");
    }}

    private void wireWidgets() {
        a = findViewById(R.id.button_Main_A);
        bFlat = findViewById(R.id.button_main_BFlat);
        b = findViewById(R.id.button_Main_B);
        c = findViewById(R.id.button_Main_C);
        cSharp = findViewById(R.id.button_Main_CSharp);
        d = findViewById(R.id.button_Main_D);
        dSharp = findViewById(R.id.button_Main_DSharp);
        e = findViewById(R.id.button_Main_E);
        f = findViewById(R.id.button_Main_F);
        fSharp = findViewById(R.id.button_Main_FSharp);
        g = findViewById(R.id.button_Main_G);
        gSharp = findViewById(R.id.button_Main_GSharp);
    }
}
