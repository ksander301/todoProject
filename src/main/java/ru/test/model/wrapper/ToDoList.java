package ru.test.model.wrapper;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import ru.test.model.ToDo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "ToDoList")
public class ToDoList {
    private List<ToDo> toDoList;

    protected ToDoList() {
    }

    public ToDoList(List<ToDo> toDoList) {
        this.toDoList = toDoList;
    }

    @XmlElement(name = "todo")
    @JsonValue
    public List<ToDo> getToDoList() {
        return toDoList;
    }

    public void setToDoList(List<ToDo> toDoList) {
        this.toDoList = toDoList;
    }
}
