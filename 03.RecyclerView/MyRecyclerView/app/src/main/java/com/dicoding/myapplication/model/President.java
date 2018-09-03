package com.dicoding.myapplication.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by sidiqpermana on 10/29/16.
 */

public class President implements Parcelable {
    private String name, remarks, photo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.remarks);
        dest.writeString(this.photo);
    }

    President() {
    }

    private President(Parcel in) {
        this.name = in.readString();
        this.remarks = in.readString();
        this.photo = in.readString();
    }

    public static final Parcelable.Creator<President> CREATOR = new Parcelable.Creator<President>() {
        @Override
        public President createFromParcel(Parcel source) {
            return new President(source);
        }

        @Override
        public President[] newArray(int size) {
            return new President[size];
        }
    };
}
