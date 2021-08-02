package com.def.dao;

import com.def.model.Group;

import java.util.List;

public interface GroupDAO extends DAO<Group>{

    List<Group> join();
}
