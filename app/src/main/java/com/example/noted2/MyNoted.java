package com.example.noted2;

import android.util.Log;

public class MyNoted {

    String titlenote;
    String datenote;
    String descnote;
    String keynote;


    public MyNoted() {
        Log.d("\n\nLOG_TEST", "TEST1");
    }

    public MyNoted(String titlenoted, String datenoted, String descnoted, String keynote) {
        this.titlenote = titlenoted;
        this.datenote = datenoted;
        this.descnote = descnoted;
        this.keynote = keynote;
    }

    public String getKeynote() {
        return keynote;
    }

    public void setKeynote(String keynote) {
        this.keynote = keynote;
    }

    public String getTitlenoted() {

        return titlenote;
    }

    public void setTitlenoted(String titlenoted) {
        this.titlenote = titlenoted;
    }

    public String getDatenoted() {

        return datenote;
    }

    public void setDatenoted(String datenoted) {

        this.datenote = datenoted;
    }

    public String getDescnoted() {

        return descnote;
    }

    public void setDescnoted(String descnoted) {

        this.descnote = descnoted;
    }
}
