package my.serverclient.utils;

import my.serverclient.server.MyFile;

import java.io.*;
import java.net.Socket;
import java.util.Arrays;

public class Utils {

    public static void receiveFile1(Socket socket){

    }

    public  static void receiveFile(Socket socket){


        try {
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            System.out.println(socket.isConnected()+"is connnnnn" +socket.isClosed());

            int fileNameLen = dis.readInt();

            System.out.println("here s");
            if(fileNameLen > 0){
                byte[] fileNameByte = new byte[fileNameLen];
                dis.readFully(fileNameByte, 0 , fileNameLen);
                String fileNameReceived = new String(fileNameByte);
                int fileContLen = dis.readInt();

                if(fileContLen > 0) {
                    byte[] fileContByte = new byte[fileContLen];
                    System.out.println(Arrays.toString(fileContByte));
                    dis.readFully(fileContByte, 0, fileContLen);
                    File file = new File("E:\\JavaProjects\\HillelJavaHomeworks\\HW26.Server-Client");
                    FileOutputStream fos = new FileOutputStream(file);
                    System.out.println(fos + "fos here");
                    fos.write(fileContByte);
                    System.out.println(fos + "fos after");
                    fos.close();

                }

            }

        }catch (IOException e){
            System.out.println(e);
        }

    }

    public static MyFile sendFile(String path, Socket socket, String sender) throws IOException {

        File file = new File(path);
        try (FileInputStream fis = new FileInputStream(file.getAbsolutePath());
            ){
              DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            String fileName = file.getName();
            byte[] fileNameBytes = fileName.getBytes();
            System.out.println(Arrays.toString(fileNameBytes));
            byte[] fileContBytes = new byte[(int) file.length()];
            fis.read(fileContBytes);
            dos.writeInt(fileNameBytes.length);
            dos.write(fileNameBytes);
            dos.writeInt(fileContBytes.length);
            dos.write(fileContBytes);


            return new MyFile(sender, file.getAbsolutePath(), new String(fileNameBytes), fileContBytes.length);

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return null;
    }

    public static String extractPath(String userInput){


        String[] splittedInput = userInput.trim().split(" ");
        if(splittedInput.length == 2) {
            System.out.println(splittedInput[1].trim());
            return splittedInput[1].trim();
        }

        System.out.println("Incorrect format. You should type: file path_to_file");
        return "";

    }


}
