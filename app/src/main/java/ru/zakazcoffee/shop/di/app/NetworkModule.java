package ru.zakazcoffee.shop.di.app;

import androidx.annotation.NonNull;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.zakazcoffee.shop.data.network.NetworkRepository;

@Module
class NetworkModule {

    private static final String BASE_URL = "https://mobileapp.zakazcoffee.ru/server/";
    private static final int TIMEOUT = 30;

    @NonNull
    @Singleton
    @Provides
    NetworkRepository provideNetworkRepository(){
        return new Retrofit.Builder().baseUrl(BASE_URL)
                .client(getOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(NetworkRepository.class);
    }

    private OkHttpClient getOkHttpClient() {
        return new OkHttpClient.Builder()
                .readTimeout(TIMEOUT, TimeUnit.SECONDS)
                .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
                .addInterceptor(createLoggingInterceptor())
                .build();
    }

    private HttpLoggingInterceptor createLoggingInterceptor() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);
        return loggingInterceptor;
    }
}
