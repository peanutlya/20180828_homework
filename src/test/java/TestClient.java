import dao.StudentDao;
import dao.StudentDaoA;
import entity.Student;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import utils.MyBatisUtil;

import java.util.List;

public class TestClient {
    @Test
    public void testDelte(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentDaoA mapper = sqlSession.getMapper(StudentDaoA.class);
        int i = mapper.deleteStuById(18L);
        //sqlSession.commit();
        System.out.println(i);
    }
    
    @Test
    public void testUpdate(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentDaoA mapper = sqlSession.getMapper(StudentDaoA.class);
        Student student = mapper.queryStudentById(17L);
        student.setUsername("newname");
        int i = mapper.updateStudent(student);
        sqlSession.commit();
        System.out.println(i);
    }
    @Test
    public void testHot(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentDaoA mapper = sqlSession.getMapper(StudentDaoA.class);
        List<Student> students = mapper.testHot();
        System.out.println(students);
    }
    @Test
    public void testShowAllUser(){
        try(SqlSession sqlSession= MyBatisUtil.getSqlSession()){
            StudentDao mapper = sqlSession.getMapper(StudentDao.class);
            List<Student> studentList = mapper.selectByExample(null);
            for (Student student : studentList) {
                System.out.println(student.toString());
            }
        }
    }
}
