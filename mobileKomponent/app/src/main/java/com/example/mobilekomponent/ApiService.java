package com.example.mobilekomponent;

import com.example.mobilekomponent.models.Cart;
import com.example.mobilekomponent.models.Orders;
import com.example.mobilekomponent.models.Product;
import com.example.mobilekomponent.models.User;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface ApiService {

    //User Related Access Points
    @GET("/users")
    Call<List<User>> getUsers();

    @GET("/users/{id}")
    Call<User> getUser(@Path("id") int id);

    @POST("/users")
    Call<User> registerUser(@Query("firstName") String firstName, @Query("lastName") String lastName, @Query("username") String username, @Query("email") String email, @Query("password") String password, @Query("cellphone") String cellphone, @Query("dob") String dob);

    @PUT("/users")
    Call<User> updateUser(@QueryMap Map<String, String> body);


    //Login related Access points
    @POST("/login")
    Call<String> login(@Query("username") String username, @Query("password") String password);

    //Products related Access points
    @GET("/products")
    Call<List<Product>> getProducts();


    //Cart related Access points
    @GET("cart")
    Call<List<Cart>> getAllCarts();

    @GET("cart/{id}")
    Call<Cart> getCart(@Path("id") int id);

    @POST("cart")
    Call<Cart> createCart(@Body Cart cart);

    //Orders related Access points
    @GET("orders")
    Call <List<Orders>> getOrders();

    @POST("orders")
    Call<Orders> createOrder(@Body Orders orders);

}

