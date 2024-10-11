package com.mgms.dao;

import com.mgms.model.Class;
import java.util.List;

public interface ClassDao {
    List<Class> findAll();
    Class findById(Long id);
    Class save(Class classObj);
    void deleteById(Long id);
}
