package dao;

import entity.Student;

import java.util.List;

public interface StudentDao {

    List<Student> showAllStudent();

    void addStudent(Student student);

    int deleteStuById(Long id);

    Student queryStudentById(Long id);

    int updateStudent(Student currentStu);

    List<Student> queryStudentByName(String name);

    List<Student> testHot();

}
