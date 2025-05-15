/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import java.io.IOException;

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
    
public void handlePlayerExit(ClientHandler leaver) {
    ClientHandler opponent = (leaver == player1) ? player2 : player1;

    if (opponent != null) {
        opponent.sendMove("OPPONENT_LEFT");
    }

    // Optionally close the opponent's socket too (graceful shutdown)
    try {
        leaver.socket.close();
    } catch (IOException e) {
        e.printStackTrace();
    }

    // Nullify session references
    player1.session = null;
    player2.session = null;
}

}
