package com.greytoolco.githubrepos.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.greytoolco.githubrepos.R;
import com.greytoolco.githubrepos.holders.UserViewHolder;
import com.greytoolco.githubrepos.model.Repos;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ReposAdapter extends RecyclerView.Adapter<UserViewHolder> {

    private List<Repos> reposList;
    private Context context;

    public ReposAdapter(Context context, List<Repos> reposList){
        this.reposList = reposList;
        this.context = context;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_repos, null);
        UserViewHolder userViewHolder = new UserViewHolder(view);
        return userViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        holder.repoName.setText(reposList.get(position).getName());
        holder.language.setText(reposList.get(position).getLanguage());
    }

    @Override
    public int getItemCount() {
        return this.reposList.size();
    }
}
