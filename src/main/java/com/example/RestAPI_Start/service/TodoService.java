package com.example.RestAPI_Start.service;

import com.example.RestAPI_Start.entity.TodoEntity;
import com.example.RestAPI_Start.entity.UserEntity;
import com.example.RestAPI_Start.model.Todo;
import com.example.RestAPI_Start.repository.TodoRepo;
import com.example.RestAPI_Start.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    @Autowired
    private TodoRepo todoRepo;

    @Autowired
    private UserRepo userRepo;

    public Todo createTodo(TodoEntity todoEntity, Long userId){
        UserEntity user = userRepo.findById(userId).get();
        todoEntity.setUserEntity(user);
        return Todo.toModel(todoRepo.save(todoEntity));
    }

    public Todo completeTodo(Long id){
        TodoEntity todo = todoRepo.findById(id).get();
        todo.setCompleted(!todo.isCompleted());
        return Todo.toModel(todoRepo.save(todo));
    }
}
