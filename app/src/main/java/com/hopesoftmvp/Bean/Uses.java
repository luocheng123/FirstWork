package com.hopesoftmvp.Bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by lenovo on 2017/2/17.
 */
public class Uses implements Parcelable{

    private String username;
    private String nickname;
    private String bao;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBao() {
        return bao;
    }

    public void setBao(String bao) {
        this.bao = bao;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.username);
        dest.writeString(this.nickname);
        dest.writeString(this.bao);
    }

    public  Uses(){

    }
    protected Uses(Parcel in) {
        this.username = in.readString();
        this.nickname = in.readString();
        this.bao = in.readString();
    }


    public static final Creator<Uses> CREATOR = new Creator<Uses>() {
        public Uses createFromParcel(Parcel source) {
            return new Uses(source);
        }

        public Uses[] newArray(int size) {
            return new Uses[size];
        }
    };
}
