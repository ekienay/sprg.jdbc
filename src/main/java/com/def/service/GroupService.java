package com.def.service;

import com.def.dao.GroupDAO;
import com.def.model.Group;
import com.def.model.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class GroupService implements GroupDAO {


    //language=sql
    final String join = "SELECT grp.id, std.id as std_id, std.first_name, std.last_name, grp.grp_name from grp left join std on grp.id = std.group_id";

    JdbcTemplate template;
    Student student = null;
    Group group = null;
    List<Group> groups = new ArrayList<>();

    public GroupService(DataSource dataSource){
        this.template = new JdbcTemplate(dataSource);
    }

    RowMapper<Group> rowMapper = (resultSet, i) -> {

        int grpId = resultSet.getInt("id");

        if (group == null || grpId != group.getId()){
            group = new Group();
            group.setId(grpId);
            group.setGroup_name(resultSet.getString("grp_name"));
        }

        int stdId = resultSet.getInt("std_id");

        if (!resultSet.wasNull() && student != null && student.getId() != stdId){
            student = new Student();
            student.setId(stdId);

            if (group.getStudents() == null){
                group.setStudents(new ArrayList<Student>());
            }

            group.getStudents().add(student);
            student.setFirstName(resultSet.getString("first_name"));
            student.setLastName(resultSet.getString("last_name"));
        }

            return group;
    };

    @Override
    public void save(Group group) {

    }

    @Override
    public void update(Group group) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Group find(int id) {
        return null;
    }

    @Override
    public List<Group> findAll() {
        return null;
    }

    @Override
    public List<Group> join() {
        return template.query(join,rowMapper);
    }
}
