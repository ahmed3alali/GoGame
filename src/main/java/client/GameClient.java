/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client;

/**
 *
 * @author macbook
 */

import java.io.*;
import java.net.Socket;
import javax.swing.SwingUtilities;

public class GameClient {

    private ObjectOutputStream out;
    private ObjectInputStream in;
    private Socket socket;
    private GameMainPanel gamePanel;

    public GameClient(GameMainPanel gamePanel) {
        this.gamePanel = gamePanel;

        try {
            //socket = new Socket("ec2-56-228-4-249.eu-north-1.compute.amazonaws.com", 6000);
            socket = new Socket("localhost", 6000);

            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());

            new Thread(() -> listen()).start();

        } catch (Exception e) {
           
            gamePanel.serverConnectionError();
            
        }
    }

    public void sendMove(String move) {
        try {
            out.writeObject(move);
            out.flush();
        } catch (IOException e) {
            System.out.println("Conneciton to the other game frame got lost. Reasons could be like a user left or etc.");
        }
    }

    private void listen() {
        try {
            while (true) {
                String message = (String) in.readObject();

                if (message.startsWith("START")) {
                    String color = message.split(":")[1];
                    gamePanel.setPlayerColor(color);

                } else if (message.equals("OPPO"
                        + "NENT_LEFT")) {
                    SwingUtilities.invokeLater(() -> {
                        javax.swing.JOptionPane.showMessageDialog(
                                gamePanel,
                                "Opponent left the game.",
                                "Game Over",
                                javax.swing.JOptionPane.INFORMATION_MESSAGE
                        );
                        System.exit(0);
                    });
                } else if (message.startsWith("CLEAR:")) {
    String[] parts = message.split(":");
    int row = Integer.parseInt(parts[1]);
    int col = Integer.parseInt(parts[2]);

    Point p = gamePanel.boardInfo[row][col];
    p.state = "EMPTY";
    p.label.setText("E");
} else if (message.startsWith("SCORE:")) {
    String[] scores = message.substring(6).split(",");
    for (String score : scores) {
        String[] kv = score.split("=");
        String color = kv[0];
        int value = Integer.parseInt(kv[1]);

        if (color.equals("BLACK")) {
            gamePanel.setSecondPlayerScore(value);
            gamePanel.blackCaptured = value;
        } else if (color.equals("WHITE")) {
            gamePanel.setFirstPlayerScore(value);
            gamePanel.whiteCaptured = value;
        }
    }
} else {
                    gamePanel.receiveMove(message);
                }
            }
        } catch (EOFException e) {
        System.out.println("Connection closed by server.");
        // Optionally: clean up or stop thread here
    } catch (IOException | ClassNotFoundException e) {
        e.printStackTrace();
    }
    }
}
