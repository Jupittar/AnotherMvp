package com.szhr.anothermvp.core.data.remote.interceptor;

import com.szhr.anothermvp.core.util.Constants;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

@SuppressWarnings("unused")
public class AuthInterceptor implements Interceptor {
  @Override
  public Response intercept(Chain chain) throws IOException {
    Request request = chain.request();
    HttpUrl url = request.url();
    HttpUrl newUrl = url.newBuilder()
        .addQueryParameter("api_key", Constants.API_KEY)
        .build();
    Request newRequest = request.newBuilder()
        .url(newUrl)
        .build();

    return chain.proceed(newRequest);
  }
}
