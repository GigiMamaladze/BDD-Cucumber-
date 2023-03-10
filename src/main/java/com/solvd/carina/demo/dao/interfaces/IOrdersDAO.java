package com.solvd.carina.demo.dao.interfaces;

import com.solvd.carina.demo.dao.models.Orders;

import java.util.List;

public interface IOrdersDAO extends IBaseDAO<Orders> {

    List<Orders> getByUserId(Long userId);
}
