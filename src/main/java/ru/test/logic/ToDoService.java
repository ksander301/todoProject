package ru.test.logic;

import ru.test.model.ToDo;

import java.util.Date;
import java.util.List;

public interface ToDoService {
            ToDo getToDoById(Long id);
            List<ToDo> getAllToDo();
            List<ToDo> getToDoByName(String name);
            List<ToDo> getToDoByAlertDate(Date alertDate);
}
