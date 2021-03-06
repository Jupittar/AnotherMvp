package com.szhr.anothermvp.util;

import android.content.Context;

import com.szhr.anothermvp.core.data.entity.Configuration;
import com.szhr.anothermvp.core.data.entity.Images;

import java.util.List;

@SuppressWarnings("unused")
public class TmdbApiConfigurationUtils {

  public static String getSecureBaseUrl(Context context){
    String secureBaseUrl = "";

    Configuration configuration = SharedPreferencesManager.getConfiguration(context);
    if(configuration != null) {
      Images images = configuration.getImages();
      if (images != null) {
        secureBaseUrl = images.getSecureBaseUrl();
      }
    }

    return secureBaseUrl;
  }

  public static String getProfileSize(Context context){
    String profileSize = "";

    Configuration configuration = SharedPreferencesManager.getConfiguration(context);
    if(configuration != null) {
      Images images = configuration.getImages();
      if (images != null) {

        List<String> profileSizes = images.getProfileSizes();
        if (profileSizes != null && profileSizes.size() > 0) {
          if (profileSizes.size() > 1) {
            profileSize = profileSizes.get(profileSizes.size() - 2);
          } else {
            profileSize = profileSizes.get(profileSizes.size() - 1);
          }
        }
      }
    }

    return profileSize;
  }

  public static String getPosterSize(Context context){
    String posterSize = "";

    Configuration configuration = SharedPreferencesManager.getConfiguration(context);
    if(configuration != null) {
      Images images = configuration.getImages();
      if (images != null) {

        List<String> posterSizes = images.getPosterSizes();
        if (posterSizes != null && posterSizes.size() > 0) {
          if (posterSizes.size() > 1) {
            posterSize = posterSizes.get(posterSizes.size() - 2);
          } else {
            posterSize = posterSizes.get(posterSizes.size() - 1);
          }
        }
      }
    }

    return posterSize;
  }

}
