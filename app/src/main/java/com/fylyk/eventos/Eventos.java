package com.fylyk.eventos;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.DatePicker;

import com.fylyk.eventos.adapters.InvitesAdapter;

/**
 * Created by gustavo on 14-11-2014.
 */
public class Eventos {

    private int image_url;
    private String name;
    private String organizer;
    private String place;
    private DatePicker date;

    private int image_thumb;

    public Eventos(int image_url, DatePicker date, String place, String organizer, String name, int image_thumb) {
        this.image_url = image_url;
        this.date = date;
        this.place = place;
        this.organizer = organizer;
        this.name = name;
        this.image_thumb = image_thumb;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getImage_thumb() {
        return image_thumb;
    }

    public void setImage_thumb(int image_thumb) {
        this.image_thumb = image_thumb;
    }

    public DatePicker getDate() {
        return date;
    }

    public void setDate(DatePicker date) {
        this.date = date;
    }

    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage_url() {
        return image_url;
    }


    public void setImage_url(int image_url) {
        this.image_url = image_url;
    }

    public Bundle createBundle(){
        Bundle b = new Bundle();
        b.putInt("img",image_url);
        b.putString("name",name);
        b.putString("org",organizer);
        b.putString("place",place);
        b.putString("date", InvitesAdapter.formatDate(date));
        return b;
    }
}
