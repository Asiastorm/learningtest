package com.huawei.Dao;

import com.huawei.Dao.model.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao {
    int deleteByPrimaryKey(Long id);

    int insert(Student record);

    int insertSelective(Student record);

    List<Student> getStudentBySno(String id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    List<Student> getAllStudent(String sortModel);
}