package ru.test.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.test.controller.ToDoController;
import ru.test.logic.ToDoService;
import ru.test.model.ToDo;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/todo")
public class ToDoControllerImpl implements ToDoController {

    @Autowired
    public ToDoService toDoService;

    @Override
    @RequestMapping("/findById")
    public ToDo getToDoById(@RequestParam(value = "id") Long id) {
        return this.toDoService.getToDoById(id);
    }

    @Override
    @RequestMapping( method = RequestMethod.GET)
    public List<ToDo> getAllToDo() {
        return this.toDoService.getAllToDo();
    }

    @Override
    @RequestMapping(method = RequestMethod.GET, value = "/findByName",
            headers = "Accept=application/xml")
    public List<ToDo> getToDoByName(@RequestParam(value = "name") String name) {
        return this.toDoService.getToDoByName(name);
    }

    @Override
    @RequestMapping("/findByDate")
    public List<ToDo> getToDoByAlertDate(@RequestParam(value = "adate") Date alertDate) {
        return this.toDoService.getToDoByAlertDate(alertDate);
    }
}
