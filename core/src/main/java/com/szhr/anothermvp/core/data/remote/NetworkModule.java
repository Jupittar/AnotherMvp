package com.szhr.anothermvp.core.data.remote;

import com.google.gson.Gson;
import com.szhr.anothermvp.core.data.remote.interceptor.AuthInterceptor;
import com.szhr.anothermvp.core.data.remote.interceptor.HttpCacheInterceptor;
import com.szhr.anothermvp.core.data.remote.interceptor.HttpLoggingInterceptor;
import com.szhr.anothermvp.core.data.remote.interceptor.HttpOfflineCacheInterceptor;
import com.szhr.anothermvp.core.data.remote.interceptor.RetryInterceptor;
import com.szhr.anothermvp.core.util.AndroidHelper;
import com.szhr.anothermvp.core.util.Constants;
import com.szhr.anothermvp.core.util.LoggerHelper;

import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@SuppressWarnings("unused")
public class NetworkModule {

  @Provides
  @Singleton
  public TmdbService provideTmdbService(Retrofit retrofit) {
    return retrofit.create(TmdbService.class);
  }

  //region Retrofit
  @Provides
  @Singleton
  public Retrofit provideRetrofit(
      GsonConverterFactory converterFactory,
      RxJavaCallAdapterFactory callAdapterFactory,
      OkHttpClient okHttpClient
  ) {
    return new Retrofit
        .Builder()
        .baseUrl(Constants.BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(converterFactory)
        .addCallAdapterFactory(callAdapterFactory)
        .build();
  }

  @Provides
  @Singleton
  public GsonConverterFactory provideGsonConverterFactory(Gson gson) {
    return GsonConverterFactory.create(gson);
  }

  @Provides
  @Singleton
  public Gson provideGson() {
    return new Gson();
  }

  @Provides
  @Singleton
  public RxJavaCallAdapterFactory provideRxjavaCallAdapterFactory() {
    return RxJavaCallAdapterFactory.create();
  }
  //endregion

  //region OkHttpClient
  @Provides
  @Singleton
  public OkHttpClient provideOkHttpClient(
      @Named("isDebug") boolean isDebug,
      Cache cache,
      HttpLoggingInterceptor loggingInterceptor,
      AuthInterceptor authInterceptor,
      HttpCacheInterceptor cacheInterceptor,
      HttpOfflineCacheInterceptor offlineInterceptor
  ) {
    OkHttpClient.Builder builder = new OkHttpClient.Builder()
        .connectTimeout(Constants.NETWORK_CONNECTION_TIMEOUT, TimeUnit.SECONDS)
        .readTimeout(Constants.NETWORK_READ_TIMEOUT, TimeUnit.SECONDS)
        .writeTimeout(Constants.NETWORK_WRITE_TIMEOUT, TimeUnit.SECONDS)
        .addInterceptor(authInterceptor)
        .addNetworkInterceptor(cacheInterceptor)
        .addInterceptor(offlineInterceptor)
        .cache(cache);

    if (isDebug) {
      builder.addInterceptor(loggingInterceptor);
    }

    return builder.build();
  }

  @Provides
  @Singleton
  public Cache provideCache(
      @Named("cacheDir") File cacheDir
  ) {
    Cache cache = null;
    try {
      cache = new Cache(new File(cacheDir.getPath(), "http"), Constants.CACHE_SIZE);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return cache;
  }

  @Provides
  @Singleton
  public HttpLoggingInterceptor provideHttpLoggingInterceptor(LoggerHelper loggerHelper) {
    return new HttpLoggingInterceptor(loggerHelper);
  }

  @Provides
  @Singleton
  public AuthInterceptor provideAuthInterceptor() {
    return new AuthInterceptor();
  }

  @Provides
  @Singleton
  public HttpCacheInterceptor provideCacheInterceptor() {
    return new HttpCacheInterceptor();
  }

  @Provides
  @Singleton
  public HttpOfflineCacheInterceptor provideOfflineCacheInterceptor(
      AndroidHelper androidHelper
  ) {
    return new HttpOfflineCacheInterceptor(androidHelper);
  }

  @Provides
  @Singleton
  public RetryInterceptor provideRetryInterceptor() {
    return new RetryInterceptor();
  }
  //endregion

}
