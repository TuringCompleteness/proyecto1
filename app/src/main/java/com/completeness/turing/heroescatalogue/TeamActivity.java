package com.completeness.turing.heroescatalogue;

import android.os.Bundle;
import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.completeness.turing.heroescatalogue.Adapters.MarvelSuperheroAdapter;
import com.completeness.turing.heroescatalogue.GraphicModels.MarvelSuperhero;
import com.completeness.turing.heroescatalogue.GraphicModels.TeamCharacters;
import com.completeness.turing.heroescatalogue.MarvelAPI.ApiClient;
import com.completeness.turing.heroescatalogue.MarvelAPI.Constants;
import com.completeness.turing.heroescatalogue.MarvelAPI.MarvelAPIService;
import com.completeness.turing.heroescatalogue.Model.MarvelCharacter;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class TeamActivity extends Activity {

    ArrayList<MarvelSuperhero> marvelSuperheroes;
    ImageView teamWallpaper;
    TextView teamName, teamCreators;
    MarvelSuperhero marvelSuperhero;

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);

        teamWallpaper = findViewById(R.id.teamWallpaper);
        teamName = findViewById(R.id.teamName);
        teamCreators = findViewById(R.id.teamCreators);
    }

    @Override
    protected void onResume() {
        super.onResume();


        Bundle bundle = getIntent().getExtras();
        String teamNameString = bundle.getString("teamName");
        String teamCreatorsString = bundle.getString("creators");


        teamWallpaper.setImageResource(R.drawable.avengers);
        teamName.setText(teamNameString);
        teamCreators.setText(teamCreatorsString);

        recyclerView = (RecyclerView) findViewById(R.id.superheroesRecyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(linearLayoutManager);

        startView(teamNameString);

    }

    private void startView(String team) {
        marvelSuperheroes = new ArrayList<MarvelSuperhero>();

        ApiClient client = new ApiClient();
        MarvelAPIService service = client.buildRetrofit();

        String[] heroes = TeamCharacters.getHeroes(team);
        for (String hero : heroes) {
            marvelSuperhero = new MarvelSuperhero(R.drawable.avengers, hero, "");
            marvelSuperheroes.add(marvelSuperhero);


            retrofit2.Call<JsonObject> call =
                    service.getDataCharacters(Constants.PUBLIC_KEY, Constants.TS, Constants.HASH,
                                              hero);
            call.enqueue(new retrofit2.Callback<JsonObject>(){
                @Override
                public void onResponse(retrofit2.Call<JsonObject> call,
                                       retrofit2.Response<JsonObject> response ){
                    try {
                        JSONObject jsonObject = new JSONObject(response.body().getAsJsonObject("data").toString());
                        JSONArray jsonArray = jsonObject.getJSONArray("results");
                        parseHero(jsonArray, marvelSuperhero);
                    } catch (JSONException je){
                        je.printStackTrace();
                    }
                }

                @Override
                public void onFailure(retrofit2.Call<JsonObject> call, Throwable t){ }
            });
        }
        MarvelSuperheroAdapter marvelSuperheroAdapter = new MarvelSuperheroAdapter(marvelSuperheroes, this);
        recyclerView.setAdapter(marvelSuperheroAdapter);
    }


    private void parseHero(JSONArray jsonArray, MarvelSuperhero marvelHero) throws JSONException{
        for (int i = 0; i < jsonArray.length(); i++){
            JSONObject hero = jsonArray.getJSONObject(i);
            String description = "";
            if(hero.isNull("description")){
                description = "Lo sentimos, este héroe no tiene información, quizá está en un " +
                        "archivo secreto de S.H.I.E.L.D";
            }else{
                description = hero.getString("description");
            }

            JSONObject thumbnail = hero.getJSONObject("thumbnail");
            String path = thumbnail.getString("path");
            String extension = thumbnail.getString("extension");

            marvelHero.setDescription(description);
        }
    }
}
