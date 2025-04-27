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
            socket = new Socket("localhost", 6000);
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());

            new Thread(() -> listen()).start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendMove(String move) {
        try {
            out.writeObject(move);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listen() {
        try {
            while (true) {
                String message = (String) in.readObject();
                if (message.startsWith("START")) {
                    String color = message.split(":")[1];
                    gamePanel.setPlayerColor(color);
                } else {
                    gamePanel.receiveMove(message);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
