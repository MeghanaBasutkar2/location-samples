package com.example.retrofitnotificationapi;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class NotificatioNRequestModel {

    public NotificatioNRequestModel(String deeplink, ArrayList<String> userIds, String title, String body, String eventType, String notificationType) {
        this.deeplink = deeplink;
        this.userIds = userIds;
        this.title = title;
        this.body = body;
        this.eventType = eventType;
        this.notificationType = notificationType;
    }

    @SerializedName("deeplink")
    private String deeplink;

    @SerializedName("userIds")
    ArrayList<String> userIds = new ArrayList<String>();

    @SerializedName("title")
    private String title;

    @SerializedName("body")
    private String body;

    @SerializedName("eventType")
    private String eventType;

    @SerializedName("notificationType")
    private String notificationType;

    public void setUserIds(ArrayList<String> userIds) {
        this.userIds = userIds;
    }

    public ArrayList<String> getUserIds() {
        return userIds;
    }

    public String getDeeplink() {
        return deeplink;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public String getEventType() {
        return eventType;
    }

    public String getNotificationType() {
        return notificationType;
    }

    // Setter Methods

    public void setDeeplink(String deeplink) {
        this.deeplink = deeplink;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public void setNotificationType(String notificationType) {
        this.notificationType = notificationType;
    }
}
