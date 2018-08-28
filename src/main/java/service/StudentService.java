package service;

import dao.StudentDao;
import entity.Student;
import org.apache.ibatis.session.SqlSession;
import utils.MyBatisUtil;

import java.sql.SQLException;
import java.util.List;

public class StudentService {
    public List<Student> showAllUser() throws SQLException {
        StudentDao stuDao=MyBatisUtil.getSqlSession().getMapper(StudentDao.class);
        return  stuDao.showAllStudent();
    }
    public void addStudent(Student student) throws SQLException {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();

        StudentDao stuDao=sqlSession.getMapper(StudentDao.class);
        stuDao.addStudent(student);
        sqlSession.commit();
    }
    public int deleteStuById(Long id) throws SQLException {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();

        StudentDao stuDao = sqlSession.getMapper(StudentDao.class);
        int i = stuDao.deleteStuById(id);
        sqlSession.commit();
        return i;
    }
    public Student queryStudentById(Long id) throws SQLException{
        StudentDao stuDao=MyBatisUtil.getSqlSession().getMapper(StudentDao.class);
        return stuDao.queryStudentById(id);
    }

    public int updateStu(Student currentStu)throws SQLException{
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentDao stuDao=sqlSession.getMapper(StudentDao.class);
        int i=stuDao.updateStudent(currentStu);
        sqlSession.commit();
        return i;
    }

    public List<Student> queryStudentByName(String name) throws SQLException{
        StudentDao stuDao=MyBatisUtil.getSqlSession().getMapper(StudentDao.class);
        return stuDao.queryStudentByName(name);
    }
}
