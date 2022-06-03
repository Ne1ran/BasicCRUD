package com.example.RestAPI_Start.model;

import com.example.RestAPI_Start.entity.UserEntity;
import org.apache.catalina.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserModel {
    private Long id;
    private String username;

    private List<Todo> todos;

    public static UserModel toModel(UserEntity userEntity){
        UserModel model = new UserModel();
        model.setId(userEntity.getId());
        model.setUsername(userEntity.getUsername());
        model.setTodos(userEntity.getTodos().stream().map(Todo::toModel).collect(Collectors.toList()));
        return model;
    }

    public UserModel() {
    }

    public List<Todo> getTodos() {
        return todos;
    }

    public void setTodos(List<Todo> todos) {
        this.todos = todos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
