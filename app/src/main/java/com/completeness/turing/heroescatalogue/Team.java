package com.completeness.turing.heroescatalogue;

import android.os.Bundle;
import android.app.Activity;
import android.widget.ImageView;
import android.widget.TextView;

public class Team extends Activity {

    ImageView teamWallpaper;
    TextView teamName, teamCreators;

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
        switch (bundle.getInt("teamId")) {
            case R.id.avengersCV:
                teamWallpaper.setImageResource(R.drawable.avengers);
                teamName.setText(R.string.avengersName);
                teamCreators.setText(R.string.avengersCreators);
                break;
            case R.id.XMenCV:
                teamWallpaper.setImageResource(R.drawable.xmen);
                teamName.setText(R.string.XMenName);
                teamCreators.setText(R.string.XMenCreators);
                break;
            case R.id.FantasticFourCV:
                teamWallpaper.setImageResource(R.drawable.fantasticfour);
                teamName.setText(R.string.FantasticFourName);
                teamCreators.setText(R.string.FantasticFourCreators);
                break;
            case R.id.GuardiansGalaxyCV:
                teamWallpaper.setImageResource(R.drawable.guardiansgalaxy);
                teamName.setText(R.string.GuardiansGalaxyName);
                teamCreators.setText(R.string.GuardiansGalaxyCreators);
                break;
        }
    }

    private void getInfo(String team) {

    }

}
