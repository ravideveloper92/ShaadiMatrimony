package com.ravi.shaadimatches.data;

import androidx.room.TypeConverter;

import com.ravi.shaadimatches.data.model.Dob;
import com.ravi.shaadimatches.data.model.Id;
import com.ravi.shaadimatches.data.model.Info;
import com.ravi.shaadimatches.data.model.Location;
import com.ravi.shaadimatches.data.model.Login;
import com.ravi.shaadimatches.data.model.Name;
import com.ravi.shaadimatches.data.model.Picture;
import com.ravi.shaadimatches.data.model.Registered;
import com.ravi.shaadimatches.data.model.Timezone;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ravi.shaadimatches.data.model.Coordinates;

import java.lang.reflect.Type;

public class Converters {

    Gson gson = new Gson();

    public Converters(){

    }


    @TypeConverter
    public Dob StringToDob(String string) {
        Type type = new TypeToken<Dob>() {
        }.getType();
        return gson.fromJson(string, type);
    }

    @TypeConverter
    public String DobToString(Dob dob) {
        return gson.toJson(dob);
    }

    @TypeConverter
    public Coordinates StringToCoordinates(String string) {
        Type type = new TypeToken<Coordinates>() {
        }.getType();
        return gson.fromJson(string, type);
    }

    @TypeConverter
    public String CoordinatesToString(Coordinates coordinates) {
        return gson.toJson(coordinates);
    }

    @TypeConverter
    public Id StringToId(String string) {
        Type type = new TypeToken<Id>() {
        }.getType();
        return gson.fromJson(string, type);
    }

    @TypeConverter
    public String IdToSting(Id id) {
        return gson.toJson(id);
    }

    @TypeConverter
    public Info StringToInfo(String string) {
        Type type = new TypeToken<Info>() {
        }.getType();
        return gson.fromJson(string, type);
    }

    @TypeConverter
    public String InfoToSting(Info info) {
        return gson.toJson(info);
    }

    @TypeConverter
    public Location StringToLocation(String string) {
        Type type = new TypeToken<Location>() {
        }.getType();
        return gson.fromJson(string, type);
    }

    @TypeConverter
    public String LocationToSting(Location location) {
        return gson.toJson(location);
    }

    @TypeConverter
    public Login StringToLogin(String string) {
        Type type = new TypeToken<Login>() {
        }.getType();
        return gson.fromJson(string, type);
    }

    @TypeConverter
    public String LoginToSting(Login login) {
        return gson.toJson(login);
    }

    @TypeConverter
    public Name StringToName(String string) {
        Type type = new TypeToken<Name>() {
        }.getType();
        return gson.fromJson(string, type);
    }

    @TypeConverter
    public String NameToSting(Name name) {
        return gson.toJson(name);
    }

    @TypeConverter
    public Picture StringToPicture(String string) {
        Type type = new TypeToken<Picture>() {
        }.getType();
        return gson.fromJson(string, type);
    }

    @TypeConverter
    public String PictureToSting(Picture picture) {
        return gson.toJson(picture);
    }

    @TypeConverter
    public Registered StringToRegistered(String string) {
        Type type = new TypeToken<Registered>() {
        }.getType();
        return gson.fromJson(string, type);
    }

    @TypeConverter
    public String RegisteredToSting(Registered picture) {
        return gson.toJson(picture);
    }

    @TypeConverter
    public Timezone StringToTimezone(String string) {
        Type type = new TypeToken<Timezone>() {
        }.getType();
        return gson.fromJson(string, type);
    }

    @TypeConverter
    public String TimezoneToSting(Timezone timezone) {
        return gson.toJson(timezone);
    }
}
