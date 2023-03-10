package com.solvd.carina.demo.services;

import com.solvd.carina.demo.dao.models.Users;
import com.solvd.carina.demo.dao.mybatis.OrdersDAO;
import com.solvd.carina.demo.dao.mybatis.UsersDAO;
import com.solvd.carina.demo.services.excpetions.NoUserFundException;

public abstract class AbstractDAO {

   protected UsersDAO usersDAO = new UsersDAO();

   protected OrdersDAO ordersDAO = new OrdersDAO();

   protected void isUserPresent(Users user) {
      if (user == null) {
         throw new NoUserFundException("User is not exist");
      }
   }
}
