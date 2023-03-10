package com.solvd.carina.demo.dao.mybatis;

import com.solvd.carina.demo.dao.interfaces.IUsersDAO;
import com.solvd.carina.demo.dao.models.Users;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UsersDAO {

    public Users getById(Long id) {
        SqlSession session = MybatisUtil.getSqlSessionFactory().openSession();
        try {
            IUsersDAO iUsersDAO = session.getMapper(IUsersDAO.class);
            return iUsersDAO.getById(id);
        } finally {
            session.rollback();
            session.close();
        }
    }

    public List<Users> getAllUsers() {
        SqlSession session = MybatisUtil.getSqlSessionFactory().openSession();
        try {
            IUsersDAO iUsersDAO = session.getMapper(IUsersDAO.class);
            return iUsersDAO.getAllUsers();
        } finally {
            session.rollback();
            session.close();
        }
    }

    public Users getByUserName(String userName) {
        SqlSession session = MybatisUtil.getSqlSessionFactory().openSession();
        try {
            IUsersDAO iUsersDAO = session.getMapper(IUsersDAO.class);
            return iUsersDAO.getByUserName(userName);
        } finally {
            session.rollback();
            session.close();
        }
    }
}
