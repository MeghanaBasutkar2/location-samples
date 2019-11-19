package com.example.retrofitnotificationapi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NotifApiClient {
    public static final String BASE_URL = "https://api-mib.ailiens.com/b/";
    private static Retrofit retrofit = null;


    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}


   /* public void sendNotification(NotificatioNRequestModel notificatioNRequestModel) {
        Call<NotificationResponseModel> dictionaryEntries = service.getNotificationResponse(notificatioNRequestModel);
        dictionaryEntries.enqueue(callback);
    }*/

