package ru.test.controller;

import ru.test.model.ToDo;
import ru.test.model.wrapper.ToDoList;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface ToDoController {
    ToDo getToDoById(Long id);

    ToDoList getAllToDo();

    List<ToDo> getToDoByName(String name);

    List<ToDo> getToDoByAlertDate(LocalDate alertDate);

}
