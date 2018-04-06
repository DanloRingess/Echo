package org.academiadecodigo.hexaltistas.service;

import org.academiadecodigo.hexaltistas.controller.PlayerNetwork;
import org.academiadecodigo.hexaltistas.model.User;
import org.academiadecodigo.hexaltistas.persistence.dao.PlacesDao;
import org.academiadecodigo.hexaltistas.persistence.dao.UserDao;
import org.academiadecodigo.hexaltistas.persistence.jpa.JpaTransactionManager;


public class UserService {


    private JpaTransactionManager tm;
    private UserDao userDao;
    private PlacesDao placesDao;
    private User user;
    private PlayerNetwork playerNetwork;


    public void getTopShouts(Integer placesId) {

       playerNetwork.sendMsg("getTopShouts" + " " + placesId);

    }


    public void getLastShouts(Integer placesId) {

        playerNetwork.sendMsg("getLastShouts" + " " + placesId);

    }

    public void createShout(String msg, Integer placesId) {

        playerNetwork.sendMsg("createShout" + " " + msg + " " + placesId);

    }


    public void voteUp(Integer idPlace, Integer id) {

      playerNetwork.sendMsg("VoteUp" + " " + idPlace + " " + id);

    }


    public void setPlayerNetwork(PlayerNetwork playerNetwork) {
        this.playerNetwork = playerNetwork;
    }

    public void setDao(UserDao dao) {
        this.userDao = dao;
    }

    public void setTm(JpaTransactionManager tm) {
        this.tm = tm;
    }
}
