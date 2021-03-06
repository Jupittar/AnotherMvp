package com.szhr.anothermvp.core.data.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@SuppressWarnings("unused")
public class Movie {

  @SerializedName("adult")
  private boolean adult;
  @SerializedName("backdrop_path")
  private String backdropPath;
  @SerializedName("belongs_to_collection")
  private Object belongsToCollection;
  @SerializedName("budget")
  private int budget;
  @SerializedName("homepage")
  private String homepage;
  @SerializedName("id")
  private int id;
  @SerializedName("imdb_id")
  private String imdbId;
  @SerializedName("original_language")
  private String originalLanguage;
  @SerializedName("original_title")
  private String originalTitle;
  @SerializedName("overview")
  private String overview;
  @SerializedName("popularity")
  private double popularity;
  @SerializedName("poster_path")
  private Object posterPath;
  @SerializedName("release_date")
  private String releaseDate;
  @SerializedName("revenue")
  private int revenue;
  @SerializedName("runtime")
  private int runtime;
  @SerializedName("status")
  private String status;
  @SerializedName("tagline")
  private String tagline;
  @SerializedName("video")
  private boolean video;
  @SerializedName("vote_average")
  private double voteAverage;
  @SerializedName("vote_count")
  private int voteCount;
  @SerializedName("genres")
  private List<Genres> genres;
  @SerializedName("production_companies")
  private List<Genres> productionCompanies;
  @SerializedName("production_countries")
  private List<ProductionCountries> productionCountries;
  @SerializedName("spoken_languages")
  private List<SpokenLanguages> spokenLanguages;

  public boolean isAdult() {
    return adult;
  }

  public void setAdult(boolean adult) {
    this.adult = adult;
  }

  public String getBackdropPath() {
    return backdropPath;
  }

  public void setBackdropPath(String backdropPath) {
    this.backdropPath = backdropPath;
  }

  public Object getBelongsToCollection() {
    return belongsToCollection;
  }

  public void setBelongsToCollection(Object belongsToCollection) {
    this.belongsToCollection = belongsToCollection;
  }

  public int getBudget() {
    return budget;
  }

  public void setBudget(int budget) {
    this.budget = budget;
  }

  public String getHomepage() {
    return homepage;
  }

  public void setHomepage(String homepage) {
    this.homepage = homepage;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getImdbId() {
    return imdbId;
  }

  public void setImdbId(String imdbId) {
    this.imdbId = imdbId;
  }

  public String getOriginalLanguage() {
    return originalLanguage;
  }

  public void setOriginalLanguage(String originalLanguage) {
    this.originalLanguage = originalLanguage;
  }

  public String getOriginalTitle() {
    return originalTitle;
  }

  public void setOriginalTitle(String originalTitle) {
    this.originalTitle = originalTitle;
  }

  public String getOverview() {
    return overview;
  }

  public void setOverview(String overview) {
    this.overview = overview;
  }

  public double getPopularity() {
    return popularity;
  }

  public void setPopularity(double popularity) {
    this.popularity = popularity;
  }

  public Object getPosterPath() {
    return posterPath;
  }

  public void setPosterPath(Object posterPath) {
    this.posterPath = posterPath;
  }

  public String getReleaseDate() {
    return releaseDate;
  }

  public void setReleaseDate(String releaseDate) {
    this.releaseDate = releaseDate;
  }

  public int getRevenue() {
    return revenue;
  }

  public void setRevenue(int revenue) {
    this.revenue = revenue;
  }

  public int getRuntime() {
    return runtime;
  }

  public void setRuntime(int runtime) {
    this.runtime = runtime;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getTagline() {
    return tagline;
  }

  public void setTagline(String tagline) {
    this.tagline = tagline;
  }

  public boolean isVideo() {
    return video;
  }

  public void setVideo(boolean video) {
    this.video = video;
  }

  public double getVoteAverage() {
    return voteAverage;
  }

  public void setVoteAverage(double voteAverage) {
    this.voteAverage = voteAverage;
  }

  public int getVoteCount() {
    return voteCount;
  }

  public void setVoteCount(int voteCount) {
    this.voteCount = voteCount;
  }

  public List<Genres> getGenres() {
    return genres;
  }

  public void setGenres(List<Genres> genres) {
    this.genres = genres;
  }

  public List<Genres> getProductionCompanies() {
    return productionCompanies;
  }

  public void setProductionCompanies(List<Genres> productionCompanies) {
    this.productionCompanies = productionCompanies;
  }

  public List<ProductionCountries> getProductionCountries() {
    return productionCountries;
  }

  public void setProductionCountries(List<ProductionCountries> productionCountries) {
    this.productionCountries = productionCountries;
  }

  public List<SpokenLanguages> getSpokenLanguages() {
    return spokenLanguages;
  }

  public void setSpokenLanguages(List<SpokenLanguages> spokenLanguages) {
    this.spokenLanguages = spokenLanguages;
  }

}
