package com.example.mobilekomponent.Activities;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mobilekomponent.ApiService;
import com.example.mobilekomponent.R;
import com.example.mobilekomponent.SharedPreferencesHandler;

public class MainActivity extends AppCompatActivity {

    EditText username,password;
    TextView signUP;
    Button Login;
    private SharedPreferencesHandler session;
    public static String port = ":8080";
    private String URL;
    private static Retrofit retrofit = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        signUP = (TextView) findViewById(R.id.signup);
        Login = (Button) findViewById(R.id.login);

        username = (EditText) findViewById(R.id.user);
        password = (EditText) findViewById(R.id.pass);



        session = new SharedPreferencesHandler(getApplicationContext());

        URL = "http://10.0.2.2:8080/";

        signUP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, RegistrationActivity.class);
                startActivity(intent);
            }
        });

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login(username.getText().toString(), password.getText().toString());
            }
        });
    }

    public void login(String username, String password) {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        ApiService apiService = retrofit.create(ApiService.class);

//        Map<String, String> data = new HashMap<>();
//        data.put("username", username);
//        data.put("password", password);
        Call<String> call = apiService.login(username,password);
        Log.v("motherfucking", username);
        call.enqueue(new Callback<String>() {

            @Override
            public void onResponse(Call<String> call, Response<String> response) {

                if(response.isSuccessful()) {
                    session.setUserId(response.body());
                    Toast.makeText(getApplicationContext(), "Login Successful, Welcome ", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(getApplicationContext(),HomeActivity.class);
                    startActivity(i);
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect userna me/password Combination", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable throwable) {
                Toast.makeText(getApplicationContext(), "Error connecting to server", Toast.LENGTH_LONG).show();
            }
        });
    }

       /* public void validate (String userEmail, String userPassword)
        { //Method to validate user when logging in
            List<User> users = User.listAll(User.class);
            for (User user : users) {
                if ((userEmail.equals(user.getEmail())) && (userPassword.equals(user.getPassword()))) {
                    Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_LONG).show();

                    SharedPreferences shared = getSharedPreferences("Mypref", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = shared.edit();
                    editor.putString("email", userEmail);
                    editor.putString("pass", userPassword);
                    editor.apply();

                   // Intent intent = new Intent(MainActivity.this, NavigationDrawerActivity.class);
                   // startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect username/password", Toast.LENGTH_LONG).show();
                }
            }

        } */
    }

