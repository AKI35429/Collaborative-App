package com.example.opencodecollaborative21app.adapters;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.opencodecollaborative21app.R;
import com.example.opencodecollaborative21app.classes.Participant;

import java.util.ArrayList;

public class ParticipantAdapter extends RecyclerView.Adapter<ParticipantAdapter.MyViewHolder>{

    private ArrayList<Participant> participants=new ArrayList<Participant>();

    public ParticipantAdapter(ArrayList<Participant> participants) {
        this.participants = participants;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view =inflater.inflate(R.layout.participant_item,parent,false);
        return new ParticipantAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Participant curr=participants.get(position);
        holder.participantName.setText(curr.getName());
        holder.participantGithub.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(curr.getGitId()));
            view.getContext().startActivity(browserIntent);
            }
        });
        holder.participantFb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(curr.getFacebookId()));
                view.getContext().startActivity(browserIntent);
            }
        });
        holder.participantTwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(curr.getTwitterId()));
                view.getContext().startActivity(browserIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return participants.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView participantName;
        ImageButton participantFb, participantGithub, participantTwitter;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            participantName=(TextView) itemView.findViewById(R.id.ParticipantName);
            participantFb=(ImageButton) itemView.findViewById(R.id.ParticipantFB);
            participantGithub=(ImageButton) itemView.findViewById(R.id.ParticipantGithub);
            participantTwitter=(ImageButton) itemView.findViewById(R.id.ParticipantTwitter);
        }
    }
}
