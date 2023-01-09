package com.example.mobilekomponent.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.mobilekomponent.Adapters.CartAdapter;
import com.example.mobilekomponent.ApiService;
import com.example.mobilekomponent.R;
import com.example.mobilekomponent.SharedPreferencesHandler;
import com.example.mobilekomponent.models.Cart;
import com.example.mobilekomponent.models.Product;
import com.example.mobilekomponent.models.User;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    private SharedPreferencesHandler session;
    private String URL;
    Button toCheckoutButton;
    private static Retrofit retrofit = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        recyclerView = (RecyclerView) findViewById(R.id.cartRecyclerView);

        session = new SharedPreferencesHandler(getApplicationContext());

        int id = Integer.parseInt(session.getUserId());

        toCheckoutButton = (Button) findViewById(R.id.toCheckoutButton);

        URL = "http://10.0.2.2:8080/";

        getCart(id);

        toCheckoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CartActivity.this, Checkout.class);
                startActivity(intent);
                finish();
            }
        });

    }

    public Cart getCart(int id){

        final Cart cart = new Cart();
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        ApiService apiService = retrofit.create(ApiService.class);
        Call<Cart> call = apiService.getCart(id);
        call.enqueue(new Callback<Cart>() {
            @Override
            public void onResponse(Call<Cart> call, Response<Cart> response) {
                try{
                    response.body();
                    User user = new User();
                    user.setId(response.body().getUser().getId());

                    ArrayList<Product> list = new ArrayList<>();
                    for(int i = 0; i<response.body().getProduct().size(); i++)
                    {
                        Integer id = response.body().getProduct().get(i).getId();
                        String name = response.body().getProduct().get(i).getName();
                        String description = response.body().getProduct().get(i).getDescription();
                        String brand = response.body().getProduct().get(i).getBrand();
                        int quantity = response.body().getProduct().get(i).getQuantity();
                        double price = response.body().getProduct().get(i).getPrice();
                        String scaledImage = response.body().getProduct().get(i).getScaledImage();
                        String fullImage = response.body().getProduct().get(i).getFullImage();
                        list.add(new Product(
                                id,
                                name,
                                description,
                                brand,
                                quantity,
                                price,
                                scaledImage,
                                fullImage
                        ));
                        recyclerView.setLayoutManager(new GridLayoutManager(CartActivity.this, 1));
                        recyclerView.addItemDecoration(new SampleItemDecoration());
                        CartAdapter cartAdapter = new CartAdapter(getApplicationContext(),list);

                        recyclerView.setAdapter(cartAdapter);

                    }



                }
                catch(Exception e){
                    Log.d("onResponse", "Fatal Error Occured In Retrieveing Cart Products" );
                    e.printStackTrace();
                }
            }
            @Override
            public void onFailure(Call<Cart> call, Throwable throwable) {
                Log.e("Cart Error", throwable.toString());
            }
        });
        Log.v("Cart", "cart"+ cart);
        return cart;

    }

    class SampleItemDecoration extends RecyclerView.ItemDecoration {

        Paint paint = new Paint();

        @Override
        public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
            RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();
            for (int i = 0; i < parent.getChildCount(); i++) {
                View view = parent.getChildAt(i);
                paint.setColor(Color.parseColor("#FFFFFF"));
                if (parent.getChildLayoutPosition(view) == RecyclerView.NO_POSITION) {
                    continue;
                }

                // Compute bounds of cell in layout
                Rect bounds = new Rect(
                        layoutManager.getDecoratedLeft(view),
                        layoutManager.getDecoratedTop(view),
                        layoutManager.getDecoratedRight(view),
                        layoutManager.getDecoratedBottom(view)
                );

                // Add space between cell backgrounds
                bounds.inset(2, 2);

                c.drawRect(bounds, paint);
            }
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            outRect.set(10, 10, 10, 10); // Specify spacing between items in grid
        }
    }

    }

