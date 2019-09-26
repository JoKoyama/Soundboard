package com.example.soundboard;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SoundBoardActivity extends AppCompatActivity implements View.OnClickListener{
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
    private Button scale;
//    private Switch switcher;
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
    private int soundIDhigha;
    private int soundIDhighbFlat;
    private int soundIDhighb;
    private int soundIDhighc;
    private int soundIDhighcSharp;
    private int soundIDhighd;
    private int soundIDhighdSharp;
    private int soundIDhighe;
    private int soundIDhighf;
    private int soundIDhighfSharp;
    private int soundIDhighg;
    private int soundIDhighgSharp;
    private Map<Integer,Integer> noteMap;
    private ArrayList<Integer> scaleList;
    private ArrayList<Integer> songList;

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
        soundIDhigha = soundPool.load(this, R.raw.scalehigha,1);
        soundIDhighbFlat = soundPool.load(this, R.raw.scalehighbb,1);
        soundIDhighb = soundPool.load(this, R.raw.scalehighb,1);
        soundIDhighc = soundPool.load(this, R.raw.scalehighc,1);
        soundIDhighcSharp = soundPool.load(this, R.raw.scalehighcs,1);
        soundIDhighd = soundPool.load(this, R.raw.scalehighd,1);
        soundIDhighdSharp = soundPool.load(this, R.raw.scalehighds,1);
        soundIDhighe = soundPool.load(this, R.raw.scalehighe,1);
        soundIDhighf = soundPool.load(this, R.raw.scalehighf,1);
        soundIDhighfSharp = soundPool.load(this, R.raw.scalehighfs,1);
        soundIDhighg = soundPool.load(this, R.raw.scalehighg,1);
        soundIDhighgSharp = soundPool.load(this, R.raw.scalehighgs,1);
        noteMap = new HashMap<>();
        scaleList = new ArrayList();

        noteMap.put(a.getId(),soundIDhigha);
        noteMap.put(bFlat.getId(),soundIDhighbFlat);
        noteMap.put(b.getId(),soundIDhighb);
        noteMap.put(c.getId(),soundIDhighc);
        noteMap.put(cSharp.getId(),soundIDhighcSharp);
        noteMap.put(d.getId(),soundIDhighd);
        noteMap.put(dSharp.getId(),soundIDhighdSharp);
        noteMap.put(e.getId(),soundIDhighe);
        noteMap.put(f.getId(),soundIDhighf);
        noteMap.put(fSharp.getId(),soundIDhighfSharp);
        noteMap.put(g.getId(),soundIDhighg);
        noteMap.put(gSharp.getId(),soundIDhighgSharp);

        scaleList.add(soundIDa);
        scaleList.add(soundIDbFlat);
        scaleList.add(soundIDb);
        scaleList.add(soundIDc);
        scaleList.add(soundIDcSharp);
        scaleList.add(soundIDd);
        scaleList.add(soundIDdSharp);
        scaleList.add(soundIDe);
        scaleList.add(soundIDf);
        scaleList.add(soundIDfSharp);
        scaleList.add(soundIDg);
        scaleList.add(soundIDgSharp);
        scaleList.add(soundIDhigha);
        scaleList.add(soundIDhighbFlat);
        scaleList.add(soundIDhighb);
        scaleList.add(soundIDhighc);
        scaleList.add(soundIDhighcSharp);
        scaleList.add(soundIDhighd);
        scaleList.add(soundIDhighdSharp);
        scaleList.add(soundIDhighe);
        scaleList.add(soundIDhighf);
        scaleList.add(soundIDhighfSharp);
        scaleList.add(soundIDhighg);
        scaleList.add(soundIDhighgSharp);

        songList.add(soundIDhighd);
        songList.add(soundIDhighfSharp);
        songList.add(soundIDhighd);
        songList.add(soundIDhighfSharp);
        songList.add(soundIDhighd);
        songList.add(soundIDhighfSharp);




    }


    private void setListeners() {
        KeyBoardListener keyBoardListener = new KeyBoardListener();
        a.setOnClickListener(keyBoardListener);
        bFlat.setOnClickListener(keyBoardListener);
        b.setOnClickListener(keyBoardListener);
        c.setOnClickListener(keyBoardListener);
        cSharp.setOnClickListener(keyBoardListener);
        d.setOnClickListener(keyBoardListener);
        dSharp.setOnClickListener(keyBoardListener);
        e.setOnClickListener(keyBoardListener);
        f.setOnClickListener(keyBoardListener);
        fSharp.setOnClickListener(keyBoardListener);
        g.setOnClickListener(keyBoardListener);
        gSharp.setOnClickListener(keyBoardListener);
        scale.setOnClickListener(this);
//        switcher.setOnClickListener();
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
            }

    }

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
        scale = findViewById(R.id.button_main_scale);
//        switcher = findViewById(R.id.switch_main_LayoutSwitch);
    }



    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.button_main_scale : {
                for( int note : scaleList) {
                    playSound(note);
                    delay(200);
                }
                break;
            }
//            case R.id.butt
        }
    }

    private void delay(int i) {
        try {Thread.sleep(i);}
            catch (InterruptedException e)
            {e.printStackTrace();}
    }
    private class KeyBoardListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            //read from map to find note
            int songId = noteMap.get(view.getId());
            if(songId != 0){soundPool.play(songId,1,1,1,0,1);}
        }
    };
}
