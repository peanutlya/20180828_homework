package service;

import dao.StudentDao;
import entity.PageBean;
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
        try(SqlSession sqlSession= MyBatisUtil.getSqlSession()){
            StudentDao mapper = sqlSession.getMapper(StudentDao.class);
            int i = mapper.deleteByPrimaryKey(id);
            sqlSession.commit();
            return i;
        }
       /* try(SqlSession sqlSession= MyBatisUtil.getSqlSession()){
            StudentDaoA mapper = sqlSession.getMapper(StudentDaoA.class);
             StudentDaoA stuDao = sqlSession.getMapper(StudentDaoA.class);
             i = stuDao.deleteStuById(id);
             sqlSession.commit();
        }*/
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

    public PageBean findStudentForPageBean(int currentPage, int pageSize, String keywords) throws SQLException{
        PageBean pageBean=new PageBean();
        pageBean.setCurrentPage(currentPage);
        pageBean.setPageSize(pageSize);
        //int totalCount=manageDao.getTotalEmployeeInfoForPageBean(condition);
        if(keywords==null){
            keywords="";
        }
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            StudentDao mapper = (StudentDao) MyBatisUtil.getMapper(StudentDao.class);
            StudentExample studentExample = new StudentExample();
            StudentExample.Criteria criteria = studentExample.createCriteria().andUsernameLike("%" + keywords + "%");
            StudentExample.Criteria criteria1 = studentExample.createCriteria().andPasswordLike("%" + keywords + "%");
            studentExample.or(criteria1);
            int totalCount = (int) mapper.countByExample(studentExample);

            pageBean.setTotalCount(totalCount);
            int totalPage = (int) Math.ceil(1.0 * totalCount / pageSize);
            pageBean.setTotalPage(totalPage);
            //List<EmployeeInfo> employeeInfoList = manageDao.findEmployeeInfoForPageBean(currentPage, pageSize, condition);

            int index = (currentPage - 1) * pageSize;
            studentExample.setIndex(index);
            studentExample.setPageSize(pageSize);
            List<Student> studentList = mapper.selectByExample(studentExample);
           /* StudentExample studentExample2=new StudentExample();
            studentExample2.setIndex(index);
            studentExample2.setPageSize(pageSize);*/
            pageBean.setPageList(studentList);
            sqlSession.close();
            return pageBean;
        }

    }
}
