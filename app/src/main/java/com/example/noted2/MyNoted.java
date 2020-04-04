package com.example.noted2;

public class MyNoted {

    String titlenoted;
    String datenoted;
    String descnoted;


    public MyNoted() {
    }

    public MyNoted(String titlenoted, String datenoted, String descnoted) {
        this.titlenoted = titlenoted;
        this.datenoted = datenoted;
        this.descnoted = descnoted;
    }

    public String getTitlenoted() {

        return titlenoted;
    }

    public void setTitlenoted(String titlenoted) {
        this.titlenoted = titlenoted;
    }

    public String getDatenoted() {

        return datenoted;
    }

    public void setDatenoted(String datenoted) {

        this.datenoted = datenoted;
    }

    public String getDescnoted() {

        return descnoted;
    }

    public void setDescnoted(String descnoted) {

        this.descnoted = descnoted;
    }
}
