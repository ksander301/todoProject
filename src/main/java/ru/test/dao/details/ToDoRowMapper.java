package ru.test.dao.details;

import org.springframework.jdbc.core.RowMapper;
import ru.test.model.Todo;

import java.sql.ResultSet;
import java.sql.SQLException;

@SuppressWarnings("rawtypes")
public class TodoRowMapper implements RowMapper<Todo> {

    @Override
    public Todo mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Todo todo = new Todo();
        todo.setId(resultSet.getLong("ID"));
        todo.setName(resultSet.getString("NAME"));
        todo.setAlertDate(resultSet.getDate("ALERTDATE"));
        todo.setDescription(resultSet.getString("DESCRIPTION"));
        return todo;
    }
}