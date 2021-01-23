package com.huawei.service;

import com.huawei.Dao.StudentDao;
import com.huawei.Dao.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentDao studentDao;
    public void addStudent(Student student){
        // Preconditions.checkNotNull(student.)
        studentDao.insert(student);
    }

    public List<Student> getStudentBySno(String sno){
        return studentDao.getStudentBySno(sno);
    }

    public List<Student> getAllStudent(String sortModel){
        return studentDao.getAllStudent(sortModel);
    }

}
