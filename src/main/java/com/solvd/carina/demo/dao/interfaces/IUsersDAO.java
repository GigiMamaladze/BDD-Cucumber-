package com.solvd.carina.demo.dao.interfaces;

import com.solvd.carina.demo.dao.models.Users;

public interface IUsersDAO extends IBaseDAO<Users> {

    Users getByUserName(String userName);
}
