package com.example.RestAPI_Start.repository;

import com.example.RestAPI_Start.entity.TodoEntity;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepo extends CrudRepository<TodoEntity, Long> {

}
