package com.greytoolco.githubrepos.holders;

import android.view.View;

import com.greytoolco.githubrepos.R;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

public class UserViewHolder extends RecyclerView.ViewHolder {

    public AppCompatTextView repoName;
    public AppCompatTextView language;

    public UserViewHolder(View itemView) {
        super(itemView);

        repoName = (AppCompatTextView) itemView.findViewById(R.id.repoName);
        language = (AppCompatTextView) itemView.findViewById(R.id.repoLanguage);

    }
}
