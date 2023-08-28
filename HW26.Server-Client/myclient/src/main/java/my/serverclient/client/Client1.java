package my.serverclient.client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client1 {

    private Socket client;
    private BufferedReader inReader;
    private BufferedWriter outWriter;

    public Client1(String host, int port) throws IOException {

        client = new Socket(host, port);
        outWriter = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        inReader = new BufferedReader(new InputStreamReader(client.getInputStream()));

    }

    public void notifyUsers(){
        Scanner scanner = new Scanner(System.in);
        String userInput;

        try {
            do {
                userInput = scanner.nextLine();
                if(userInput.equals("-exit")) {
//                    outWriter.write("has left the chat");
                    outWriter.write(userInput);
                    outWriter.newLine();
                    outWriter.flush();
                    terminate();
                }
                else {
                    outWriter.write(userInput);
                    outWriter.newLine();
                    outWriter.flush();
                }

            }while (client!= null && !client.isClosed());

        } catch (IOException e) {
            terminate();
        }
    }



    public void messagelistener(){

        new Thread(()->{
            String msgFromOutside;

            while (client != null && !client.isClosed()){
                try {
                    msgFromOutside = inReader.readLine();
                    System.out.println(msgFromOutside);
                } catch (IOException e) {
                    System.out.println(e);
                    terminate();
                }
            }


        }).start();
    }

    public void terminate(){

            try {
                if(outWriter != null)
                    outWriter.close();
                if(inReader != null)
                    inReader.close();
                if(client != null && client.isConnected())
                    client.close();
            } catch (IOException e) {
                System.out.println(e);
            }
    }
}
