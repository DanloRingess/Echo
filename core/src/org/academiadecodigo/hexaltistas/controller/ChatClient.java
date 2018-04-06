package org.academiadecodigo.hexaltistas.controller;

import org.academiadecodigo.hexaltistas.service.UserService;

import java.io.IOException;

public class ChatClient {

    public static void main(String[] args) {

        PlayerNetwork playerNetwork = null;
        try {

            String hostname="localhost";
            int portNumber=9876;


            playerNetwork = new PlayerNetwork(hostname, portNumber);
            playerNetwork.init();

            UserService userService = new UserService();
            userService.setPlayerNetwork(playerNetwork);

            Thread thread = new Thread(playerNetwork);
            thread.start();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}





