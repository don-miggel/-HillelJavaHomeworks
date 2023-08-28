package my.serverclient.server;

import my.serverclient.utils.Utils;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    private final static int DEFAULT_PORT = 8888;

    private int port;
    private ServerSocket serverSocket;
    private List<ActiveConnection> connections;
    private List<MyFile> receivedFiles;
    private ExecutorService threadPool;
    private File file;

    {
        connections = new ArrayList<>();
        receivedFiles = new ArrayList<>();
    }

    public Server(int port) throws IOException {

        this.port = port;
        serverSocket = new ServerSocket(this.port);
        threadPool = Executors.newCachedThreadPool();

    }

    public Server() throws IOException {
        this(DEFAULT_PORT);
    }


    public void startServer() {

            try {
                while (!serverSocket.isClosed()) {
                    Socket client = serverSocket.accept();
                    ActiveConnection aConn = new ActiveConnection(client);
                    connections.add(aConn);
                    threadPool.execute(aConn);

                }
            } catch (IOException e) {
                System.out.println(e);
                try {
                    terminateServer();
                } catch (Exception ex) {
                    System.out.println(e);
                }

            }
    }

    public void displayConnectedUsers(){

        for (ActiveConnection aConn : connections){
            if(aConn.getClient().isConnected())
                System.out.println(aConn);
        }
    }

    public void notifyAllUsers(ActiveConnection aConn, String msg){
        for (ActiveConnection conn : connections){
            if(conn != null && !conn.equals(aConn)){
                try {
                    conn.sendMessage(msg);
                } catch (IOException e) {
                    System.out.println(e);
                }
            }
        }

    }

    public void terminateServer() throws Exception {
        if(serverSocket != null)
            serverSocket.close();
        for (ActiveConnection conn : connections){
            if(conn != null)
                conn.terminateClient();
        }
        connections.clear();
        System.out.println("Server terminates...");
    }

    class ActiveConnection implements Runnable{

        private static int clientNumber = 0;

        private final Socket client;
        private String nickname;
        private final LocalDateTime connSetUpDate;
        private BufferedReader inReader;
        private PrintWriter outWriter;


        public ActiveConnection(Socket socket) throws IOException {

            this.client = socket;
            connSetUpDate = LocalDateTime.now();
            outWriter =new PrintWriter(new OutputStreamWriter(this.client.getOutputStream()));;
            inReader = new BufferedReader(new InputStreamReader(this.client.getInputStream()));
            nickname = "Client#" + ++clientNumber;
            String newUserNotification = String.format("[%s] %s has successfully connected at %s !", "SERVER",
                    nickname, connSetUpDate );
//            String newUserNotification = String.format("[%s] %s has successfully connected at %s !", "SERVER",
//                    aConn.getNickname(), aConn.getConnSetUpDate() );
            notifyAllUsers(this, newUserNotification);

        }

        @Override
        public void run() {

            String userInput;
            try {

                while (inReader!= null && (userInput = inReader.readLine()) != null){
                    if(userInput.equals("-exit")){
                        terminateClient();
                    }else if (userInput.startsWith("-file")){
                        MyFile sentFile = Utils.sendFile(Utils.extractPath(userInput),client, nickname );
                        if(sentFile != null) {
                                receivedFiles.add(sentFile);
                                System.out.println(receivedFiles);
                        }

                    }else if (userInput.startsWith("-active"))
                        displayConnectedUsers();
                    else
                        notifyAllUsers( this,nickname+" wrote:" + userInput);

                }

            } catch (IOException e) {
                System.out.println("The connection of user " +nickname+" has just been closed!");
//                terminateClient();
            }

        }

        public LocalDateTime getConnSetUpDate() {
            return connSetUpDate;
        }

        public Socket getClient() {
            return client;
        }

        public String getNickname() {
            return nickname;
        }

        public void sendMessage(String msg) throws IOException {
            outWriter.println(msg);
            outWriter.flush();
        }

        private void terminateClient(){

            if(client != null && client.isConnected()) {
                try {
                    connections.remove(this);
                    notifyAllUsers(this, nickname+" has left the chat...");
                    inReader.close();
                    outWriter.close();
                    client.close();

                } catch (IOException e) {
                     System.out.println(nickname+"closed a connection");
                }
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof ActiveConnection)) return false;
            ActiveConnection that = (ActiveConnection) o;
            return Objects.equals(nickname, that.nickname);
        }

        @Override
        public int hashCode() {
            return Objects.hash(nickname);
        }

        @Override
        public String toString() {
            return "nickname: " + nickname + '\'';

        }
    }
}
