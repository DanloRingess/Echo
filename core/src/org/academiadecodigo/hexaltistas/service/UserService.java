package org.academiadecodigo.hexaltistas.service;

import org.academiadecodigo.hexaltistas.model.Places;
import org.academiadecodigo.hexaltistas.model.Shout;
import org.academiadecodigo.hexaltistas.model.User;
import org.academiadecodigo.hexaltistas.persistence.TransactionException;
import org.academiadecodigo.hexaltistas.persistence.dao.PlacesDao;
import org.academiadecodigo.hexaltistas.persistence.dao.UserDao;
import org.academiadecodigo.hexaltistas.persistence.jpa.JpaTransactionManager;


import java.util.LinkedList;
import java.util.List;

public class UserService {

    private JpaTransactionManager tm;
    private UserDao userDao;
    private PlacesDao placesDao;
    private User user;

    public List<String> getTopShouts(Integer placesId) {

        tm.beginRead();
        List<Shout> shoutList = placesDao.findTop3();

        List<String> topShouts = new LinkedList<String>();

        int numEchos = 2;
        int i = 0;

        while (i != numEchos) {
            if ((shoutList.size() - (i + 1)) >= 0) {

                topShouts.add(shoutList.get(i).getMsg());
            }

            i++;
        }

        tm.commit();
        return topShouts;

    }


    public List<String> getLastShouts(Integer placesId) {

        tm.beginRead();
        List<Shout> shoutList = placesDao.findById(placesId).getShoutList();

        List<String> lastShouts = new LinkedList<String>();

        int numOfEchos = 4;
        int i = 0;

        while (i != numOfEchos) {
            if ((shoutList.size() - (i + 1)) >= 0) {
                lastShouts.add(shoutList.get(shoutList.size() - (i + 1)).getMsg());
            }

            i++;
        }

        tm.commit();
        return lastShouts;

    }

    public void createShout(String msg, Integer placesId) {
        User user1 = user.getUser();

        tm.beginRead();
        Places place = placesDao.findById(placesId);
        tm.commit();

        if (user1.getVoted().containsKey(place)) {
            return;
        }
        try {
            tm.beginWrite();

            Shout shout = new Shout();
            shout.setMsg(msg);

            place.addShout(shout);
            placesDao.saveOrUpdate(place);

            user1.addShout(shout, place);
            userDao.saveOrUpdate(user);

            tm.commit();

        } catch (TransactionException rb) {
            tm.rollback();

        }

    }

    public String getPlaceName(Integer id) {
        Places place = placesDao.findById(id);
        return place.getName();
    }


    public void setDao(UserDao dao) {
        this.userDao = dao;
    }

    public void setTm(JpaTransactionManager tm) {
        this.tm = tm;
    }
}
