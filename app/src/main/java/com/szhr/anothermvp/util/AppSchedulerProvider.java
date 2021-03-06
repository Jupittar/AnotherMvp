package com.szhr.anothermvp.util;

import com.szhr.anothermvp.core.util.SchedulerProvider;

import javax.inject.Inject;

import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

@SuppressWarnings("unused")
public class AppSchedulerProvider implements SchedulerProvider {

  @Override
  public Scheduler mainThread() {
    return AndroidSchedulers.mainThread();
  }

  @Override
  public Scheduler backgroundThread() {
    return Schedulers.io();
  }

}
