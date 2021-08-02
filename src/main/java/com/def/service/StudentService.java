package com.def.service;

import com.def.dao.StudentDAO;
import com.def.model.Group;
import com.def.model.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.List;


public class StudentService implements StudentDAO {

    //language=sql
    private final String getByGroupId = "SELECT * FROM std where group_id = ?";
    //language=sql
    private final String getAll = "SELECT * FROM std";
    //language=sql
    private final String getById = "SELECT * FROM std where id = ?";

    private JdbcTemplate template;

    private Student student = null;

    private RowMapper<Student> rowMapper = (resultSet, i) -> {
        student = new Student();
        student.setId(resultSet.getInt("id"));
        student.setFirstName(resultSet.getString("first_name"));
        student.setLastName(resultSet.getString("last_name"));
        student.setGroupId(resultSet.getInt("group_id"));
        return student;
    };



    public StudentService(DataSource dataSource){
        this.template = new JdbcTemplate(dataSource);
    }

    @Override
    public void save(Student student) {

    }

    @Override
    public void update(Student student) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Student find(int id) {
        return template.queryForObject(getById,rowMapper,id);
    }

    @Override
    public List<Student> findAll() {
        return template.query(getAll,rowMapper);
    }

    @Override
    public List<Student> findByGroupId(int groupId) {
        return template.query(getByGroupId,rowMapper,groupId);
    }
}
