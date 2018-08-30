import dao.StudentDao;
import entity.Student;
import entity.StudentExample;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import utils.MyBatisUtil;

import java.sql.SQLException;
import java.util.List;

public class TestClient {

    @Test
    public void test1() throws SQLException {
        QueryRunner qr = new QueryRunner();
        String sql = "";
        qr.query(sql, new BeanHandler<Student>(Student.class));
    }

    @Test
    public void test2() {
        StudentDao mapper = MyBatisUtil.getMapper(StudentDao.class);
        System.out.println(mapper.selectByPrimaryKey(10L).toString());
    }

    @Test
    public void test3(){
        StudentDao mapper = MyBatisUtil.getMapper(StudentDao.class);
        StudentExample studentExample=new StudentExample();
        studentExample.setIndex(0);
        studentExample.setPageSize(5);
        List<Student> studentList = mapper.selectByExample(studentExample);
        for (Student student : studentList) {
            System.out.println(student.toString());
        }
    }

    @Test
    public void test4(){
        StudentDao mapper = MyBatisUtil.getMapper(StudentDao.class);
        StudentExample studentExample=new StudentExample();
        long i = mapper.countByExample(null);
        System.out.println(i);
    }
    @Test
    public void test5(){
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            StudentDao mapper = (StudentDao) MyBatisUtil.getMapper(StudentDao.class);

        }
    }

}
