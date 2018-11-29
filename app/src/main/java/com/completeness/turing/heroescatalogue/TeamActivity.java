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

import java.util.ArrayList;

public class TeamActivity extends Activity {

    ArrayList<MarvelSuperhero> marvelSuperheroes;
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

        String[] heroes = TeamCharacters.getHeroes(team);
        for (String hero : heroes) {
            MarvelSuperhero marvelSuperhero = new MarvelSuperhero(R.drawable.avengers, hero, "");
            marvelSuperheroes.add(marvelSuperhero);
        }
        MarvelSuperheroAdapter marvelSuperheroAdapter = new MarvelSuperheroAdapter(marvelSuperheroes, this);
        recyclerView.setAdapter(marvelSuperheroAdapter);




    }
}
