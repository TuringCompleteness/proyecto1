package com.completeness.turing.heroescatalogue;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;



public class SuperheroActivity extends Activity {

    private ImageView heroImage;
    private TextView heroName;
    private TextView heroDescription;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero);

        heroImage = findViewById(R.id.heroImageView);
        heroName = findViewById(R.id.heroName);
        heroDescription = findViewById(R.id.heroDescription);


    }

    @Override
    protected void onResume() {
        super.onResume();

        Bundle bundle = getIntent().getExtras();
        heroName.setText(bundle.getString("heroName"));

        String heroDescriptionString = bundle.getString("heroDescription");
        if (heroDescriptionString == "")
            heroDescription.setText("Lo sentimos, este héroe no tiene información, quizá está en un " +
                    "archivo secreto de S.H.I.E.L.D");
        else
            heroDescription.setText(heroDescriptionString);

        String heroPicture = bundle.getString("heroPicture");
        Glide.with(this).load(heroPicture).into(heroImage);
    }


}
