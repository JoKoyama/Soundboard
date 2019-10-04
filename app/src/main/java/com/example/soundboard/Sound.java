package com.example.soundboard;

public class Sound {
    private int sound;
    private double noteTime;
    private float volR;
    private float VolL;
    public Sound(int soundId,double noteTime,float VolR,float VolL){
        this.noteTime = noteTime;
        sound = soundId;
        this.VolL = VolL;
        this.volR = VolR;
    }


    public int getSound() {
        return sound;
    }

    public void setSound(int sound) {
        this.sound = sound;
    }

    public double getNoteTime() {
        return noteTime*357.14;
    }

    public void setNoteTime(double noteTime) {
        this.noteTime = noteTime;
    }

    public float getVolR() {
        return volR;
    }

    public void setVolR(float volR) {
        this.volR = volR;
    }

    public float getVolL() {
        return VolL;
    }

    public void setVolL(float volL) {
        VolL = volL;
    }
}
