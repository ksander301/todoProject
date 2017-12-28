package ru.test.logic.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.test.dao.ToDoDAO;
import ru.test.logic.ToDoService;
import ru.test.model.ToDo;

import java.util.Date;
import java.util.List;

@Service
public class ToDoServiceImpl implements ToDoService{

    @Autowired
    public ToDoDAO toDoDAO;

    @Override
    public ToDo getToDoById(Long id) {
        return this.toDoDAO.getToDoById(id);
    }

    @Override
    public List<ToDo> getAllToDo() {
        return this.toDoDAO.getAllToDo();
    }

    @Override
    public List<ToDo> getToDoByName(String name) {
        return this.toDoDAO.getToDoByName(name);
    }

    @Override
    public List<ToDo> getToDoByAlertDate(Date alertDate) {
        return this.toDoDAO.getToDoByAlertDate(alertDate);
    }
}
