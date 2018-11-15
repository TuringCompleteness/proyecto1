package com.completeness.turing.heroescatalogue;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void cardViewClick(View view) {
        Intent intent = new Intent(getApplicationContext(), Team.class);
        intent.putExtra("teamId", view.getId());
        startActivity(intent);
    }
}
