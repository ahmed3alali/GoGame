/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package client;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author macbook
 */
public class GameMainPanel extends javax.swing.JFrame {

    private boolean isBlackTurn = true;
    private GameClient client;
    private String playerColor;
    private boolean isMyTurn;

    private String myName;
    private String opponentName;
    

    /**
     *
     *
     *
     * Creates new form GameMainPanel
     *
     *
     */
    public GameMainPanel() {

    initComponents();

String playerName = JOptionPane.showInputDialog(
        this,
        "Enter your name:",
        "Player Name",
        JOptionPane.PLAIN_MESSAGE
);

if (playerName == null) {
    // Cancel was pressed
    JOptionPane.showMessageDialog(
        this,
        "You must enter a name to continue.",
        "Input Required",
        JOptionPane.WARNING_MESSAGE
    );
    System.exit(0); 
    
} else {
    firstPlayerName.setText(playerName);
}


        
        
        try {
            
            client = new GameClient(this); 
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Please connect to a server first then start the game frame again");
        }
        // pass the name to GameClient

        initializeLabelGrid();
        initializeBoard();

    }

    private JLabel[][] labelGrid = new JLabel[9][9];
    public Point[][] boardInfo = new Point[9][9];

    private void initializeLabelGrid() {
        labelGrid[0][0] = firstColfirRow;
        labelGrid[0][1] = secondRowFirstCol;
        labelGrid[0][2] = thirdRowFirstCol;
        labelGrid[0][3] = fourthRowFirstCol;
        labelGrid[0][4] = fifthRowFirstCol;
        labelGrid[0][5] = sixthRowFirstCol;
        labelGrid[0][6] = seventhRowFirstCol;
        labelGrid[0][7] = eighthRowFirstCol;
        labelGrid[0][8] = ninthRowFirstCol;

        // second column
        labelGrid[1][0] = firstRowSecCol;
        labelGrid[1][1] = secondRowSecCol;
        labelGrid[1][2] = ThirdRowSecCol;
        labelGrid[1][3] = FourthRowSecCol;
        labelGrid[1][4] = FifthRowSecCol;
        labelGrid[1][5] = SixthRowSecCol;
        labelGrid[1][6] = SeventhRowSecCol;
        labelGrid[1][7] = EighthRowSecCol;
        labelGrid[1][8] = NinthRowSecCol;

        // third column
        labelGrid[2][0] = firstRowThirdCol;
        labelGrid[2][1] = secondRowThirdCol;
        labelGrid[2][2] = ThirdRowThirdCol;
        labelGrid[2][3] = ForthRowLThirdCol;
        labelGrid[2][4] = FifthRowThirdCol;
        labelGrid[2][5] = SixthRowThirdCol;
        labelGrid[2][6] = SeventhRowThirdCol;
        labelGrid[2][7] = EightRowThirdCol;
        labelGrid[2][8] = NinthRowThirdCol;

        // fourth column
        labelGrid[3][0] = firstRowFourthCol;
        labelGrid[3][1] = secondRowFourthCol;
        labelGrid[3][2] = thirdRowFourthCol;
        labelGrid[3][3] = fourthRowFourthCol;
        labelGrid[3][4] = fifthRowFourthCol;
        labelGrid[3][5] = sixthRowFourthCol;
        labelGrid[3][6] = seventhRowFourthCol;
        labelGrid[3][7] = eighthRowFourthCol;
        labelGrid[3][8] = ninthRowFourthCol;

        //fifth column
        labelGrid[4][0] = firstRowFifthCol;
        labelGrid[4][1] = secondRowFifthCol;
        labelGrid[4][2] = thirdRowFifthCol;
        labelGrid[4][3] = fourthRowFifthCol;
        labelGrid[4][4] = fifthRowFifthCol;
        labelGrid[4][5] = sixthRowFifthCol;
        labelGrid[4][6] = seventhRowFifthCol;
        labelGrid[4][7] = eigthRowFifthCol;
        labelGrid[4][8] = ninthRowFifthCol;

        // sixth column 
        labelGrid[5][0] = firstRowSixthCol;
        labelGrid[5][1] = secondRowSixthCol;
        labelGrid[5][2] = thirdRowSixthCol;
        labelGrid[5][3] = fourthRowSixthCol;
        labelGrid[5][4] = fifthRowSixthCol;
        labelGrid[5][5] = sixthRowSixthCol;
        labelGrid[5][6] = seventhRowSixthCol;
        labelGrid[5][7] = eighthRowSixthCol;
        labelGrid[5][8] = ninthRowSixthCol;

        // seventh column 
        labelGrid[6][0] = firstRowSeventhCol;
        labelGrid[6][1] = secondRowSeventhCol;
        labelGrid[6][2] = thirdRowSeventhCol;
        labelGrid[6][3] = fourthRowSeventhCol;
        labelGrid[6][4] = fifthRowSeventhCol;
        labelGrid[6][5] = sixthRowSeventhCol;
        labelGrid[6][6] = seventhRowSeventhCol;
        labelGrid[6][7] = eightRowSeventhCol;
        labelGrid[6][8] = ninthRowSeventhCol;

        // eight column
        labelGrid[7][0] = firstRowEighthCol;
        labelGrid[7][1] = secondRowEighthCol;
        labelGrid[7][2] = thirdRowEighthCol;
        labelGrid[7][3] = forthRowEightCol;
        labelGrid[7][4] = fifthRowEightCol;
        labelGrid[7][5] = sixthRowEightCol;
        labelGrid[7][6] = seventhRowEightCol;
        labelGrid[7][7] = eighthRowEighthCol;
        labelGrid[7][8] = nighthRowEighthCol;

        // nighth column
        labelGrid[8][0] = firstRowNinthCol;
        labelGrid[8][1] = secondRowNinthCol;
        labelGrid[8][2] = thirdRowNinthCol;
        labelGrid[8][3] = forthRowNinthCol;
        labelGrid[8][4] = fifthRowNinthCol;
        labelGrid[8][5] = sixthRowNinthCol;
        labelGrid[8][6] = seventhRowNinthCol;
        labelGrid[8][7] = eighthRowNinthCol;
        labelGrid[8][8] = ninthRowNinthCol;

    }

