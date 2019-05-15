package server;

import server.ClientHandler;
import server.ClientsList;
import server.ServerForm;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    public static Socket socket = null;
    static final int PORT = 15000;
    List<ClientsList> list = new ArrayList<>();
    String clientname;
    String clientStatus;

    public void ServerConn() {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);

        } catch (IOException e) {
            e.printStackTrace();

        }
        while (true) {

            try {

                socket = serverSocket.accept();

            } catch (IOException e) {
                System.out.println("I/O error: " + e);
            }
            //************************************************
            boolean check = true;
            String conName = String.valueOf(socket.getInetAddress());
            for (ClientsList s : list) {
                if (s.getConnName().equals(conName) && s.getConnName() != null) {
                    clientname = s.getClientName();
                    check = false;
                }
            }

            if (check) {
                list.add(new ClientsList(String.valueOf(socket.getInetAddress()), "Client" + ClientsList.counter));
                clientStatus = "Client " + ClientsList.counter + " is connected !!!";
                clientname = "Client " + ClientsList.counter;
                ServerForm.jTextArea1.append(clientStatus + " : " + "\n");
                ClientsList.counter++;
            }
            //***********************************************

            // new thread for a client


            new ClientHandler(socket,clientname).start();
        }
    }
}