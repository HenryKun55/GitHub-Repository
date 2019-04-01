package com.greytoolco.githubrepos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Response;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Toast;

import com.greytoolco.githubrepos.adapters.ReposAdapter;
import com.greytoolco.githubrepos.model.Repos;
import com.greytoolco.githubrepos.model.response.UserResponse;
import com.greytoolco.githubrepos.service.Service;
import com.greytoolco.githubrepos.service.api.UserApi;

import java.io.IOException;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private String user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ButterKnife.bind(this);

        user = getIntent().getStringExtra("User");

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        new ThreadUser().execute();
    }

    private List<Repos> getReposList(String user){
        UserApi userApi = Service.buildService(UserApi.class);

        Call<List<Repos>> call = userApi.getUserRepos(
                user
        );

        List<Repos> result = null;

        try {
            Response<List<Repos>> response = call.execute();
            result = response.body();

            if (response.code() == 200) {
                return result;
            }else{
                return null;
            }

        } catch (IOException e) {
            return null;
        }

    }

    private class ThreadUser extends AsyncTask<String, Void, List<Repos>> {

        @Override
        protected void onPreExecute() { }

        @Override
        protected List<Repos> doInBackground(String ...params) {
            try {
                return getReposList(user);
            }catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(List<Repos> result) {
            if(null != result)
                recyclerView.setAdapter(new ReposAdapter(getBaseContext(), result));
            else
                Toast.makeText(getApplicationContext(), "Falha", Toast.LENGTH_SHORT).show();
        }
    }


}
