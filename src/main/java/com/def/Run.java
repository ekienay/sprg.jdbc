package com.def;

import com.def.connection.InitDatabase;
import com.def.dao.GroupDAO;
import com.def.dao.StudentDAO;
import com.def.model.Group;
import com.def.model.Student;
import com.def.service.GroupService;
import com.def.service.StudentService;

import java.util.List;

public class Run {
    public static void main(String[] args) {

        InitDatabase initDatabase = new InitDatabase();
        initDatabase.init();
        StudentDAO dao = new StudentService(initDatabase.getSource());
        GroupDAO groupDAO = new GroupService(initDatabase.getSource());
        List<Group> groups = groupDAO.join();
        List<Student> list = dao.findByGroupId(1);
        groups.forEach(System.out::println);


    }
}
