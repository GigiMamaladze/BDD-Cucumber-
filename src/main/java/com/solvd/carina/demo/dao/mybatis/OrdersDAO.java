package com.solvd.carina.demo.dao.mybatis;

import com.solvd.carina.demo.dao.interfaces.IOrdersDAO;
import com.solvd.carina.demo.dao.models.Orders;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class OrdersDAO {

    public Orders getById(Long id) {
        SqlSession session = MybatisUtil.getSqlSessionFactory().openSession();
        try {
            IOrdersDAO iOrdersDAO = session.getMapper(IOrdersDAO.class);
            return iOrdersDAO.getById(id);
        } finally {
            session.rollback();
            session.close();
        }
    }

    public List<Orders> getAllOrders() {
        SqlSession session = MybatisUtil.getSqlSessionFactory().openSession();
        try {
            IOrdersDAO iOrdersDAO = session.getMapper(IOrdersDAO.class);
            return iOrdersDAO.getAll();
        } finally {
            session.rollback();
            session.close();
        }
    }

    public List<Orders> getByUserId(Long userId) {
        SqlSession session = MybatisUtil.getSqlSessionFactory().openSession();
        try {
            IOrdersDAO iOrdersDAO = session.getMapper(IOrdersDAO.class);
            return iOrdersDAO.getByUserId(userId);
        } finally {
            session.rollback();
            session.close();
        }
    }
}
