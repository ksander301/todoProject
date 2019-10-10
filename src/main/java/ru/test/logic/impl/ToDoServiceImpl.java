package ru.test.logic.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.test.dao.ToDoDAO;
import ru.test.logic.ToDoService;
import ru.test.model.ToDo;
import ru.test.model.wrapper.ToDoList;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class ToDoServiceImpl implements ToDoService {

    @Autowired
    public ToDoDAO toDoDAO;

    @Override
    public ToDo getToDoById(Long id) {
        return this.toDoDAO.getToDoById(id);
    }

    @Override
    public ToDoList getAllToDo() {
        return this.toDoDAO.getAllToDo();
    }

    @Override
    public List<ToDo> getToDoByName(String name) {
        return this.toDoDAO.getToDoByName(name);
    }

    @Override
    public List<ToDo> getToDoByAlertDate(LocalDate alertDate) {
        return this.toDoDAO.getToDoByAlertDate(alertDate);
    }
}
