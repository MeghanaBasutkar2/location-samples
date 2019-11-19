package com.example.retrofitnotificationapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    String success;
    public static final String TAG = MainActivity.class.getSimpleName();
    NotificatioNRequestModel notificatioNRequestModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> userIds = new ArrayList<>();
        userIds.add("577cb32ae4b09c1a2e3b1433");

        notificatioNRequestModel = new NotificatioNRequestModel("check",
                userIds, "excited", "Welcome Mr.X",
                "eventType", "notificationType");

        makeCallandNotify();
    }

    private void makeCallandNotify() {
        NotificationService apiService =
                NotifApiClient.getClient().create(NotificationService.class);

        Call<NotificationResponseModel> call = apiService.getNotificationResponse(notificatioNRequestModel);
        call.enqueue(new Callback<NotificationResponseModel>() {
            @Override
            public void onResponse(Call<NotificationResponseModel> call, Response<NotificationResponseModel> response) {
                if (response.isSuccessful()) {
//                    response.body().getCanonical_ids();
                    success = response.body().getSuccess();
                }
            }

            @Override
            public void onFailure(Call<NotificationResponseModel> call, Throwable t) {
                Log.e(TAG, t.getMessage());
            }
        });
    }
}
