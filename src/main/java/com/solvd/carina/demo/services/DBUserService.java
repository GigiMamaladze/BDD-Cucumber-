package com.solvd.carina.demo.services;

import com.solvd.carina.demo.dao.models.Users;

public class DBUserService extends AbstractDAO {

    public Users getUserByName(String userName) {
        Users users = usersDAO.getByUserName(userName);
        isUserPresent(users);
        return users;
    }
}
