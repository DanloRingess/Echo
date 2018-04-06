package org.academiadecodigo.hexaltistas.service;

import org.academiadecodigo.hexaltistas.controller.PlayerNetwork;
import org.academiadecodigo.hexaltistas.model.User;


public class UserService {


    private User user;
    private PlayerNetwork playerNetwork;

    private String top3;
    private String last3;
    private String info;


    public void getTopShouts(Integer placesId) {

        playerNetwork.sendMsg("getTopShouts" + " " + placesId);

    }


    public void getLastShouts(Integer placesId) {

        playerNetwork.sendMsg("getLastShouts" + " " + placesId);

    }

    public String createShout(String msg, Integer placesId) {

        playerNetwork.sendMsg("createShout" + " " + msg + " " + placesId);
        return playerNetwork.getMsg();

    }


    public void voteUp(Integer idPlace, Integer id) {

        playerNetwork.sendMsg("VoteUp" + " " + idPlace + " " + id);

    }


    public void setPlayerNetwork(PlayerNetwork playerNetwork) {
        this.playerNetwork = playerNetwork;
    }


    public void fromServer(String msg) {

        String[] words = msg.split(" ");


        switch (words[0]) {


            case "BESTTOP3":
                top3 = msg;

                break;

            case "LAST3":
                last3 = msg;

                break;

            case "PLACEINFO":
                info=msg;

                break;
        }
    }

    public String getTop3() {
        return top3;
    }

    public String getLast3() {
        return last3;
    }

    public String getInfo() {
        return info;
    }
}
