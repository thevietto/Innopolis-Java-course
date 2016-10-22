package sockets;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException {
        int port = 6666;
        InetAddress address = InetAddress.getByName("127.0.0.1");

        Socket socket = new Socket(address, port);

        socket.getInputStream();
        socket.getOutputStream();


    }
}
