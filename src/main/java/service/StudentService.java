package service;

import dao.StudentDao;
import dao.StudentDaoA;
import entity.Student;
import entity.StudentExample;
import org.apache.ibatis.session.SqlSession;
import utils.MyBatisUtil;

import java.sql.SQLException;
import java.util.List;

public class StudentService {
    public List<Student> showAllUser() throws SQLException {
        try(SqlSession sqlSession= MyBatisUtil.getSqlSession()){
            StudentDao mapper = sqlSession.getMapper(StudentDao.class);
            return mapper.selectByExample(null);
        }
        //StudentDaoA stuDao=MyBatisUtil.getSqlSession().getMapper(StudentDaoA.class);
        //return  stuDao.showAllStudent();
    }
    public void addStudent(Student student) throws SQLException {
        try(SqlSession sqlSession= MyBatisUtil.getSqlSession()){
            StudentDao mapper = sqlSession.getMapper(StudentDao.class);
            mapper.insert(student);
            sqlSession.commit();
        }
      /*  SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentDaoA stuDao=sqlSession.getMapper(StudentDaoA.class);
        stuDao.addStudent(student);
        sqlSession.commit();*/
    }
    public int deleteStuById(Long id) throws SQLException {
        int i=0;
        try(SqlSession sqlSession= MyBatisUtil.getSqlSession()){
            StudentDao mapper = sqlSession.getMapper(StudentDao.class);
            i = mapper.deleteByPrimaryKey(id);
            sqlSession.commit();
        }
       /* try(SqlSession sqlSession= MyBatisUtil.getSqlSession()){
            StudentDaoA mapper = sqlSession.getMapper(StudentDaoA.class);
             StudentDaoA stuDao = sqlSession.getMapper(StudentDaoA.class);
             i = stuDao.deleteStuById(id);
             sqlSession.commit();
        }*/
        return i;
    }
    public Student queryStudentById(Long id) throws SQLException{
        try(SqlSession sqlSession= MyBatisUtil.getSqlSession()){
            StudentDao mapper = sqlSession.getMapper(StudentDao.class);
            return mapper.selectByPrimaryKey(id);
        }
       /* StudentDaoA stuDao=MyBatisUtil.getSqlSession().getMapper(StudentDaoA.class);
        return stuDao.queryStudentById(id);*/
    }

    public int updateStu(Student currentStu)throws SQLException{
        try(SqlSession sqlSession= MyBatisUtil.getSqlSession()){
            StudentDao mapper = sqlSession.getMapper(StudentDao.class);
            int i = mapper.updateByPrimaryKeySelective(currentStu);
            sqlSession.commit();
            return i;
        }
        /*SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentDaoA stuDao=sqlSession.getMapper(StudentDaoA.class);
        int i=stuDao.updateStudent(currentStu);
        sqlSession.commit();
        return i;*/
    }

    public List<Student> queryStudentByName(String name) throws SQLException{
        try(SqlSession sqlSession= MyBatisUtil.getSqlSession()){
            StudentDao mapper = sqlSession.getMapper(StudentDao.class);
            StudentExample example=new StudentExample();
            example.createCriteria().andUsernameLike("%"+name+"%");
            return mapper.selectByExample(example);
        }
       /* StudentDaoA stuDao=MyBatisUtil.getSqlSession().getMapper(StudentDaoA.class);
        return stuDao.queryStudentByName(name);*/
    }
}