    public void initializeBoard() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                Point p = new Point();
                p.label = labelGrid[i][j];
                p.row = i;
                p.col = j;
                p.state = "EMPTY";
                boardInfo[i][j] = p;

                p.label.putClientProperty("point", p);
                p.label.setText("E");

            }
        }

        pointNeigboursInitilizer();
        addListeners();

    }
    
    
    public void serverConnectionError(){
        
     JOptionPane.showMessageDialog(rootPane,  "Please connect to a server first then start the game frame again");
    System.exit(0);
    
    }

    int blackCaptured = 0;
    int whiteCaptured = 0;

    public void scoreCalculator(int currentScoreWhite, int currentScoreBlack, boolean isWhite) {

        if (isWhite) {

            currentScoreWhite++;

            Player1ScoreValue.setText(Integer.toString(currentScoreWhite));

        } else {

            currentScoreBlack++;
            Player2ScoreValue.setText(Integer.toString(currentScoreBlack));

        }
        
        
        client.sendMove("SCORE:BLACK=" + blackCaptured + ",WHITE=" + whiteCaptured);

    }

    private void addListeners() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                Point p = boardInfo[i][j];

                p.label.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        Point clickedPoint = (Point) ((JLabel) evt.getSource()).getClientProperty("point");

                        if (clickedPoint.state.equals("EMPTY") && isMyTurn) {

                            clickedPoint.state = isBlackTurn ? "BLACK" : "WHITE";
                            clickedPoint.label.setText(isBlackTurn ? "B" : "W");

                            client.sendMove(clickedPoint.row + ":" + clickedPoint.col + ":" + clickedPoint.state);
                            isMyTurn = false;

                            String opponentColor = isBlackTurn ? "WHITE" : "BLACK";
                            Point[] neighbors = {clickedPoint.up, clickedPoint.down, clickedPoint.left, clickedPoint.right};

                            for (Point neighbor : neighbors) {
                                if (neighbor != null && neighbor.state.equals(opponentColor)) {
                                    Set<Point> neighborGroup = getConnectedGroup(neighbor);
                                    if (isGroupCaptured(neighborGroup)) {
                                        for (Point captured : neighborGroup) {

                                        

                                            captured.state = "EMPTY";
                                            captured.label.setText("E");
                                            client.sendMove("CLEAR:" + captured.row + ":" + captured.col);

                                        }

                                    }
                                }
                            }

                            Set<Point> group = getConnectedGroup(clickedPoint);
                            if (isGroupCaptured(group)) {

                                for (Point point : group) {

                               

                                    point.state = "EMPTY";
                                    point.label.setText("E");
                                }

                            }

                            isBlackTurn = !isBlackTurn;

                            if (countEmpty(boardInfo) == 0) {
                                Map<String, Integer> result = calculateTerritory(boardInfo);
                                JOptionPane.showMessageDialog(null, "Game Over!\nBlack: " + result.get("BLACK") + "\nWhite: " + result.get("WHITE"));
                            }
                        }
                    }
                });
            }
        }
    }

    public void pointNeigboursInitilizer() {

        System.out.println("i am called ");
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                Point p = boardInfo[i][j];
                p.up = (i > 0) ? boardInfo[i - 1][j] : null;
                p.down = (i < 8) ? boardInfo[i + 1][j] : null;
                p.left = (j > 0) ? boardInfo[i][j - 1] : null;
                p.right = (j < 8) ? boardInfo[i][j + 1] : null;

            }

        }

    }

    public int countEmpty(Point[][] board) {
        int count = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j].state.equals("EMPTY")) {
                    count++;
                }
            }
        }
        return count;
    }
    
    
    


    public boolean hasLiberty(Point point) {
        return (point.up != null && point.up.state.equals("EMPTY"))
                || (point.down != null && point.down.state.equals("EMPTY"))
                || (point.left != null && point.left.state.equals("EMPTY"))
                || (point.right != null && point.right.state.equals("EMPTY"));
    }

    public Set<Point> getConnectedGroup(Point start) {
        Set<Point> group = new HashSet<>();
        Stack<Point> stack = new Stack<>();
        stack.push(start);
        String color = start.state;

        while (!stack.isEmpty()) {
            Point current = stack.pop();
            if (!group.contains(current) && current.state.equals(color)) {
                group.add(current);
                if (current.up != null && !group.contains(current.up)) {
                    stack.push(current.up);
                }
                if (current.down != null && !group.contains(current.down)) {
                    stack.push(current.down);
                }
                if (current.left != null && !group.contains(current.left)) {
                    stack.push(current.left);
                }
                if (current.right != null && !group.contains(current.right)) {
                    stack.push(current.right);
                }
            }
        }

        return group;
    }

    public boolean isGroupCaptured(Set<Point> group) {
        for (Point p : group) {
            
                            
            if (hasLiberty(p)) {
                return false;  // If any point in the group has liberty, the group is not captured
            }
        }

        // If the group is captured, I SEt all points in the group to "EMPTY"
        for (Point p : group) {
        
                
                 System.out.println("OLD STATE :" + p.state);  
                 
                if (p.state.equals("BLACK")) {
                    blackCaptured++;
                    System.out.println("black capture value is : "+ blackCaptured);
                    Player2ScoreValue.setText(Integer.toString(blackCaptured));
                    
                
                } else if (p.state.equals("WHITE")) {
                    whiteCaptured++;
               
                    Player1ScoreValue.setText(Integer.toString(whiteCaptured));
                    
                
            }
                    client.sendMove("SCORE:BLACK=" + blackCaptured + ",WHITE=" + whiteCaptured);
                  
            p.state = "EMPTY";  // Set state to "EMPTY"
            p.label.setText("E"); // Update the UI label to show "E"
        }
        
        
        

        return true;  // Group is captured and has been cleared
    }

    public static Map<String, Integer> calculateTerritory(Point[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        Map<String, Integer> territory = new HashMap<>();
        territory.put("BLACK", 0);
        territory.put("WHITE", 0);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j] && board[i][j].state.equals("EMPTY")) {
                    Set<Point> region = new HashSet<>();
                    Set<String> surroundingColors = new HashSet<>();
                    exploreEmptyTerritory(board, i, j, visited, region, surroundingColors);

                    if (surroundingColors.size() == 1) {
                        String owner = surroundingColors.iterator().next(); // BLACK or WHITE
                        territory.put(owner, territory.get(owner) + region.size());
                    }

                }
            }
        }

        return territory;
    }

    private static void exploreEmptyTerritory(Point[][] board, int row, int col,
            boolean[][] visited, Set<Point> region,
            Set<String> surroundingColors) {
        int rows = board.length;
        int cols = board[0].length;
        Stack<Point> stack = new Stack<>();
        stack.push(board[row][col]);

        while (!stack.isEmpty()) {
            Point p = stack.pop();
            int r = p.row;
            int c = p.col;

            if (r < 0 || r >= rows || c < 0 || c >= cols || visited[r][c]) {
                continue;
            }
            visited[r][c] = true;

            if (!board[r][c].state.equals("EMPTY")) {
                surroundingColors.add(board[r][c].state);
                continue;
            }

            region.add(board[r][c]);

            // check 4 directions
            if (r > 0) {
                stack.push(board[r - 1][c]);
            }
            if (r < rows - 1) {
                stack.push(board[r + 1][c]);
            }
            if (c > 0) {
                stack.push(board[r][c - 1]);
            }
            if (c < cols - 1) {
                stack.push(board[r][c + 1]);
            }
        }
    }

    private void findTerritory(Point point, boolean[][] visited, Set<Point> region, Set<String> borderingColors) {
        Stack<Point> stack = new Stack<>();
        stack.push(point);

        while (!stack.isEmpty()) {
            Point current = stack.pop();
            if (visited[current.row][current.col]) {
                continue;
            }

            visited[current.row][current.col] = true;
            region.add(current);

            Point[] neighbors = {current.up, current.down, current.left, current.right};

            for (Point neighbor : neighbors) {
                if (neighbor == null) {
                    continue;
                }
                if (neighbor.state.equals("EMPTY") && !visited[neighbor.row][neighbor.col]) {
                    stack.push(neighbor);
                } else if (!neighbor.state.equals("EMPTY")) {
                    borderingColors.add(neighbor.state);
                }
            }
        }
    }

    public void setPlayerColor(String color) {
        this.playerColor = color;
        this.isMyTurn = color.equals("BLACK");
        JOptionPane.showMessageDialog(null, "You are " + color);
    }
    
    
    public void setFirstPlayerScore(int score){
    
        Player1ScoreValue.setText(Integer.toString(score));
    
    
    }
    
    
      public void setSecondPlayerScore(int score){
    
        Player2ScoreValue.setText(Integer.toString(score));
    
    
    }

    public void receiveMove(String move) {
        
           if (move.equals("EXIT")) {
        // Opponent left the game
        javax.swing.JOptionPane.showMessageDialog(
            this,
            "Your opponent has left the game ee.",
            "Game Ended",
            javax.swing.JOptionPane.INFORMATION_MESSAGE
        );
        // Optionally: Disable game board or go back to main menu
return;
           }
        
        String[] parts = move.split(":");
        int row = Integer.parseInt(parts[0]);
        int col = Integer.parseInt(parts[1]);
        String color = parts[2];

        Point point = boardInfo[row][col];
        point.state = color;
        point.label.setText(color.equals("BLACK") ? "B" : "W");
        isBlackTurn = !isBlackTurn;
        isMyTurn = true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Scores = new javax.swing.JLabel();
        GameLogo = new javax.swing.JLabel();
        leaveGameBtn = new javax.swing.JButton();
        firstPlayerName = new javax.swing.JLabel();
        firstColfirRow = new javax.swing.JLabel();
        secondRowFirstCol = new javax.swing.JLabel();
        thirdRowFirstCol = new javax.swing.JLabel();
        fourthRowFirstCol = new javax.swing.JLabel();
        fifthRowFirstCol = new javax.swing.JLabel();
        sixthRowFirstCol = new javax.swing.JLabel();
        seventhRowFirstCol = new javax.swing.JLabel();
        eighthRowFirstCol = new javax.swing.JLabel();
        ninthRowFirstCol = new javax.swing.JLabel();
        firstRowSecCol = new javax.swing.JLabel();
        secondRowSecCol = new javax.swing.JLabel();
        ThirdRowSecCol = new javax.swing.JLabel();
        FourthRowSecCol = new javax.swing.JLabel();
        FifthRowSecCol = new javax.swing.JLabel();
        SixthRowSecCol = new javax.swing.JLabel();
        SeventhRowSecCol = new javax.swing.JLabel();
        EighthRowSecCol = new javax.swing.JLabel();
        NinthRowSecCol = new javax.swing.JLabel();
        firstRowThirdCol = new javax.swing.JLabel();
        secondRowThirdCol = new javax.swing.JLabel();
        ThirdRowThirdCol = new javax.swing.JLabel();
        ForthRowLThirdCol = new javax.swing.JLabel();
        FifthRowThirdCol = new javax.swing.JLabel();
        SixthRowThirdCol = new javax.swing.JLabel();
        SeventhRowThirdCol = new javax.swing.JLabel();
        EightRowThirdCol = new javax.swing.JLabel();
        NinthRowThirdCol = new javax.swing.JLabel();
        firstRowFourthCol = new javax.swing.JLabel();
        secondRowFourthCol = new javax.swing.JLabel();
        thirdRowFourthCol = new javax.swing.JLabel();
        fourthRowFourthCol = new javax.swing.JLabel();
        fifthRowFourthCol = new javax.swing.JLabel();
        sixthRowFourthCol = new javax.swing.JLabel();
        seventhRowFourthCol = new javax.swing.JLabel();
        eighthRowFourthCol = new javax.swing.JLabel();
        ninthRowFourthCol = new javax.swing.JLabel();
        firstRowFifthCol = new javax.swing.JLabel();
        secondRowFifthCol = new javax.swing.JLabel();
        thirdRowFifthCol = new javax.swing.JLabel();
        fourthRowFifthCol = new javax.swing.JLabel();
        fifthRowFifthCol = new javax.swing.JLabel();
        sixthRowFifthCol = new javax.swing.JLabel();
        seventhRowFifthCol = new javax.swing.JLabel();
        eigthRowFifthCol = new javax.swing.JLabel();
        ninthRowFifthCol = new javax.swing.JLabel();
        firstRowSixthCol = new javax.swing.JLabel();
        secondRowSixthCol = new javax.swing.JLabel();
        thirdRowSixthCol = new javax.swing.JLabel();
        fourthRowSixthCol = new javax.swing.JLabel();
        fifthRowSixthCol = new javax.swing.JLabel();
        sixthRowSixthCol = new javax.swing.JLabel();
        seventhRowSixthCol = new javax.swing.JLabel();
        eighthRowSixthCol = new javax.swing.JLabel();
        ninthRowSixthCol = new javax.swing.JLabel();
        firstRowSeventhCol = new javax.swing.JLabel();
        secondRowSeventhCol = new javax.swing.JLabel();
        thirdRowSeventhCol = new javax.swing.JLabel();
        fourthRowSeventhCol = new javax.swing.JLabel();
        fifthRowSeventhCol = new javax.swing.JLabel();
        sixthRowSeventhCol = new javax.swing.JLabel();
        seventhRowSeventhCol = new javax.swing.JLabel();
        eightRowSeventhCol = new javax.swing.JLabel();
        ninthRowSeventhCol = new javax.swing.JLabel();
        firstRowEighthCol = new javax.swing.JLabel();
        secondRowEighthCol = new javax.swing.JLabel();
        thirdRowEighthCol = new javax.swing.JLabel();
        forthRowEightCol = new javax.swing.JLabel();
        fifthRowEightCol = new javax.swing.JLabel();
        sixthRowEightCol = new javax.swing.JLabel();
        seventhRowEightCol = new javax.swing.JLabel();
        eighthRowEighthCol = new javax.swing.JLabel();
        nighthRowEighthCol = new javax.swing.JLabel();
        firstRowNinthCol = new javax.swing.JLabel();
        secondRowNinthCol = new javax.swing.JLabel();
        thirdRowNinthCol = new javax.swing.JLabel();
        forthRowNinthCol = new javax.swing.JLabel();
        fifthRowNinthCol = new javax.swing.JLabel();
        sixthRowNinthCol = new javax.swing.JLabel();
        seventhRowNinthCol = new javax.swing.JLabel();
        eighthRowNinthCol = new javax.swing.JLabel();
        ninthRowNinthCol = new javax.swing.JLabel();
        Player2ScoreValue = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        Player1ScoreValue = new javax.swing.JLabel();
        Player1Score = new javax.swing.JLabel();
        Player2Score = new javax.swing.JLabel();
        PlayersAvaliableHeading2 = new javax.swing.JLabel();
        wallpaper = new javax.swing.JLabel();
        Player1Score1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Scores.setBackground(new java.awt.Color(255, 255, 255));
        Scores.setFont(new java.awt.Font("Herculanum", 1, 24)); // NOI18N
        Scores.setForeground(new java.awt.Color(255, 153, 0));
        Scores.setText("Score");
        getContentPane().add(Scores, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 90, -1));

        GameLogo.setBackground(new java.awt.Color(255, 255, 255));
        GameLogo.setFont(new java.awt.Font("Kohinoor Bangla", 0, 36)); // NOI18N
        GameLogo.setForeground(new java.awt.Color(255, 255, 255));
        GameLogo.setText(" GO - X Pro Game");
        getContentPane().add(GameLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 280, -1));

        leaveGameBtn.setText("Leave game");
        leaveGameBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leaveGameBtnActionPerformed(evt);
            }
        });
        getContentPane().add(leaveGameBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, -1, -1));

        firstPlayerName.setFont(new java.awt.Font("Hiragino Maru Gothic ProN", 0, 18)); // NOI18N
        firstPlayerName.setForeground(new java.awt.Color(255, 255, 255));
        firstPlayerName.setText("player1");
        getContentPane().add(firstPlayerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, -1, -1));

        firstColfirRow.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        firstColfirRow.setForeground(new java.awt.Color(255, 255, 255));
        firstColfirRow.setText("E");
        getContentPane().add(firstColfirRow, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 40, -1, -1));

        secondRowFirstCol.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        secondRowFirstCol.setForeground(new java.awt.Color(255, 255, 255));
        secondRowFirstCol.setText("E");
        getContentPane().add(secondRowFirstCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(318, 80, 10, -1));

        thirdRowFirstCol.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        thirdRowFirstCol.setForeground(new java.awt.Color(255, 255, 255));
        thirdRowFirstCol.setText("E");
        getContentPane().add(thirdRowFirstCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(318, 140, 10, -1));

        fourthRowFirstCol.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        fourthRowFirstCol.setForeground(new java.awt.Color(255, 255, 255));
        fourthRowFirstCol.setText("E");
        getContentPane().add(fourthRowFirstCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 200, 20, -1));

        fifthRowFirstCol.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        fifthRowFirstCol.setForeground(new java.awt.Color(255, 255, 255));
        fifthRowFirstCol.setText("E");
        getContentPane().add(fifthRowFirstCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 250, -1, -1));

        sixthRowFirstCol.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        sixthRowFirstCol.setForeground(new java.awt.Color(255, 255, 255));
        sixthRowFirstCol.setText("E");
        getContentPane().add(sixthRowFirstCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 420, -1, -1));

        seventhRowFirstCol.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        seventhRowFirstCol.setForeground(new java.awt.Color(255, 255, 255));
        seventhRowFirstCol.setText("E");
        getContentPane().add(seventhRowFirstCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 310, -1, -1));

        eighthRowFirstCol.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        eighthRowFirstCol.setForeground(new java.awt.Color(255, 255, 255));
        eighthRowFirstCol.setText("E");
        getContentPane().add(eighthRowFirstCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(318, 350, 20, 20));

        ninthRowFirstCol.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        ninthRowFirstCol.setForeground(new java.awt.Color(255, 255, 255));
        ninthRowFirstCol.setText("E");
        getContentPane().add(ninthRowFirstCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 390, -1, -1));

        firstRowSecCol.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        firstRowSecCol.setForeground(new java.awt.Color(255, 255, 255));
        firstRowSecCol.setText("E");
        getContentPane().add(firstRowSecCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 40, -1, -1));

        secondRowSecCol.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        secondRowSecCol.setForeground(new java.awt.Color(255, 255, 255));
        secondRowSecCol.setText("E");
        getContentPane().add(secondRowSecCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 90, -1, -1));

        ThirdRowSecCol.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        ThirdRowSecCol.setForeground(new java.awt.Color(255, 255, 255));
        ThirdRowSecCol.setText("E");
        getContentPane().add(ThirdRowSecCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 140, -1, -1));

        FourthRowSecCol.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        FourthRowSecCol.setForeground(new java.awt.Color(255, 255, 255));
        FourthRowSecCol.setText("E");
        getContentPane().add(FourthRowSecCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 200, -1, -1));

        FifthRowSecCol.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        FifthRowSecCol.setForeground(new java.awt.Color(255, 255, 255));
        FifthRowSecCol.setText("E");
        getContentPane().add(FifthRowSecCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 250, -1, -1));

        SixthRowSecCol.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        SixthRowSecCol.setForeground(new java.awt.Color(255, 255, 255));
        SixthRowSecCol.setText("E");
        getContentPane().add(SixthRowSecCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 300, 20, 20));

        SeventhRowSecCol.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        SeventhRowSecCol.setForeground(new java.awt.Color(255, 255, 255));
        SeventhRowSecCol.setText("E");
        getContentPane().add(SeventhRowSecCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 350, -1, -1));

        EighthRowSecCol.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        EighthRowSecCol.setForeground(new java.awt.Color(255, 255, 255));
        EighthRowSecCol.setText("E");
        getContentPane().add(EighthRowSecCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 390, -1, -1));

        NinthRowSecCol.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        NinthRowSecCol.setForeground(new java.awt.Color(255, 255, 255));
        NinthRowSecCol.setText("E");
        getContentPane().add(NinthRowSecCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 420, -1, -1));

        firstRowThirdCol.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        firstRowThirdCol.setForeground(new java.awt.Color(255, 255, 255));
        firstRowThirdCol.setText("E");
        getContentPane().add(firstRowThirdCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 40, -1, -1));

        secondRowThirdCol.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        secondRowThirdCol.setForeground(new java.awt.Color(255, 255, 255));
        secondRowThirdCol.setText("E");
        getContentPane().add(secondRowThirdCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 80, 20, 30));

        ThirdRowThirdCol.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        ThirdRowThirdCol.setForeground(new java.awt.Color(255, 255, 255));
        ThirdRowThirdCol.setText("E");
        getContentPane().add(ThirdRowThirdCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 140, -1, -1));

        ForthRowLThirdCol.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        ForthRowLThirdCol.setForeground(new java.awt.Color(255, 255, 255));
        ForthRowLThirdCol.setText("E");
        getContentPane().add(ForthRowLThirdCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 200, -1, -1));

        FifthRowThirdCol.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        FifthRowThirdCol.setForeground(new java.awt.Color(255, 255, 255));
        FifthRowThirdCol.setText("E");
        getContentPane().add(FifthRowThirdCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 250, -1, -1));

        SixthRowThirdCol.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        SixthRowThirdCol.setForeground(new java.awt.Color(255, 255, 255));
        SixthRowThirdCol.setText("E");
        getContentPane().add(SixthRowThirdCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 300, -1, -1));

        SeventhRowThirdCol.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        SeventhRowThirdCol.setForeground(new java.awt.Color(255, 255, 255));
        SeventhRowThirdCol.setText("E");
        getContentPane().add(SeventhRowThirdCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 350, -1, -1));

        EightRowThirdCol.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        EightRowThirdCol.setForeground(new java.awt.Color(255, 255, 255));
        EightRowThirdCol.setText("E");
        getContentPane().add(EightRowThirdCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 390, -1, -1));

        NinthRowThirdCol.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        NinthRowThirdCol.setForeground(new java.awt.Color(255, 255, 255));
        NinthRowThirdCol.setText("E");
        getContentPane().add(NinthRowThirdCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 420, -1, -1));

        firstRowFourthCol.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        firstRowFourthCol.setForeground(new java.awt.Color(255, 255, 255));
        firstRowFourthCol.setText("E");
        getContentPane().add(firstRowFourthCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 40, -1, -1));

        secondRowFourthCol.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        secondRowFourthCol.setForeground(new java.awt.Color(255, 255, 255));
        secondRowFourthCol.setText("E");
        getContentPane().add(secondRowFourthCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 80, -1, -1));

        thirdRowFourthCol.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        thirdRowFourthCol.setForeground(new java.awt.Color(255, 255, 255));
        thirdRowFourthCol.setText("E");
        getContentPane().add(thirdRowFourthCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 140, -1, -1));

        fourthRowFourthCol.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        fourthRowFourthCol.setForeground(new java.awt.Color(255, 255, 255));
        fourthRowFourthCol.setText("E");
        getContentPane().add(fourthRowFourthCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 200, -1, -1));

        fifthRowFourthCol.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        fifthRowFourthCol.setForeground(new java.awt.Color(255, 255, 255));
        fifthRowFourthCol.setText("E");
        getContentPane().add(fifthRowFourthCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 250, -1, -1));

        sixthRowFourthCol.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        sixthRowFourthCol.setForeground(new java.awt.Color(255, 255, 255));
        sixthRowFourthCol.setText("E");
        getContentPane().add(sixthRowFourthCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 300, -1, -1));

        seventhRowFourthCol.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        seventhRowFourthCol.setForeground(new java.awt.Color(255, 255, 255));
        seventhRowFourthCol.setText("E");
        getContentPane().add(seventhRowFourthCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 350, -1, -1));

        eighthRowFourthCol.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        eighthRowFourthCol.setForeground(new java.awt.Color(255, 255, 255));
        eighthRowFourthCol.setText("E");
        getContentPane().add(eighthRowFourthCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 390, -1, -1));

        ninthRowFourthCol.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        ninthRowFourthCol.setForeground(new java.awt.Color(255, 255, 255));
        ninthRowFourthCol.setText("E");
        getContentPane().add(ninthRowFourthCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 420, -1, -1));

        firstRowFifthCol.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        firstRowFifthCol.setForeground(new java.awt.Color(255, 255, 255));
        firstRowFifthCol.setText("E");
        getContentPane().add(firstRowFifthCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 40, -1, -1));

        secondRowFifthCol.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        secondRowFifthCol.setForeground(new java.awt.Color(255, 255, 255));
        secondRowFifthCol.setText("E");
        getContentPane().add(secondRowFifthCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 90, -1, -1));

        thirdRowFifthCol.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        thirdRowFifthCol.setForeground(new java.awt.Color(255, 255, 255));
        thirdRowFifthCol.setText("E");
        getContentPane().add(thirdRowFifthCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 140, -1, -1));

        fourthRowFifthCol.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        fourthRowFifthCol.setForeground(new java.awt.Color(255, 255, 255));
        fourthRowFifthCol.setText("E");
        getContentPane().add(fourthRowFifthCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 200, -1, -1));

        fifthRowFifthCol.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        fifthRowFifthCol.setForeground(new java.awt.Color(255, 255, 255));
        fifthRowFifthCol.setText("E");
        getContentPane().add(fifthRowFifthCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 250, -1, -1));

        sixthRowFifthCol.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        sixthRowFifthCol.setForeground(new java.awt.Color(255, 255, 255));
        sixthRowFifthCol.setText("E");
        getContentPane().add(sixthRowFifthCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 300, -1, -1));

        seventhRowFifthCol.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        seventhRowFifthCol.setForeground(new java.awt.Color(255, 255, 255));
        seventhRowFifthCol.setText("E");
        getContentPane().add(seventhRowFifthCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 350, -1, -1));

        eigthRowFifthCol.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        eigthRowFifthCol.setForeground(new java.awt.Color(255, 255, 255));
        eigthRowFifthCol.setText("E");
        getContentPane().add(eigthRowFifthCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 390, -1, -1));

        ninthRowFifthCol.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        ninthRowFifthCol.setForeground(new java.awt.Color(255, 255, 255));
        ninthRowFifthCol.setText("E");
        getContentPane().add(ninthRowFifthCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 420, -1, -1));

        firstRowSixthCol.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        firstRowSixthCol.setForeground(new java.awt.Color(255, 255, 255));
        firstRowSixthCol.setText("E");
        getContentPane().add(firstRowSixthCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 40, -1, -1));

        secondRowSixthCol.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        secondRowSixthCol.setForeground(new java.awt.Color(255, 255, 255));
        secondRowSixthCol.setText("E");
        getContentPane().add(secondRowSixthCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 90, -1, -1));

        thirdRowSixthCol.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        thirdRowSixthCol.setForeground(new java.awt.Color(255, 255, 255));
        thirdRowSixthCol.setText("E");
        getContentPane().add(thirdRowSixthCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 140, -1, -1));

        fourthRowSixthCol.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        fourthRowSixthCol.setForeground(new java.awt.Color(255, 255, 255));
        fourthRowSixthCol.setText("E");
        getContentPane().add(fourthRowSixthCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 200, -1, -1));

        fifthRowSixthCol.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        fifthRowSixthCol.setForeground(new java.awt.Color(255, 255, 255));
        fifthRowSixthCol.setText("E");
        getContentPane().add(fifthRowSixthCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 250, -1, -1));

        sixthRowSixthCol.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        sixthRowSixthCol.setForeground(new java.awt.Color(255, 255, 255));
        sixthRowSixthCol.setText("E");
        getContentPane().add(sixthRowSixthCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 300, -1, -1));

        seventhRowSixthCol.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        seventhRowSixthCol.setForeground(new java.awt.Color(255, 255, 255));
        seventhRowSixthCol.setText("E");
        getContentPane().add(seventhRowSixthCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 350, -1, -1));

        eighthRowSixthCol.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        eighthRowSixthCol.setForeground(new java.awt.Color(255, 255, 255));
        eighthRowSixthCol.setText("E");
        getContentPane().add(eighthRowSixthCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 390, -1, -1));

        ninthRowSixthCol.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        ninthRowSixthCol.setForeground(new java.awt.Color(255, 255, 255));
        ninthRowSixthCol.setText("E");
        getContentPane().add(ninthRowSixthCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 420, -1, -1));

        firstRowSeventhCol.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        firstRowSeventhCol.setForeground(new java.awt.Color(255, 255, 255));
        firstRowSeventhCol.setText("E");
        getContentPane().add(firstRowSeventhCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 40, -1, -1));

        secondRowSeventhCol.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        secondRowSeventhCol.setForeground(new java.awt.Color(255, 255, 255));
        secondRowSeventhCol.setText("E");
        getContentPane().add(secondRowSeventhCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 90, -1, -1));

        thirdRowSeventhCol.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        thirdRowSeventhCol.setForeground(new java.awt.Color(255, 255, 255));
        thirdRowSeventhCol.setText("E");
        getContentPane().add(thirdRowSeventhCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 140, -1, -1));

        fourthRowSeventhCol.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        fourthRowSeventhCol.setForeground(new java.awt.Color(255, 255, 255));
        fourthRowSeventhCol.setText("E");
        getContentPane().add(fourthRowSeventhCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 200, -1, -1));

        fifthRowSeventhCol.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        fifthRowSeventhCol.setForeground(new java.awt.Color(255, 255, 255));
        fifthRowSeventhCol.setText("E");
        getContentPane().add(fifthRowSeventhCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 250, -1, -1));

        sixthRowSeventhCol.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        sixthRowSeventhCol.setForeground(new java.awt.Color(255, 255, 255));
        sixthRowSeventhCol.setText("E");
        getContentPane().add(sixthRowSeventhCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 300, -1, -1));

        seventhRowSeventhCol.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        seventhRowSeventhCol.setForeground(new java.awt.Color(255, 255, 255));
        seventhRowSeventhCol.setText("E");
        getContentPane().add(seventhRowSeventhCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 350, -1, -1));

        eightRowSeventhCol.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        eightRowSeventhCol.setForeground(new java.awt.Color(255, 255, 255));
        eightRowSeventhCol.setText("E");
        getContentPane().add(eightRowSeventhCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 390, -1, -1));

        ninthRowSeventhCol.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        ninthRowSeventhCol.setForeground(new java.awt.Color(255, 255, 255));
        ninthRowSeventhCol.setText("E");
        getContentPane().add(ninthRowSeventhCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 420, -1, -1));

        firstRowEighthCol.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        firstRowEighthCol.setForeground(new java.awt.Color(255, 255, 255));
        firstRowEighthCol.setText("E");
        getContentPane().add(firstRowEighthCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 40, -1, -1));

        secondRowEighthCol.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        secondRowEighthCol.setForeground(new java.awt.Color(255, 255, 255));
        secondRowEighthCol.setText("E");
        getContentPane().add(secondRowEighthCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 90, -1, -1));

        thirdRowEighthCol.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        thirdRowEighthCol.setForeground(new java.awt.Color(255, 255, 255));
        thirdRowEighthCol.setText("E");
        getContentPane().add(thirdRowEighthCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 140, -1, -1));

        forthRowEightCol.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        forthRowEightCol.setForeground(new java.awt.Color(255, 255, 255));
        forthRowEightCol.setText("E");
        getContentPane().add(forthRowEightCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 200, -1, -1));

        fifthRowEightCol.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        fifthRowEightCol.setForeground(new java.awt.Color(255, 255, 255));
        fifthRowEightCol.setText("E");
        getContentPane().add(fifthRowEightCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 250, -1, -1));

        sixthRowEightCol.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        sixthRowEightCol.setForeground(new java.awt.Color(255, 255, 255));
        sixthRowEightCol.setText("E");
        getContentPane().add(sixthRowEightCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 300, -1, -1));

        seventhRowEightCol.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        seventhRowEightCol.setForeground(new java.awt.Color(255, 255, 255));
        seventhRowEightCol.setText("E");
        getContentPane().add(seventhRowEightCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 350, -1, -1));

        eighthRowEighthCol.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        eighthRowEighthCol.setForeground(new java.awt.Color(255, 255, 255));
        eighthRowEighthCol.setText("E");
        getContentPane().add(eighthRowEighthCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 390, -1, -1));

        nighthRowEighthCol.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        nighthRowEighthCol.setForeground(new java.awt.Color(255, 255, 255));
        nighthRowEighthCol.setText("E");
        getContentPane().add(nighthRowEighthCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 420, -1, -1));

        firstRowNinthCol.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        firstRowNinthCol.setForeground(new java.awt.Color(255, 255, 255));
        firstRowNinthCol.setText("E");
        getContentPane().add(firstRowNinthCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 50, -1, -1));

        secondRowNinthCol.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        secondRowNinthCol.setForeground(new java.awt.Color(255, 255, 255));
        secondRowNinthCol.setText("E");
        getContentPane().add(secondRowNinthCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 90, -1, -1));

        thirdRowNinthCol.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        thirdRowNinthCol.setForeground(new java.awt.Color(255, 255, 255));
        thirdRowNinthCol.setText("E");
        getContentPane().add(thirdRowNinthCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 140, -1, -1));

        forthRowNinthCol.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        forthRowNinthCol.setForeground(new java.awt.Color(255, 255, 255));
        forthRowNinthCol.setText("E");
        getContentPane().add(forthRowNinthCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 190, -1, -1));

        fifthRowNinthCol.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        fifthRowNinthCol.setForeground(new java.awt.Color(255, 255, 255));
        fifthRowNinthCol.setText("E");
        getContentPane().add(fifthRowNinthCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 250, -1, -1));

        sixthRowNinthCol.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        sixthRowNinthCol.setForeground(new java.awt.Color(255, 255, 255));
        sixthRowNinthCol.setText("E");
        getContentPane().add(sixthRowNinthCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 300, -1, -1));

        seventhRowNinthCol.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        seventhRowNinthCol.setForeground(new java.awt.Color(255, 255, 255));
        seventhRowNinthCol.setText("E");
        getContentPane().add(seventhRowNinthCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 350, -1, -1));

        eighthRowNinthCol.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        eighthRowNinthCol.setForeground(new java.awt.Color(255, 255, 255));
        eighthRowNinthCol.setText("E");
        getContentPane().add(eighthRowNinthCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 390, -1, -1));

        ninthRowNinthCol.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        ninthRowNinthCol.setForeground(new java.awt.Color(255, 255, 255));
        ninthRowNinthCol.setText("E");
        getContentPane().add(ninthRowNinthCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 420, -1, -1));

        Player2ScoreValue.setBackground(new java.awt.Color(255, 255, 255));
        Player2ScoreValue.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        Player2ScoreValue.setForeground(new java.awt.Color(255, 255, 255));
        Player2ScoreValue.setText("0");
        getContentPane().add(Player2ScoreValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 330, 20, -1));

        jButton1.setText("Pass Game");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 390, -1, -1));

        Player1ScoreValue.setBackground(new java.awt.Color(255, 255, 255));
        Player1ScoreValue.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        Player1ScoreValue.setForeground(new java.awt.Color(255, 255, 255));
        Player1ScoreValue.setText("0");
        getContentPane().add(Player1ScoreValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 20, -1));

        Player1Score.setBackground(new java.awt.Color(255, 255, 255));
        Player1Score.setFont(new java.awt.Font("Kohinoor Bangla", 0, 24)); // NOI18N
        Player1Score.setForeground(new java.awt.Color(255, 255, 255));
        Player1Score.setText("Player 1");
        getContentPane().add(Player1Score, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 90, -1));

        Player2Score.setBackground(new java.awt.Color(255, 255, 255));
        Player2Score.setFont(new java.awt.Font("Kohinoor Telugu", 0, 24)); // NOI18N
        Player2Score.setForeground(new java.awt.Color(255, 255, 255));
        Player2Score.setText("Player 2");
        getContentPane().add(Player2Score, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, 90, -1));

        PlayersAvaliableHeading2.setBackground(new java.awt.Color(255, 255, 255));
        PlayersAvaliableHeading2.setFont(new java.awt.Font("Monaco", 0, 24)); // NOI18N
        PlayersAvaliableHeading2.setForeground(new java.awt.Color(255, 153, 0));
        PlayersAvaliableHeading2.setText("Player");
        getContentPane().add(PlayersAvaliableHeading2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 90, -1));

        wallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/GamePanel.png"))); // NOI18N
        wallpaper.setText("jLabel1");
        getContentPane().add(wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 800, 470));

        Player1Score1.setBackground(new java.awt.Color(255, 255, 255));
        Player1Score1.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        Player1Score1.setForeground(new java.awt.Color(255, 255, 255));
        Player1Score1.setText("Player 1");
        getContentPane().add(Player1Score1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 90, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
 client.sendMove("EXIT");

 
 
 
        Map<String, Integer> result = calculateTerritory(boardInfo);
        JOptionPane.showMessageDialog(rootPane, "Game was passed by a certain player BLACK : " + result.get("BLACK") + "WHITE:" + result.get("WHITE"));
         System.exit(0);
        System.out.println("Black Territory: " + result.get("BLACK"));
        System.out.println("White Territory: " + result.get("WHITE"));
        

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void leaveGameBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leaveGameBtnActionPerformed

        int confirm = javax.swing.JOptionPane.showConfirmDialog(
                this, "Are you sure you want to leave the game?", "Confirm Exit", javax.swing.JOptionPane.YES_NO_OPTION);

        if (confirm == javax.swing.JOptionPane.YES_OPTION) {
            client.sendMove("EXIT");
            System.exit(0);
        }

// TODO add your handling code here:
    }//GEN-LAST:event_leaveGameBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GameMainPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameMainPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameMainPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameMainPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameMainPanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel EightRowThirdCol;
    private javax.swing.JLabel EighthRowSecCol;
    private javax.swing.JLabel FifthRowSecCol;
    private javax.swing.JLabel FifthRowThirdCol;
    private javax.swing.JLabel ForthRowLThirdCol;
    private javax.swing.JLabel FourthRowSecCol;
    private javax.swing.JLabel GameLogo;
    private javax.swing.JLabel NinthRowSecCol;
    private javax.swing.JLabel NinthRowThirdCol;
    private javax.swing.JLabel Player1Score;
    private javax.swing.JLabel Player1Score1;
    private javax.swing.JLabel Player1ScoreValue;
    private javax.swing.JLabel Player2Score;
    private javax.swing.JLabel Player2ScoreValue;
    private javax.swing.JLabel PlayersAvaliableHeading2;
    private javax.swing.JLabel Scores;
    private javax.swing.JLabel SeventhRowSecCol;
    private javax.swing.JLabel SeventhRowThirdCol;
    private javax.swing.JLabel SixthRowSecCol;
    private javax.swing.JLabel SixthRowThirdCol;
    private javax.swing.JLabel ThirdRowSecCol;
    private javax.swing.JLabel ThirdRowThirdCol;
    private javax.swing.JLabel eightRowSeventhCol;
    private javax.swing.JLabel eighthRowEighthCol;
    private javax.swing.JLabel eighthRowFirstCol;
    private javax.swing.JLabel eighthRowFourthCol;
    private javax.swing.JLabel eighthRowNinthCol;
    private javax.swing.JLabel eighthRowSixthCol;
    private javax.swing.JLabel eigthRowFifthCol;
    private javax.swing.JLabel fifthRowEightCol;
    private javax.swing.JLabel fifthRowFifthCol;
    private javax.swing.JLabel fifthRowFirstCol;
    private javax.swing.JLabel fifthRowFourthCol;
    private javax.swing.JLabel fifthRowNinthCol;
    private javax.swing.JLabel fifthRowSeventhCol;
    private javax.swing.JLabel fifthRowSixthCol;
    private javax.swing.JLabel firstColfirRow;
    private javax.swing.JLabel firstPlayerName;
    private javax.swing.JLabel firstRowEighthCol;
    private javax.swing.JLabel firstRowFifthCol;
    private javax.swing.JLabel firstRowFourthCol;
    private javax.swing.JLabel firstRowNinthCol;
    private javax.swing.JLabel firstRowSecCol;
    private javax.swing.JLabel firstRowSeventhCol;
    private javax.swing.JLabel firstRowSixthCol;
    private javax.swing.JLabel firstRowThirdCol;
    private javax.swing.JLabel forthRowEightCol;
    private javax.swing.JLabel forthRowNinthCol;
    private javax.swing.JLabel fourthRowFifthCol;
    private javax.swing.JLabel fourthRowFirstCol;
    private javax.swing.JLabel fourthRowFourthCol;
    private javax.swing.JLabel fourthRowSeventhCol;
    private javax.swing.JLabel fourthRowSixthCol;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton leaveGameBtn;
    private javax.swing.JLabel nighthRowEighthCol;
    private javax.swing.JLabel ninthRowFifthCol;
    private javax.swing.JLabel ninthRowFirstCol;
    private javax.swing.JLabel ninthRowFourthCol;
    private javax.swing.JLabel ninthRowNinthCol;
    private javax.swing.JLabel ninthRowSeventhCol;
    private javax.swing.JLabel ninthRowSixthCol;
    private javax.swing.JLabel secondRowEighthCol;
    private javax.swing.JLabel secondRowFifthCol;
    private javax.swing.JLabel secondRowFirstCol;
    private javax.swing.JLabel secondRowFourthCol;
    private javax.swing.JLabel secondRowNinthCol;
    private javax.swing.JLabel secondRowSecCol;
    private javax.swing.JLabel secondRowSeventhCol;
    private javax.swing.JLabel secondRowSixthCol;
    private javax.swing.JLabel secondRowThirdCol;
    private javax.swing.JLabel seventhRowEightCol;
    private javax.swing.JLabel seventhRowFifthCol;
    private javax.swing.JLabel seventhRowFirstCol;
    private javax.swing.JLabel seventhRowFourthCol;
    private javax.swing.JLabel seventhRowNinthCol;
    private javax.swing.JLabel seventhRowSeventhCol;
    private javax.swing.JLabel seventhRowSixthCol;
    private javax.swing.JLabel sixthRowEightCol;
    private javax.swing.JLabel sixthRowFifthCol;
    private javax.swing.JLabel sixthRowFirstCol;
    private javax.swing.JLabel sixthRowFourthCol;
    private javax.swing.JLabel sixthRowNinthCol;
    private javax.swing.JLabel sixthRowSeventhCol;
    private javax.swing.JLabel sixthRowSixthCol;
    private javax.swing.JLabel thirdRowEighthCol;
    private javax.swing.JLabel thirdRowFifthCol;
    private javax.swing.JLabel thirdRowFirstCol;
    private javax.swing.JLabel thirdRowFourthCol;
    private javax.swing.JLabel thirdRowNinthCol;
    private javax.swing.JLabel thirdRowSeventhCol;
    private javax.swing.JLabel thirdRowSixthCol;
    private javax.swing.JLabel wallpaper;
    // End of variables declaration//GEN-END:variables
}
