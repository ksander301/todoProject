package ru.test.dao;

import ru.test.model.Todo;

import java.util.Date;
import java.util.List;

public interface todoDAO {
    Todo getTodoById(Long id);

    List<Todo> getAllTodo();

    List<Todo> getTodoByName(String name);

    List<Todo> getTodoByDate(Date alertDate);

}
