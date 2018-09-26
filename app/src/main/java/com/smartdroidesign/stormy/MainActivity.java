package com.smartdroidesign.stormy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String apiKey = "82b36425b0116d78b9b2889a50dcc459";
        double latitude = 37.8267;
        double longitude = -122.4233;

        String foreCastURL = "https://api.darksky.net/forecast/"
                + apiKey + "/" + latitude + "," + longitude;

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(foreCastURL)
                .build();

        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    Log.v(TAG, response.body().string());
                    if (response.isSuccessful()) {
                    } else {
                        alertUserAboutError();
                    }
                } catch (IOException e) {
                    Log.e(TAG, "IO Exception caught: ", e);
                }
            }
        });

        Log.d(TAG, "Main UI code is running");

    }

    private void alertUserAboutError() {
        AlertDialogFragment dialog =  new AlertDialogFragment();
        dialog.show(getSupportFragmentManager(), "error_dialog");
    }
}
