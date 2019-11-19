package com.example.retrofitnotificationapi;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface NotificationService {

    @Headers({
            "X-Fc-ID: 0000111213",
            "X-Roles: ROLE_SUPER_WOMAN",
            "X-Tenant-ID: 5f9d336a-eedb-4fa4-b408-cf38cefc96e0",
            "Content-Type: application/json"
    })
    @POST("notification/notification/storeApp")
    Call<NotificationResponseModel> getNotificationResponse(@Body NotificatioNRequestModel
                                                                    notificatioNRequestModel);

}
//TODO if multi declaration doesn't work:
/*@Header("app_id") String id, @Header("app_key") String key*/