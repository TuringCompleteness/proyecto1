package com.completeness.turing.heroescatalogue.Adapters;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.completeness.turing.heroescatalogue.R;
import com.completeness.turing.heroescatalogue.GraphicModels.MarvelSuperhero;
import com.completeness.turing.heroescatalogue.SuperheroActivity;

import java.util.ArrayList;

public class MarvelSuperheroAdapter extends RecyclerView.Adapter<MarvelSuperheroAdapter.MarvelSuperheroViewHolder> {

    ArrayList<MarvelSuperhero> marvelSuperheroes;
    Activity activity;

    public MarvelSuperheroAdapter(ArrayList<MarvelSuperhero> marvelSuperheroes, Activity activity){
        this.marvelSuperheroes = marvelSuperheroes;
        this.activity = activity;
    }

    @NonNull
    @Override
    public MarvelSuperheroViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_marvelhero,
                viewGroup, false);
        return new MarvelSuperheroViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MarvelSuperheroViewHolder marvelHeroViewHolder, int i) {
        final MarvelSuperhero hero = marvelSuperheroes.get(i);
        if (!(hero.getMarvelPicture() == "")){
            Glide.with(activity).load(hero.getMarvelPicture()).into(marvelHeroViewHolder.heroImageView);
        } else {
            marvelHeroViewHolder.heroImageView.setImageResource(hero.getPicture());
        }
        marvelHeroViewHolder.nameTextView.setText(hero.getName());

        marvelHeroViewHolder.heroCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, SuperheroActivity.class);
                intent.putExtra("heroName", hero.getName());
                intent.putExtra("heroDescription", hero.getDescription());
                intent.putExtra("heroPicture", hero.getMarvelPicture());
                activity.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return marvelSuperheroes.size();
    }

    public class MarvelSuperheroViewHolder extends RecyclerView.ViewHolder{

        private CardView heroCard;
        private ImageView heroImageView;
        private TextView nameTextView;

        public MarvelSuperheroViewHolder(View itemView){
            super(itemView);
            heroCard = (CardView) itemView.findViewById(R.id.cardViewMarvelHero);
            heroImageView = (ImageView) itemView.findViewById(R.id.heroImageView);
            nameTextView = (TextView) itemView.findViewById(R.id.nameTextView);
        }
    }
}
