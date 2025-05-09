package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.ArrayList;

public class deServer {
    private static final int PORT = 6000;
    private static List<ClientHandler> waitingClients = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Server started....");

        // Start server in a new thread
        new Thread(new Runnable() {
            @Override
            public void run() {
                startServer();
            }
        }).start();
    }

    public static void startServer() {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New Client connected ...");

                // Create and start a new ClientHandler thread
                ClientHandler handler = new ClientHandler(socket);
                new Thread(handler).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static synchronized void addWaitingClient(ClientHandler handler) {
        waitingClients.add(handler);

        if (waitingClients.size() >= 2) {
            // Start a new game session when two players are available
            ClientHandler player1 = waitingClients.remove(0);
            ClientHandler player2 = waitingClients.remove(0);

            GameSession session = new GameSession(player1, player2);

            player1.setGameSession(session);
            player2.setGameSession(session);

            new Thread(session).start();

            System.out.println("New game session started between two players.");
        } else {
            System.out.println("Waiting for another player to start a game...");
        }
    }
}
