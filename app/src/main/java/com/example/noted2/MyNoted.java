package com.example.noted2;

public class MyNoted {

    String titlenoted;
    String datenoted;
    String descnoted;
    String keynote;


    public MyNoted() {
    }

    public MyNoted(String titlenoted, String datenoted, String descnoted, String keynote) {
        this.titlenoted = titlenoted;
        this.datenoted = datenoted;
        this.descnoted = descnoted;
        this.keynote = keynote;
    }

    public String getKeynote() {
        return keynote;
    }

    public void setKeynote(String keynote) {
        this.keynote = keynote;
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
