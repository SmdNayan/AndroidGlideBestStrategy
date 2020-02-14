package com.top1solution.androidglideandpicasopractise;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.top1solution.androidglideandpicasopractise.adapter.ImageListAdapter;
import com.top1solution.androidglideandpicasopractise.model.PixaBaysImages;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    private final String API_KEY = "YOUR API KEY"+"&q=car";
    private final String URL = "https://pixabay.com/api/?key=";
    private final String TAG = "MainActivity";

    RecyclerView imageRCV;
    GridLayoutManager gridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageRCV = findViewById(R.id.image_rcv);
        gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        imageRCV.setLayoutManager(gridLayoutManager);

        getImageDataFromPixabay();
    }

    private void getImageDataFromPixabay(){
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.GET, URL+API_KEY, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                String res = response.toString();
                GsonBuilder gsonBuilder = new GsonBuilder();
                Gson gson = gsonBuilder.create();
                PixaBaysImages pixaBaysImages = gson.fromJson(res, PixaBaysImages.class);

                ImageListAdapter imageListAdapter = new ImageListAdapter(getApplicationContext(), pixaBaysImages.getHits());
                imageRCV.setAdapter(imageListAdapter);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "onErrorResponse: " + error );
            }
        });

        queue.add(objectRequest);
    }
}
