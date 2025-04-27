/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * @author macbook
 */
public class ClientHandler implements Runnable{
    private Socket socket;
    private ObjectOutputStream out;
    private ObjectInputStream in;
    private GameSession session;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    public void sendMove(String move) {
        try {
            out.writeObject(move);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setGameSession(GameSession session) {
        this.session = session;
    }

    
    public void run() {
        try {
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());

            synchronized (server.waitingClients) {
                server.waitingClients.add(this);
                if (server.waitingClients.size() >= 2) {
                    ClientHandler p1 = server.waitingClients.remove(0);
                    ClientHandler p2 = server.waitingClients.remove(0);
                    GameSession session = new GameSession(p1, p2);
                    p1.setGameSession(session);
                    p2.setGameSession(session);
                    new Thread(session).start();
                }
            }

            while (true) {
                String move = (String) in.readObject();
                if (session != null) {
                    session.forwardMove(this, move);
                }
            }

        } catch (Exception e) {
            System.out.println("Client disconnected.");
        }
    }
}