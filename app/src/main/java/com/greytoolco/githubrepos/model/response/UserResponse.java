package com.greytoolco.githubrepos.model.response;

import com.greytoolco.githubrepos.model.Repos;

import java.util.List;

public class UserResponse extends ApiResponse{

    private String login;
    private String avatar_url;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserResponse{");
        sb.append("login='").append(login).append('\'');
        sb.append(", avatar_url='").append(avatar_url).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
