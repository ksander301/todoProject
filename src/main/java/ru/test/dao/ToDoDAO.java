package ru.test.dao;

import ru.test.model.ToDo;
import ru.test.model.wrapper.ToDoList;

import java.time.LocalDate;
import java.util.List;

public interface ToDoDAO {
    ToDo getToDoById(Long id);

    ToDoList getAllToDo();

    List<ToDo> getToDoByName(String name);

    List<ToDo> getToDoByAlertDate(LocalDate alertDate);
}
