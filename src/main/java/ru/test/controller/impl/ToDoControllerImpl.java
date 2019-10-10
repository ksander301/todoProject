package ru.test.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.test.controller.ToDoController;
import ru.test.logic.ToDoService;
import ru.test.model.ToDo;
import ru.test.model.wrapper.ToDoList;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/todo", produces = MediaType.APPLICATION_JSON_VALUE)
public class ToDoControllerImpl implements ToDoController {

    @Autowired
    public ToDoService toDoService;

    @Override
    @RequestMapping(value = "/findById", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ToDo getToDoById(@RequestParam(value = "id") Long id) {
        return this.toDoService.getToDoById(id);
    }

    @Override
    @RequestMapping(method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ToDoList getAllToDo() {

        return this.toDoService.getAllToDo();
    }

    @Override
    @RequestMapping(value = "/findByName", method = RequestMethod.GET, headers = "Accept=application/json",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ToDo> getToDoByName(@RequestParam(value = "name") String name) {
        return this.toDoService.getToDoByName(name);
    }

    @Override
    @RequestMapping("/findByDate")
    public List<ToDo> getToDoByAlertDate(@RequestParam(value = "date") /*@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)*/ LocalDate alertDate) {
        System.out.println("!!!!!          "+alertDate);
        return this.toDoService.getToDoByAlertDate(alertDate);
    }
}
