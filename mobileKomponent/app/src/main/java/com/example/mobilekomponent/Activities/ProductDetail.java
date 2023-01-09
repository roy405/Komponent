package com.example.mobilekomponent.Activities;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.mobilekomponent.ApiService;
import com.example.mobilekomponent.R;
import com.example.mobilekomponent.SharedPreferencesHandler;
import com.example.mobilekomponent.models.Cart;
import com.example.mobilekomponent.models.Orders;
import com.example.mobilekomponent.models.Product;
import com.example.mobilekomponent.models.User;
import com.google.gson.Gson;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class ProductDetail extends AppCompatActivity {

    TextView productNameText, productAmountText, productPriceText, productDescriptionText, quantitySelection;
    ImageView DetailedProductimage;
    ImageButton shareButton, addButton, deductButton;
    Button AddToCart;
    Context context;
    Cart cart;
    Orders orderItems;
    int productQuantity, quantityConvert;
    private SharedPreferencesHandler session;
    private String URL;
    private static Retrofit retrofit = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        Gson gson=new Gson();

        String currentproduct=getIntent().getStringExtra("current_product");

        Product product=gson.fromJson(currentproduct,Product.class);

        Log.d("Current_product_id", String.valueOf(product.getId()));

        session = new SharedPreferencesHandler(getApplicationContext());
        Integer userId = Integer.valueOf(session.getUserId());


        productNameText = (TextView) findViewById(R.id.detailProductName);
        productAmountText = (TextView) findViewById(R.id.DetailedProductAmount);
        productPriceText = (TextView) findViewById(R.id.DetailedProductPrice);
        productDescriptionText = (TextView) findViewById(R.id.DetailedProductDesc);
        quantitySelection = (TextView)findViewById(R.id.QuantityTextView);

        DetailedProductimage = (ImageView) findViewById(R.id.detailProductImage);

        shareButton = (ImageButton) findViewById(R.id.DetailShared);
        addButton = (ImageButton)findViewById(R.id.addButton);
        deductButton = (ImageButton)findViewById(R.id.deductButton);

        Integer productId = product.getId();
        cart = new Cart();
        User cartUser = new User();
        cartUser.setId(userId);

        Product cartProduct = new Product();
        cartProduct.setId(productId);

        List<Product> cartProductList = new ArrayList<Product>();
        cartProductList.add(cartProduct);

        cart.setUser(cartUser);
        cart.setProduct(cartProductList);

        Log.v("Lets see cart", Integer.toString(cart.getUser().getId()) );
        Log.v("Lets see product", Integer.toString(cart.getProduct().get(0).getId()));
        AddToCart = (Button) findViewById(R.id.AddToCart);

        URL = "http://10.0.2.2:8080/";


        String productName = product.getName();
        String productQuantity = Integer.toString(product.getQuantity());
        String price = Double.toString(product.getPrice());
        String description = product.getDescription();
        String productImage = product.getFullImage();

        productNameText.setText(productName);
        productAmountText.setText(productQuantity);
        productPriceText.setText(price);
        productDescriptionText.setText(description);



        Glide.with(this)
                .asBitmap()
                .load(productImage)
                .into(DetailedProductimage);

        AddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendProductToCart(cart);
            }
        });


    }

    public void sendProductToCart(Cart cart){
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        ApiService apiService = retrofit.create(ApiService.class);

        Call<Cart> call = apiService.createCart(cart);
        call.enqueue(new Callback<Cart>() {

            @Override
            public void onResponse(Call<Cart> call, Response<Cart> response) {

                if(response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "Product Added To Cart", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(getApplicationContext(),CartActivity.class);
                    startActivity(i);
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "Error Adding Product To Cart", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Cart> call, Throwable throwable) {
                Toast.makeText(getApplicationContext(), "Error connecting to server", Toast.LENGTH_LONG).show();
            }
        });
    }
}
