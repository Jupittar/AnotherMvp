package com.szhr.anothermvp.core.ui.movie.popular;

import com.szhr.anothermvp.core.util.AndroidHelper;
import com.szhr.anothermvp.core.util.SchedulerProvider;

import javax.inject.Inject;

import rx.Subscription;

public class PopularMoviesPresenter extends PopularMoviesMvp.Presenter<PopularMoviesMvp.View> {

  @Inject
  PopularMoviesInteractor mInteractor;
  @Inject
  AndroidHelper mAndroidHelper;

  private SchedulerProvider mSchedulerProvider;

  @Inject
  public PopularMoviesPresenter(SchedulerProvider schedulerProvider) {
    mSchedulerProvider = schedulerProvider;
  }

  @Override
  public void showPopularMovies(int page) {
    if (!mAndroidHelper.isApiConfigurationExisted()) {
      Subscription subscription = mInteractor
          .loadApiConfiguration()
          .observeOn(mSchedulerProvider.mainThread())
          .subscribe(configuration -> {
            mAndroidHelper.saveApiConfiguration(configuration);
            handlePopularMovies(page);
          }, throwable -> {
            getView().hideLoading();
            getView().showErrorMessage(throwable);
          });
      addSubscription(subscription);
    } else {
      handlePopularMovies(page);
    }
  }

  private void handlePopularMovies(int page) {
    Subscription subscription = mInteractor
        .loadMovies(page)
        .observeOn(mSchedulerProvider.mainThread())
        .subscribe(movies -> {
//          getView().hideLoading();
//          getView().showMovies(movies);
        }, throwable -> {
          getView().hideLoading();
          getView().showErrorMessage(throwable);
        });
    addSubscription(subscription);
  }
}
