package ru.zakazcoffee.shop.data.network;

import io.reactivex.rxjava3.core.Maybe;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface NetworkRepository {

    @POST("/api/v1/login")
    Maybe<Response<Object>> login(@Body String gatewayAuthorizeRequest);

    @POST("/api/v1/register")
    Maybe<Response<Object>> createNewAccount(@Body String gatewayAuthorizeRequest);
}
