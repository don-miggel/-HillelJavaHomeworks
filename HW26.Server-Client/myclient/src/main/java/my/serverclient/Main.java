package my.serverclient;

import my.serverclient.client.Client1;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            Client1 client = new Client1("localhost", 8888);
            client.messagelistener();
            client.notifyUsers();
        }catch (IOException e){
            System.out.println(e);
        }


    }
}