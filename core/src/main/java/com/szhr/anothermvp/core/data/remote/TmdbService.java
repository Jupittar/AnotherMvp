package com.szhr.anothermvp.core.data.remote;

import com.szhr.anothermvp.core.data.entity.Configuration;
import com.szhr.anothermvp.core.data.entity.Movie;
import com.szhr.anothermvp.core.data.entity.RawResponse;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

public interface TmdbService {

  @GET("configuration")
  Observable<Configuration> getApiConfiguration();

  @GET("movie/popular")
  Observable<RawResponse<Movie>> getPopularMovies(@Query("page") int page);

  @GET("movie/{movieId}")
  Observable<Movie> getMovieDetails(@Path("movieId") long movieId);

}
