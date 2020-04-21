package ru.zakazcoffee.shop.data.network;

import java.util.List;

import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import ru.zakazcoffee.shop.data.models.Code;
import ru.zakazcoffee.shop.data.models.CoffeeCategory;
import ru.zakazcoffee.shop.data.models.HomePage;
import ru.zakazcoffee.shop.data.models.RequestToken;
import ru.zakazcoffee.shop.data.models.Rules;
import ru.zakazcoffee.shop.data.models.TokenResponse;

public interface NetworkRepository {

    @GET("register.php")
    Single<Response<Void>> createNewAccount(@Query("register") String register,
                                            @Query("login") String login,
                                            @Query("email") String email,
                                            @Query("password") String password,
                                            @Query("scope") String scope);

    @GET("auth2.php")
    Single<Code> getKey(@Query("response_type") String responceType,
                        @Query("redirect_uri") String redirect,
                        @Query("client_id") String clientId,
                        @Query("user_id") String email,
                        @Query("password") String password,
                        @Query("state") String state,
                        @Query("scope") String scope);

    @POST("token.php")
    Single<TokenResponse> sendToken(@Body RequestToken responseType);

    @FormUrlEncoded
    @POST("api.php")
    Single<Void> sendRequest(@Field("method") String method, @Field("token") String token, @Field("client_secret") String clientSecret, @Field("client_id") String clientId);

    @FormUrlEncoded
    @POST("api.php")
    Single<HomePage> getHomePage(@Field("method") String method, @Field("token") String token, @Field("client_secret") String clientSecret, @Field("client_id") String clientId);

    @FormUrlEncoded
    @POST("api.php")
    Single<List<CoffeeCategory>> sendCategoryRequest(@Field("method") String method, @Field("token") String token, @Field("client_secret") String clientSecret, @Field("client_id") String clientId);

    @FormUrlEncoded
    @POST("api.php")
    Single<Void> getAboutInfo(@Field("method") String method, @Field("token") String token, @Field("client_secret") String clientSecret, @Field("client_id") String clientId);

    @FormUrlEncoded
    @POST("api.php")
    Single<Rules> getTotalRules(@Field("method") String method, @Field("token") String token, @Field("client_secret") String clientSecret, @Field("client_id") String clientId);

    @FormUrlEncoded
    @POST("api.php")
    Single<Void> getHistory(@Field("method") String method, @Field("token") String token, @Field("client_secret") String clientSecret, @Field("client_id") String clientId);
//
//    @FormUrlEncoded
//    @POST("api.php")
//    Single<Void> sendRequest(@Field("method") String method, @Field("token") String token, @Field("client_secret") String clientSecret, @Field("client_id") String clientId);
//
//    @FormUrlEncoded
//    @POST("api.php")
//    Single<Void> sendRequest(@Field("method") String method, @Field("token") String token, @Field("client_secret") String clientSecret, @Field("client_id") String clientId);

}
