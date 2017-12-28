package ru.test.dao.impl;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.SqlParameterValue;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ru.test.dao.details.ToDoRowMapper;
import ru.test.dao.ToDoDAO;
import ru.test.model.ToDo;

import java.sql.Types;
import java.util.Date;
import java.util.List;

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
    public ToDo getToDoById(Long id) {

        ToDo toDo = this.jdbcTemplate.queryForObject(QUERY_BY_ID, new Object[]{id}, ToDo.class);
        return toDo;
    }

    @Override
    public List<ToDo> getAllToDo() {

        List<ToDo> toDos = this.jdbcTemplate.query(QUERY_ALL, new ToDoRowMapper());
        return toDos;
    }

    @Override
    public List<ToDo> getToDoByName(String name) {

        List<ToDo> toDos = this.jdbcTemplate.query(QUERY_BY_NAME, new Object[]{name}, new ToDoRowMapper());
        return toDos;
    }

    @Override
    public List<ToDo> getToDoByAlertDate(Date alertDate) {

        List<ToDo> toDos = this.jdbcTemplate.query(QUERY_BY_ALERTDATE, new Object[]{alertDate}, new ToDoRowMapper());
        return toDos;
    }
}
