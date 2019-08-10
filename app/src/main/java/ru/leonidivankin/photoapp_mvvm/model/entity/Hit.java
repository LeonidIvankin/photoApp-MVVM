package ru.leonidivankin.photoapp_mvvm.model.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Hit {

    @Expose
    @SerializedName("id")
    public int id;

    @Expose
    @SerializedName("webformatURL")
    public String webformatURL;

}
