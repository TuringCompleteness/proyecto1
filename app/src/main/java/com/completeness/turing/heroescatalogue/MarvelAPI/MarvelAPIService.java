package com.completeness.turing.heroescatalogue.MarvelAPI;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface MarvelAPIService {
    @GET(Constants.ENDPOINT)
    Call<JsonObject> getDataCharacters(@Query("apikey") String apikey,
                                       @Query("ts") int ts,
                                       @Query("hash") String hash,
                                       @Query("name") String name);

}
