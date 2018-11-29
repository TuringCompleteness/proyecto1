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

import com.completeness.turing.heroescatalogue.GraphicModels.MarvelTeam;
import com.completeness.turing.heroescatalogue.R;
import com.completeness.turing.heroescatalogue.TeamActivity;

import java.util.ArrayList;

public class MarvelTeamAdapter extends RecyclerView.Adapter<MarvelTeamAdapter.MarvelTeamViewHolder> {

    ArrayList<MarvelTeam> teams;
    Activity activity;

    public MarvelTeamAdapter(ArrayList<MarvelTeam> teams, Activity activity){
        this.teams = teams;
        this.activity = activity;
    }

    @NonNull
    @Override
    public MarvelTeamViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_marvelteam,
                                        viewGroup, false);
        return new MarvelTeamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MarvelTeamViewHolder marvelTeamViewHolder, int i) {
        final MarvelTeam team = teams.get(i);
        marvelTeamViewHolder.teamImageView.setImageResource(team.getTeamPicture());
        marvelTeamViewHolder.nameTextView.setText(team.getTeamName());
        marvelTeamViewHolder.creatorsTextView.setText("Creadores: " + team.getCreators());

        marvelTeamViewHolder.teamCard.setCardBackgroundColor(team.getColor());

        marvelTeamViewHolder.teamCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, TeamActivity.class);
                intent.putExtra("teamName", team.getTeamName());
                intent.putExtra("creators", team.getCreators());
                activity.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return teams.size();
    }

    public class MarvelTeamViewHolder extends RecyclerView.ViewHolder{

        private CardView teamCard;
        private ImageView teamImageView;
        private TextView nameTextView;
        private TextView creatorsTextView;

        public MarvelTeamViewHolder(View itemView){
            super(itemView);
            teamCard = (CardView) itemView.findViewById(R.id.cardViewMarvelTeam);
            teamImageView = (ImageView) itemView.findViewById(R.id.teamImageView);
            nameTextView = (TextView) itemView.findViewById(R.id.nameTextView);
            creatorsTextView = (TextView) itemView.findViewById(R.id.creatorsTextView);
        }
    }
}
