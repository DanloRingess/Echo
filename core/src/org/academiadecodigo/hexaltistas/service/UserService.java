package org.academiadecodigo.hexaltistas.service;

import org.academiadecodigo.hexaltistas.model.User;
import org.academiadecodigo.hexaltistas.persistence.dao.UserDao;
import org.academiadecodigo.hexaltistas.persistence.jpa.JpaTransactionManager;

import java.util.List;

public class UserService {

    private JpaTransactionManager tm;
    private UserDao userDao;

    public List<String> getTopShouts() {
        return null;
    }

    public List<String> getLastShouts() {
        return null;
    }

    public void createShout(User user, String shout) {

    }

    public void setDao(UserDao dao) {
        this.userDao = dao;
    }

    public void setTm(JpaTransactionManager tm) {
        this.tm = tm;
    }
}
