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
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mobilekomponent.ApiService;
import com.example.mobilekomponent.R;
import com.example.mobilekomponent.SharedPreferencesHandler;
import com.example.mobilekomponent.models.Address;
import com.example.mobilekomponent.models.Cart;
import com.example.mobilekomponent.models.Orders;
import com.example.mobilekomponent.models.Payment;
import com.example.mobilekomponent.models.User;

public class Checkout extends AppCompatActivity {
    EditText street1ET, street2ET, stateET, cityET, countryET, zipcodeET;
    EditText paymentmethodET, cardtypET, cardNumberET, cardExpieryET, cvvET;
    Button placeOrderBtn;
    Orders orders;
    Payment payment;
    User user;
    Cart cart;
    Address address;
    private SharedPreferencesHandler session;
    private String URL;
    private static Retrofit retrofit = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        street1ET       = (EditText) findViewById(R.id.street1ET);
        street2ET       = (EditText) findViewById(R.id.street2ET);
        stateET         = (EditText) findViewById(R.id.stateET);
        cityET          = (EditText) findViewById(R.id.cityET);
        zipcodeET       = (EditText) findViewById(R.id.zipCodeET);
        countryET       = (EditText) findViewById(R.id.countryET);

        paymentmethodET = (EditText) findViewById(R.id.PaymentMethodET);
        cardtypET       = (EditText) findViewById(R.id.CardTypeET);
        cardNumberET    = (EditText) findViewById(R.id.CardNumberET);
        cardExpieryET   = (EditText) findViewById(R.id.CardExpieryET);
        cvvET           = (EditText) findViewById(R.id.CVVET);

        placeOrderBtn   = (Button) findViewById(R.id.PlaceOrder);

        URL = "http://10.0.2.2:8080/";


        placeOrderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                session = new SharedPreferencesHandler(getApplicationContext());

                int id = Integer.parseInt(session.getUserId());
                cart = new Cart();
                user = new User();

                user.setId(id);

                cart.setUser(user);

                address = new Address();

                address.setStreet1(street1ET.getText().toString());
                address.setStreet2(street2ET.getText().toString());
                address.setState(stateET.getText().toString());
                address.setCity(cityET.getText().toString());
                address.setZip_code(zipcodeET.getText().toString());
                address.setCountry(countryET.getText().toString());

                payment = new Payment();

                payment.setPayment_method(paymentmethodET.getText().toString());
                payment.setCard_type(cardtypET.getText().toString());
                payment.setCard_number(cardNumberET.getText().toString());
                payment.setCard_expiery(cardExpieryET.getText().toString());
                payment.setCard_cvv(cvvET.getText().toString());

                orders = new Orders();

                orders.setCart(cart);
                orders.setAddress(address);
                orders.setPayment(payment);
                createOrder(orders);
            }
        });


    }

    public void createOrder (Orders orders){
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        ApiService apiService = retrofit.create(ApiService.class);

        Call<Orders> call = apiService.createOrder(orders);
        call.enqueue(new Callback<Orders>() {

            @Override
            public void onResponse(Call<Orders> call, Response<Orders> response) {

                if(response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "Order Successfully Placed", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(getApplicationContext(),CartActivity.class);
                    startActivity(i);
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "Something went wrong, please try again", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Orders> call, Throwable throwable) {
                Toast.makeText(getApplicationContext(), "Error connecting to server", Toast.LENGTH_LONG).show();
            }
        });
    }

    }

