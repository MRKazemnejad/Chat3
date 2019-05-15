package server;

import server.ServerForm;

import javax.swing.*;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler extends Thread {
    public static Socket socket;
    private Scanner in;
    private String clientname;


    public ClientHandler(Socket clientSocket, String name) {
        this.socket = clientSocket;
        this.clientname = name;
    }


    public void run() {
        try {
            in = new Scanner(socket.getInputStream());
        } catch (IOException e) {
            return;
        }
        String line = "";

            try {

                if (in.hasNextLine()) {
                    line = in.nextLine();
                } else {
                    line = "left the chat.";
                    in.close();

                }
                ServerForm.jTextArea1.append(clientname + " : " + line + "\n");

            } catch (Exception e) {
                e.printStackTrace();
                return;
            }

    }
}