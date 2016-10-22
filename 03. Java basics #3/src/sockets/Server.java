package sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        int port = 6666;

        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("waiting for clients");

        while (true) {
            Socket accepted = serverSocket.accept();
            System.out.println("new user is there: " + accepted.getInetAddress().getCanonicalHostName());
            new Thread(() -> {
                BufferedReader reader = null;
                try {
                    reader = new BufferedReader(new InputStreamReader(accepted.getInputStream()));
                } catch (IOException e) {
                    System.out.println("input stream error");
                    return;
                }
                while (!accepted.isClosed()) {
                    try {
                        String line = reader.readLine();
                        if (line == null) {
                            break;
                        }
                        System.out.println(line);
                    } catch (IOException e) {
                        try {
                            reader.close();
                        } catch (IOException e1) {
//                           do nothing
                        }
                    }
                }
            }).start();
        }
    }

}
