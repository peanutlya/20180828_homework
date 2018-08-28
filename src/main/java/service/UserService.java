package service;

import dao.UserDao;
import entity.PageBean;
import entity.User;
import utils.MyBatisUtil;

import java.sql.SQLException;
import java.util.List;

public class UserService {


    public void addUser(User user) throws SQLException {
        UserDao userDao=MyBatisUtil.getSqlSession().getMapper(UserDao.class);
        userDao.addUser(user);
    }

    public User queryCountByKeywords(User currentUser) throws SQLException {
        UserDao userDao=MyBatisUtil.getSqlSession().getMapper(UserDao.class);
        return userDao.queryCountByKeywords(currentUser);
    }

    public List<User> showAllUser() throws SQLException {
        UserDao userDao=MyBatisUtil.getSqlSession().getMapper(UserDao.class);
        return  userDao.showAllUser();
    }
    public int deleteUserById(Long id) throws SQLException {
        UserDao userDao=MyBatisUtil.getSqlSession().getMapper(UserDao.class);
        return userDao.deleteUserById(id);
    }

    public User queryUserById(Long id) throws SQLException{
        UserDao userDao=MyBatisUtil.getSqlSession().getMapper(UserDao.class);
        return userDao.queryUserById(id);
    }
    public int updateUser(User currentUser)throws SQLException{
        UserDao userDao=MyBatisUtil.getSqlSession().getMapper(UserDao.class);
        return userDao.updateUser(currentUser);
    }

    public List<User> queryUserByName(String name) throws SQLException{
        UserDao userDao=MyBatisUtil.getSqlSession().getMapper(UserDao.class);
        return userDao.queryUserByName(name);
    }
    public boolean checkUsername(String username) throws SQLException{
        UserDao userDao=MyBatisUtil.getSqlSession().getMapper(UserDao.class);
        Long isExit=userDao.checkUsername(username);
        return  isExit>0?true:false;
    }
    public PageBean findPageBean(int currentPage,int currentCount) throws SQLException{
        UserDao userDao=MyBatisUtil.getSqlSession().getMapper(UserDao.class);
        PageBean pageBean=new PageBean();
        pageBean.setCurrentPage(currentPage);
        pageBean.setCurrentCount(currentCount);
        int totalCount=userDao.getTotalCount();
        int totalPage=(int)Math.ceil(1.0*totalCount/currentCount);
        pageBean.setTotalPage(totalPage);
        pageBean.setTotalCount(totalCount);
        int index=(currentPage-1)*currentCount;
        List<User> userList=userDao.findUserListForPageBean(index,currentCount);
        pageBean.setPageList(userList);
        return  pageBean;
    }

    public PageBean findPageBean(int currentPage,int currentCount,String name) throws SQLException{
        UserDao userDao=MyBatisUtil.getSqlSession().getMapper(UserDao.class);
        PageBean pageBean=new PageBean();
        pageBean.setCurrentPage(currentPage);
        pageBean.setCurrentCount(currentCount);
        int totalCount=userDao.queryUserByName(name).size();
        int totalPage=(int)Math.ceil(1.0*totalCount/currentCount);
        pageBean.setTotalPage(totalPage);
        pageBean.setTotalCount(totalCount);
        int index=(currentPage-1)*currentCount;
        List<User> userList=userDao.findUserListForPageBean(index,currentCount,name);
        pageBean.setPageList(userList);
        return  pageBean;
    }

}
