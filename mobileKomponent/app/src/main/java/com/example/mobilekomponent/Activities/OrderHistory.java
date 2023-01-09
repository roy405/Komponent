package com.example.mobilekomponent.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Retrofit;

import android.os.Bundle;

import com.example.mobilekomponent.R;
import com.example.mobilekomponent.SharedPreferencesHandler;

public class OrderHistory extends AppCompatActivity {

    RecyclerView recyclerView;
    private SharedPreferencesHandler session;
    private String URL;
    private static Retrofit retrofit = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_history);
    }
}
