package com.def.dao;

import com.def.model.Student;

import java.util.List;

public interface StudentDAO extends DAO<Student> {

    List<Student> findByGroupId(int groupId);
}
