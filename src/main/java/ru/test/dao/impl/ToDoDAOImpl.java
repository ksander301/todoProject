package ru.test.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameterValue;
import org.springframework.stereotype.Repository;
import ru.test.dao.details.ToDoResultSetExtractor;
import ru.test.dao.details.ToDoRowMapper;
import ru.test.dao.ToDoDAO;
import ru.test.model.ToDo;
import ru.test.model.wrapper.ToDoList;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;
import java.util.TimeZone;

@Repository
/*@ComponentScan(basePackages = {"ru.test.config", "ru.test.dao", "ru.test.logic", "ru.test.model"})
@EnableAutoConfiguration*/
public class ToDoDAOImpl implements ToDoDAO {

    public static final String QUERY_BY_ID = " SELECT * FROM todo WHERE ID= ?";
    public static final String QUERY_BY_NAME = "SELECT * FROM todo WHERE name= ?";
    public static final String QUERY_ALL = "SELECT * FROM todo";
    public static final String QUERY_BY_ALERTDATE = "SELECT * FROM todo WHERE ALERTDATE= ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    @SuppressWarnings({"unchecked", "rawtypes"})
    public ToDo getToDoById(Long id) {

        ToDo toDo = this.jdbcTemplate.query(QUERY_BY_ID, new Object[]{id}, new ToDoResultSetExtractor());


        return toDo;
    }

    @Override
    public ToDoList getAllToDo() {

        List<ToDo> toDos = this.jdbcTemplate.query(QUERY_ALL, new ToDoRowMapper());
        return new ToDoList(toDos);
    }

    @Override
    public List<ToDo> getToDoByName(String name) {

        List<ToDo> toDos = this.jdbcTemplate.query(QUERY_BY_NAME, new Object[]{name}, new ToDoRowMapper());
        return toDos;
    }

    @Override
    public List<ToDo> getToDoByAlertDate(LocalDate alertDate) {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));

        List<ToDo> toDos = this.jdbcTemplate.query(QUERY_BY_ALERTDATE, new Object[]{alertDate}, new ToDoRowMapper());
        return toDos;
    }
}
