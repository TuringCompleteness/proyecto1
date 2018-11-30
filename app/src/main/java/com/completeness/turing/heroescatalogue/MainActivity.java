package com.completeness.turing.heroescatalogue;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.completeness.turing.heroescatalogue.Adapters.MarvelTeamAdapter;
import com.completeness.turing.heroescatalogue.GraphicModels.MarvelTeam;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ArrayList<MarvelTeam> teams;

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.teamsRecyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(linearLayoutManager);

        startTeams();
        startAdapter();
    }

    public void cardViewClick(View view) {
        Intent intent = new Intent(getApplicationContext(), TeamActivity.class);
        intent.putExtra("teamId", view.getId());
        startActivity(intent);
    }


    public void startAdapter(){
        MarvelTeamAdapter marvelTeamAdapter = new MarvelTeamAdapter(teams, this);
        recyclerView.setAdapter(marvelTeamAdapter);
    }

    public void startTeams(){
        teams = new ArrayList<MarvelTeam>();

        teams.add(new MarvelTeam(R.drawable.avengers_logo, "Avengers",
                                "Stan Lee", Color.parseColor("#A33127")));
        teams.add(new MarvelTeam(R.drawable.xmen_logo,  "X Men",
                                "Stan Lee", Color.parseColor("#F00000")));
        teams.add(new MarvelTeam(R.drawable.fantastic_logo, "Fantastic Four",
                                "Stan Lee", Color.parseColor("#005393")));
        teams.add(new MarvelTeam(R.drawable.guardians_logo, "Guardians of The Galaxy",
                                "Stan Lee", Color.parseColor("#5A1B8E")));
        teams.add(new MarvelTeam(R.drawable.defenders_logo, "The Defenders",
                                "Stan Lee", Color.parseColor("#000000")));
        teams.add(new MarvelTeam(R.drawable.inhumans_logo, "Inhumans",
                                "Stan Lee", Color.parseColor("#00A5BC")));
        teams.add(new MarvelTeam(R.drawable.runaways_logo, "Runaways",
                                "Stan Lee", Color.parseColor("#A33127")));
        teams.add(new MarvelTeam(R.drawable.hire_logo, "Heroes for Hire",
                                "Stan Lee", Color.parseColor("#A33127")));
    }
}
