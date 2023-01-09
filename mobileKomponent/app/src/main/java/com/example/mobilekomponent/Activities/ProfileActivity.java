package com.example.mobilekomponent.Activities;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mobilekomponent.ApiService;
import com.example.mobilekomponent.R;
import com.example.mobilekomponent.SharedPreferencesHandler;
import com.example.mobilekomponent.models.User;

public class ProfileActivity extends AppCompatActivity {

    TextView firstnameET, lastnameET, usernameET, emailET, passwordET, cellphoneET, dobET;
    Button editProfileBtn;
    private String URL;
    private static Retrofit retrofit = null;
    private SharedPreferencesHandler session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        firstnameET = (EditText) findViewById(R.id.profileFirstname);
        lastnameET = (EditText) findViewById(R.id.profileLastname);
        usernameET = (EditText) findViewById(R.id.profileUsername);
        emailET = (EditText) findViewById(R.id.profileEmail);
        passwordET = (EditText) findViewById(R.id.profilePassword);
        cellphoneET = (EditText) findViewById(R.id.profileCellPhone);
        dobET = (EditText) findViewById(R.id.profileDOB);

        editProfileBtn = (Button) findViewById(R.id.UpdateProfile);

        session = new SharedPreferencesHandler(getApplicationContext());
        int userId = Integer.valueOf(session.getUserId());

        URL = "http://10.0.2.2:8080/";

        getUser(userId);
    }

    public User getUser(int id){

        final User user = new User();
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        ApiService apiService = retrofit.create(ApiService.class);
        Call<User> call = apiService.getUser(id);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                try{
                    response.body();
                    firstnameET.setText(response.body().getFirst_name());
                    lastnameET.setText(response.body().getLast_name());
                    usernameET.setText(response.body().getUsername());
                    emailET.setText(response.body().getEmail());
                    passwordET.setText(response.body().getPassword());
                    cellphoneET.setText(response.body().getCell_phone());
                    dobET.setText(response.body().getDob());
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
            @Override
            public void onFailure(Call<User> call, Throwable throwable) {
                Log.e("Cart Error", throwable.toString());
            }
        });
        Log.v("User", "user"+ user);
        return user;

    }
}
