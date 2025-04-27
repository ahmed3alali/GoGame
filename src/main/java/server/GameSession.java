/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

public class GameSession implements Runnable {
    private ClientHandler player1;
    private ClientHandler player2;

    public GameSession(ClientHandler p1, ClientHandler p2) {
        this.player1 = p1;
        this.player2 = p2;
    }

    @Override
    public void run() {
        player1.sendMove("START:BLACK");
        player2.sendMove("START:WHITE");
    }

    public void forwardMove(ClientHandler sender, String move) {
        ClientHandler receiver = (sender == player1) ? player2 : player1;
        receiver.sendMove(move);
    }
}
