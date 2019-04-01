package com.greytoolco.githubrepos;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.greytoolco.githubrepos.model.response.UserResponse;
import com.greytoolco.githubrepos.service.Service;
import com.greytoolco.githubrepos.service.api.UserApi;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Response;

public class MainActivity extends Activity {

    @BindView(R.id.gitUser)
    EditText gitUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }

    private UserResponse getUser(String user){
        UserApi userApi = Service.buildService(UserApi.class);

        Call<UserResponse> call = userApi.getUser(
                user
        );

        UserResponse result = null;

        try {
            Response<UserResponse> response = call.execute();
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

    private class ThreadUser extends AsyncTask<String, Void, UserResponse> {

        @Override
        protected void onPreExecute() { }

        @Override
        protected UserResponse doInBackground(String ...params) {
            try {
                return getUser(gitUser.getText().toString());
            }catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(UserResponse result) {
            if(null != result)
                nextPage(result.getLogin(), result.getAvatar_url());
            else
                Toast.makeText(getApplicationContext(), "Usuário não encontrado", Toast.LENGTH_SHORT).show();
        }
    }

    @OnClick(R.id.searchGitUser)
    public void search(){
        new ThreadUser().execute();
    }

    private void nextPage(String user, String avatar_url){
        Intent intent = new Intent(getBaseContext(), HomeActivity.class);
        intent.putExtra("user", user);
        intent.putExtra("avatar_url", avatar_url);
        startActivity(intent);
    }
}
