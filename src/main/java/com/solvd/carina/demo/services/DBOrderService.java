package com.solvd.carina.demo.services;

import com.solvd.carina.demo.dao.models.Orders;
import com.solvd.carina.demo.dao.models.Users;

import java.util.List;

public class DBOrderService extends AbstractDAO {

    public List<Orders> getByUser(Users users) {
        List<Orders> orders = ordersDAO.getByUserId(users.getId());
        isUserPresent(users);
        return orders;
    }
}
