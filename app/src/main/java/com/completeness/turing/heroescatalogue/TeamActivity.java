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

    ArrayList<MarvelSuperhero> marvelSuperheroes = new ArrayList<MarvelSuperhero>();
    MarvelSuperheroAdapter marvelSuperheroAdapter = new MarvelSuperheroAdapter(marvelSuperheroes, this);
    ImageView teamWallpaper;
    TextView teamName, teamCreators;

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


        teamWallpaper.setImageResource(R.drawable.cover);
        teamName.setText(teamNameString);
        teamCreators.setText(teamCreatorsString);

        recyclerView = (RecyclerView) findViewById(R.id.superheroesRecyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(linearLayoutManager);

        startView(teamNameString);
    }

    private void startView(String team) {
        ApiClient client = new ApiClient();
        MarvelAPIService service = client.buildRetrofit();

        String[] heroes = TeamCharacters.getHeroes(team);
        for (final String hero : heroes) {
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
                        parseHero(jsonArray);
                        recyclerView.setAdapter(marvelSuperheroAdapter);
                    } catch (JSONException je){
                        je.printStackTrace();
                    }
                }

                @Override
                public void onFailure(retrofit2.Call<JsonObject> call, Throwable t){ }
            });
        }
    }


    private void parseHero(JSONArray jsonArray) throws JSONException{

        for (int i = 0; i < jsonArray.length(); i++){
            JSONObject hero = jsonArray.getJSONObject(i);
            String description = "";
            String name = "";
            name = hero.getString("name");
            if(hero.isNull("description") || hero.getString("description") == ""){
                description = "";
            }else{
                description = hero.getString("description");
            }
            if (description == ""){
                description = "Lo sentimos, este héroe no tiene información, quizá está en un " +
                              "archivo secreto de S.H.I.E.L.D";
            }

            String marvelPicture = "";
            if(!hero.isNull("thumbnail")){
                JSONObject thumbnail = hero.getJSONObject("thumbnail");
                marvelPicture += thumbnail.getString("path");
                marvelPicture += ".";
                marvelPicture += thumbnail.getString("extension");
            }
            marvelSuperheroes.add(new MarvelSuperhero(R.drawable.profile, name, description, marvelPicture));
        }
    }
}
