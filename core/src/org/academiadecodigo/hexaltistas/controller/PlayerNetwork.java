package org.academiadecodigo.hexaltistas.controller;

import org.academiadecodigo.hexaltistas.Echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class PlayerNetwork implements Runnable {

    private Socket playerSocket;
    private PrintWriter toServer;
    private BufferedReader fromServer;
    private Echo echo;



    PlayerNetwork(String hostName, int portNumber) throws IOException {
        playerSocket = new Socket(hostName, portNumber);

    }

    public void init() throws IOException {
        toServer = new PrintWriter(playerSocket.getOutputStream(), true);
        fromServer = new BufferedReader(new InputStreamReader(playerSocket.getInputStream()));


    }


    public void sendMsg(String msg) {

        toServer.println(msg);
    }


    public void run() {

        while (playerSocket.isConnected()) {

            try {
                String msgFromServer = fromServer.readLine();
                System.out.println(msgFromServer);
                //  decoder.decoding(msgFromServer);



            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void setEcho(Echo echo) {
        this.echo = echo;
    }
}
