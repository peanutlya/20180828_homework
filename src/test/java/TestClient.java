import dao.StudentDao;
import entity.Student;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import utils.MyBatisUtil;

import java.util.List;

public class TestClient {
    @Test
    public void testDelte(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentDao mapper = sqlSession.getMapper(StudentDao.class);
        int i = mapper.deleteStuById(18L);
        //sqlSession.commit();
        System.out.println(i);
    }
    
    @Test
    public void testUpdate(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentDao mapper = sqlSession.getMapper(StudentDao.class);
        Student student = mapper.queryStudentById(17L);
        student.setUsername("newname");
        int i = mapper.updateStudent(student);
        sqlSession.commit();
        System.out.println(i);
    }
    @Test
    public void testHot(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentDao mapper = sqlSession.getMapper(StudentDao.class);
        List<Student> students = mapper.testHot();
        System.out.println(students);
    }
}
