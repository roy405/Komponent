package com.example.mobilekomponent.Activities;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mobilekomponent.ApiService;
import com.example.mobilekomponent.R;
import com.example.mobilekomponent.models.User;

public class RegistrationActivity extends AppCompatActivity {

    EditText firstName,lastName,username, email, password,cellphone, dob;
    Button signup, dbPurge;
    User user=new User();
    private String URL;
    private static Retrofit retrofit = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registraion);

        firstName=(EditText)findViewById(R.id.first_name);
        lastName=(EditText)findViewById(R.id.last_name);
        username=(EditText)findViewById(R.id.username);
        email=(EditText)findViewById(R.id.email);
        password=(EditText)findViewById(R.id.pass);
        cellphone=(EditText)findViewById(R.id.cell_phone);
        dob=(EditText)findViewById(R.id.DOB);


        signup=(Button)findViewById(R.id.CustSignup);
        dbPurge=(Button)findViewById(R.id.bDatabase);

        URL = "http://10.0.2.2:8080/";

        signup.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) { //Button Click listener to save data to user when registering

//                user= new User(firstname.getText().toString(),lastname.getText().toString(),username.getText().toString()email.getText().toString(),password.getText().toString(),dob.getText().toString());
//                user.setFirst_name(firstname.getText().toString());
//                user.setLast_name(lastname.getText().toString());
//                user.setUsername(username.getText().toString());
//                user.setEmail(email.getText().toString());
//                user.setPassword(password.getText().toString());
//                user.setCell_phone(cellphone.getText().toString());
//                user.setDob(dob.getText().toString());
//                user.save();
                registration(firstName.getText().toString(), lastName.getText().toString(), username.getText().toString(), email.getText().toString(), password.getText().toString(), cellphone.getText().toString(), dob.getText().toString());
                Intent intent = new Intent(RegistrationActivity.this, MainActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(),"Registration Successful" , Toast.LENGTH_LONG).show();

            }
        });


    }

    public void registration(String firstName, String lastName, String username, String email, String password, String cellphone, String dob) {

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
        Call<User> call = apiService.registerUser(firstName, lastName, username, email, password, cellphone, dob);
        call.enqueue(new Callback<User>() {

            @Override
            public void onResponse(Call<User> call, Response<User> response) {

                if(response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "Registration Successful", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(i);
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "User already exists", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable throwable) {
                Toast.makeText(getApplicationContext(), "Error connecting to server", Toast.LENGTH_LONG).show();
            }
        });
    }
}
