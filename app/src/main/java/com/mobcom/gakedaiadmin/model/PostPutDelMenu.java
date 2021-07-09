package com.mobcom.gakedaiadmin.model;

import android.view.Menu;

import com.google.gson.annotations.SerializedName;

public class PostPutDelMenu {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    String result;
    MenuModel menuModel;
    @SerializedName("message")
    String message;

    public PostPutDelMenu(String status, String result, MenuModel menuModel, String message) {
        this.status = status;
        this.result = result;
        this.menuModel = PostPutDelMenu.this.menuModel;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public MenuModel getMenuModel() {
        return menuModel;
    }

    public void setMenuModel(MenuModel menuModel) {
        this.menuModel = PostPutDelMenu.this.menuModel;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
