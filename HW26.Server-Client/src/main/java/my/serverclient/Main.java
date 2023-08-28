package my.serverclient;

import my.serverclient.server.Server;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            Server myServ = new Server();
            myServ.startServer();
        } catch (IOException e) {
            System.out.println(e);
        }

    }
}