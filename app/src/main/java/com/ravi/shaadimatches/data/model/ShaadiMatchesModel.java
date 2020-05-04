
package com.ravi.shaadimatches.data.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.ravi.shaadimatches.data.Converters;
import com.ravi.shaadimatches.util.Constants;

@Entity(tableName = Constants.TABLE_NAME)
public class ShaadiMatchesModel {

    @SerializedName("gender")
    @Expose
    private String gender;

    @TypeConverters(Converters.class)
    @SerializedName("name")
    @Expose
    private Name name;
    @TypeConverters(Converters.class)
    @SerializedName("location")
    @Expose
    private Location location;
    @PrimaryKey()
    @NonNull
    @SerializedName("email")
    @Expose
    private String email;
    @TypeConverters(Converters.class)
    @SerializedName("login")
    @Expose
    private Login login;
    @TypeConverters(Converters.class)
    @SerializedName("dob")
    @Expose
    private Dob dob;
    @TypeConverters(Converters.class)
    @SerializedName("registered")
    @Expose
    private Registered registered;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("cell")
    @Expose
    private String cell;
    @TypeConverters(Converters.class)
    @SerializedName("id")
    @Expose
    private Id id;
    @TypeConverters(Converters.class)
    @SerializedName("picture")
    @Expose
    private Picture picture;
    @SerializedName("nat")
    @Expose
    private String nat;

    private boolean isAccept;

    private boolean isReject;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public Dob getDob() {
        return dob;
    }

    public void setDob(Dob dob) {
        this.dob = dob;
    }

    public Registered getRegistered() {
        return registered;
    }

    public void setRegistered(Registered registered) {
        this.registered = registered;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public String getNat() {
        return nat;
    }

    public void setNat(String nat) {
        this.nat = nat;
    }

    public boolean isAccept() {
        return isAccept;
    }

    public void setAccept(boolean accept) {
        isAccept = accept;
    }

    public boolean isReject() {
        return isReject;
    }

    public void setReject(boolean reject) {
        isReject = reject;
    }

    @Override
    public String toString() {
        return "ShaadiMatchesModel{" +
                "gender='" + gender + '\'' +
                ", name=" + name.toString() +
                ", location=" + location +
                ", email='" + email + '\'' +
                ", login=" + login +
                ", dob=" + dob +
                ", registered=" + registered +
                ", phone='" + phone + '\'' +
                ", cell='" + cell + '\'' +
                ", id=" + id +
                ", picture=" + picture +
                ", nat='" + nat + '\'' +
                ", isAccept=" + isAccept +
                ", isReject=" + isReject +
                '}';
    }
}
