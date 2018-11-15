package com.completeness.turing.heroescatalogue;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SuperheroService {

    String API_KEY = "a72628f78722cd483cfe5caaf0097859";

    String API_ROUTE = "https://gateway.marvel.com:443/v1/public/characters?apikey=" + API_KEY;

    @GET(API_ROUTE)
    Call<List<Superhero>> getSuperhero(@Query("name") String superHeroName);
}
