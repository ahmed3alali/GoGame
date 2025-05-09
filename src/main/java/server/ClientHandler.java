package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientHandler implements Runnable {
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

    @Override
    public void run() {
        try {
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());

            // Add this client to the waiting list and check if two players are available
            deServer.addWaitingClient(this);

            while (true) {
                String move = (String) in.readObject();
                if (session != null) {
                    session.forwardMove(this, move);
                }
            }
        } catch (Exception e) {
            System.out.println("Client disconnected.");
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
