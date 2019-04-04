package com.example.assignment6.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserPosts implements Parcelable {

    @SerializedName("userId")
    @Expose
    private Integer userId;

    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("body")
    @Expose
    private String body;

    public UserPosts(Parcel in) {
        if (in.readByte() == 0) {
            userId = null;
        } else {
            userId = in.readInt();
        }
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        title = in.readString();
        body = in.readString();
    }

    /**
     * constructor of user posts
     *
     * @param userId
     * @param id
     * @param title
     * @param body
     */
    public UserPosts(Integer userId, Integer id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public static final Creator<UserPosts> CREATOR = new Creator<UserPosts>() {
        @Override
        public UserPosts createFromParcel(Parcel in) {
            return new UserPosts(in);
        }

        @Override
        public UserPosts[] newArray(int size) {
            return new UserPosts[size];
        }
    };


    public Integer getUserId() {
        return userId;
    }


    /**
     *
     * @return id of the post
     */
    public Integer getId() {
        return id;
    }



    /**
     *
     * @return title of the post
     */
    public String getTitle() {
        return title;
    }


    /**
     *
     * @return body of the post
     */
    public String getBody() {
        return body;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (userId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(userId);
        }
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(id);
        }
        dest.writeString(title);
        dest.writeString(body);
    }
}