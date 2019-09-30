package com.example.soundboard;

public class Sound {
    private int sound;
    private double noteTime;
    public Sound(int soundId,double noteTime){
        this.noteTime = noteTime;
        sound = soundId;
    };

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
}
