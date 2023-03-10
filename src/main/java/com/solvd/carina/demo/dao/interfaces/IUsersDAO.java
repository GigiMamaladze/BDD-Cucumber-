package com.solvd.carina.demo.dao.interfaces;

import com.solvd.carina.demo.dao.models.Users;

import java.util.List;

public interface IUsersDAO extends IBaseDAO<Users> {

    List<Users> getAllUsers();

    Users getByUserName(String userName);
}
