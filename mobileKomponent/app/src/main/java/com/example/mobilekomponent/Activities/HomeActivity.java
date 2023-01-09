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
import android.widget.Toast;

import com.example.mobilekomponent.Adapters.ProductListAdapter;
import com.example.mobilekomponent.ApiService;
import com.example.mobilekomponent.R;
import com.example.mobilekomponent.SharedPreferencesHandler;
import com.example.mobilekomponent.models.Product;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;


public class HomeActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    private SharedPreferencesHandler session;
    public static String port = ":8080";
    private String URL;
    private static Retrofit retrofit = null;
    private static final String TAG = "HomeActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        recyclerView = (RecyclerView) findViewById(R.id.productListRV);

        session = new SharedPreferencesHandler(getApplicationContext());

        URL = "http://10.0.2.2:8080/";

        ArrayList<Product> products = getAllProducts();


    }
    

    public ArrayList<Product> getAllProducts() {

        final ArrayList<Product> products = new ArrayList<>();

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        ApiService apiService = retrofit.create(ApiService.class);
        Call<List<Product>> call = apiService.getProducts();
        call.enqueue(new Callback<List<Product>>() {
            //call.enqueue(new retrofit2.Callback<List<Product>>() {

            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                try{
                    products.addAll(response.body());
                    Log.v(TAG, "LOGS" + products.size());
                    ArrayList<Product> list = new ArrayList<>();
                    for(int i = 0; i< products.size(); i++){
                        Integer id = products.get(i).getId();
                        String name =products.get(i).getName();

                        Log.d("kotha ki clear",name);

                        String description = products.get(i).getDescription();
                        String brand = products.get(i).getBrand();
                        int quantity = products.get(i).getQuantity();
                        double price = products.get(i).getPrice();
                        String scaledImage= products.get(i).getScaledImage();
                        String fullImage = products.get(i).getFullImage();

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

                        Log.v("Hello", list.get(0).getId().toString());

                        recyclerView.setLayoutManager(new GridLayoutManager(HomeActivity.this, 2));
                        recyclerView.addItemDecoration(new SampleItemDecoration());

                        ProductListAdapter productListAdapter=new ProductListAdapter(getApplicationContext(),list);

                        recyclerView.setAdapter(productListAdapter);

                    }

                }
                catch(Exception e){
                    Log.d("onResponse", "Fatal Error Occured In Retrieveing Products" );
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable throwable) {
                Log.e(TAG, throwable.toString());
            }
        });
        Log.v(TAG, ""+ products);
        return products;

    }

    class SampleItemDecoration extends RecyclerView.ItemDecoration {

        Paint paint = new Paint();

        @Override
        public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
            RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();
            for (int i = 0; i < parent.getChildCount(); i++) {
                View view = parent.getChildAt(i);
                paint.setColor(Color.parseColor("#8BAAC3"));
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
