package ru.test.dao.impl;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.test.dao.details.TodoRowMapper;
import ru.test.dao.todoDAO;
import ru.test.model.Todo;

import java.util.Date;
import java.util.List;

public class todoDAOImpl implements todoDAO {

    private JdbcTemplate jdbcTemplate;

    public todoDAOImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Todo getTodoById(Long id) {

        String sql = "SELECT * FROM todo WHERE ID= ?";

        Todo todo = (Todo) this.jdbcTemplate.queryForObject(sql, new Object[]{id}, new TodoRowMapper());

        return todo;
    }

    @Override
    public List<Todo> getAllTodo() {

        String sql="SELECT * FROM todo";
        List<Todo> todos = this.jdbcTemplate.query(sql,new TodoRowMapper());
        return todos;
    }

    @Override
    public List<Todo> getTodoByName(String name) {
        String sql = "SELECT * FROM todo WHERE name=?";
        List<Todo> todos =  this.jdbcTemplate.query(sql, new Object[]{name}, new TodoRowMapper());

        return todos;
    }

    @Override
    public List<Todo> getTodoByDate(Date alertDate) {
        String sql = "SELECT * FROM todo WHERE alertDate=?";
        List<Todo> todos =  this.jdbcTemplate.query(sql, new Object[]{alertDate}, new TodoRowMapper());
        return null;
    }
}
