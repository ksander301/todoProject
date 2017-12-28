package ru.test.dao.details;

import org.springframework.jdbc.core.RowMapper;
import ru.test.model.ToDo;

import java.sql.ResultSet;
        import java.sql.SQLException;

@SuppressWarnings("rawtypes")
public class ToDoRowMapper implements RowMapper<ToDo> {

    @Override
    public ToDo mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        ToDo toDo = new ToDo();
        toDo.setId(resultSet.getLong("ID"));
        toDo.setName(resultSet.getString("NAME"));
        toDo.setAlertDate(resultSet.getDate("ALERTDATE"));
        toDo.setDescription(resultSet.getString("DESCRIPTION"));
        return toDo;
    }
}