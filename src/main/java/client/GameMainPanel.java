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

/**
 *
 * @author macbook
 */
public class GameMainPanel extends javax.swing.JFrame {
private boolean isBlackTurn = true;
private GameClient client;
private String playerColor;
private boolean isMyTurn;


  
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
    
client = new GameClient(this);

    initializeLabelGrid();
    initializeBoard();

    
    
    }

    private JLabel[][] labelGrid = new JLabel[9][9];
    private Point[][] boardInfo = new Point[9][9];

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
        
          labelGrid[7][0] = fifthRowEightCol;
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

    
    public void pointNeigboursInitilizer(){
    
        System.out.println("i am called ");
        for (int i = 0; i <9; i++) {
            for (int j = 0; j < 9; j++) {
                
                
                Point p = boardInfo[i][j];
                p.up = (i>0)? boardInfo[i-1][j] : null;
                p.down = (i<8) ? boardInfo [i+1][j]:null;
                p.left = (j>0)? boardInfo[i][j-1] :null;
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
    return (point.up != null && point.up.state.equals("EMPTY")) ||
           (point.down != null && point.down.state.equals("EMPTY")) ||
           (point.left != null && point.left.state.equals("EMPTY")) ||
           (point.right != null && point.right.state.equals("EMPTY"));
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
            if (current.up != null && !group.contains(current.up)) stack.push(current.up);
            if (current.down != null && !group.contains(current.down)) stack.push(current.down);
            if (current.left != null && !group.contains(current.left)) stack.push(current.left);
            if (current.right != null && !group.contains(current.right)) stack.push(current.right);
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

        if (r < 0 || r >= rows || c < 0 || c >= cols || visited[r][c]) continue;
        visited[r][c] = true;

        if (!board[r][c].state.equals("EMPTY")) {
            surroundingColors.add(board[r][c].state);
            continue;
        }

        region.add(board[r][c]);

        // check 4 directions
        if (r > 0) stack.push(board[r - 1][c]);
        if (r < rows - 1) stack.push(board[r + 1][c]);
        if (c > 0) stack.push(board[r][c - 1]);
        if (c < cols - 1) stack.push(board[r][c + 1]);
    }
}



private void findTerritory(Point point, boolean[][] visited, Set<Point> region, Set<String> borderingColors) {
    Stack<Point> stack = new Stack<>();
    stack.push(point);

    while (!stack.isEmpty()) {
        Point current = stack.pop();
        if (visited[current.row][current.col]) continue;

        visited[current.row][current.col] = true;
        region.add(current);

        Point[] neighbors = {current.up, current.down, current.left, current.right};

        for (Point neighbor : neighbors) {
            if (neighbor == null) continue;
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

public void receiveMove(String move) {
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

        PlayersAvaliableHeading = new javax.swing.JLabel();
        listOfPlayers = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        GameLogo = new javax.swing.JLabel();
        leaveGameBtn = new javax.swing.JButton();
        player1Name = new javax.swing.JLabel();
        VSlogo = new javax.swing.JLabel();
        player2Name = new javax.swing.JLabel();
        TeamColorLabel = new javax.swing.JLabel();
        StoneColor = new javax.swing.JLabel();
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
        jButton1 = new javax.swing.JButton();
        wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PlayersAvaliableHeading.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        PlayersAvaliableHeading.setText("Players");
        getContentPane().add(PlayersAvaliableHeading, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 90, -1));

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listOfPlayers.setViewportView(jList1);

        getContentPane().add(listOfPlayers, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 60, -1));

        GameLogo.setBackground(new java.awt.Color(255, 255, 255));
        GameLogo.setFont(new java.awt.Font("Helvetica Neue", 0, 36)); // NOI18N
        GameLogo.setForeground(new java.awt.Color(255, 255, 255));
        GameLogo.setText(" GO - X Pro Game");
        getContentPane().add(GameLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 320, -1));

        leaveGameBtn.setText("Leave game");
        getContentPane().add(leaveGameBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, -1, -1));

        player1Name.setText("player2");
        getContentPane().add(player1Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 160, -1, -1));

        VSlogo.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        VSlogo.setText("VS");
        getContentPane().add(VSlogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, -1, -1));

        player2Name.setText("player1");
        getContentPane().add(player2Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, -1, -1));

        TeamColorLabel.setText("Stone Color ");
        getContentPane().add(TeamColorLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, -1, -1));

        StoneColor.setText("WHITE");
        getContentPane().add(StoneColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 200, -1, -1));

        firstColfirRow.setText("empty");
        getContentPane().add(firstColfirRow, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, -1, -1));

        secondRowFirstCol.setText("empty");
        getContentPane().add(secondRowFirstCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 70, -1, -1));

        thirdRowFirstCol.setText("empty");
        getContentPane().add(thirdRowFirstCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 130, -1, -1));

        fourthRowFirstCol.setText("empty");
        getContentPane().add(fourthRowFirstCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 190, -1, -1));

        fifthRowFirstCol.setText("empty");
        getContentPane().add(fifthRowFirstCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 250, -1, -1));

        sixthRowFirstCol.setText("empty");
        getContentPane().add(sixthRowFirstCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 430, -1, -1));

        seventhRowFirstCol.setText("empty");
        getContentPane().add(seventhRowFirstCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 310, -1, -1));

        eighthRowFirstCol.setText("empty");
        getContentPane().add(eighthRowFirstCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 350, -1, -1));

        ninthRowFirstCol.setText("empty");
        getContentPane().add(ninthRowFirstCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 400, -1, -1));

        firstRowSecCol.setText("empty");
        getContentPane().add(firstRowSecCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, -1, -1));

        secondRowSecCol.setText("empty");
        getContentPane().add(secondRowSecCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 70, -1, -1));

        ThirdRowSecCol.setText("empty");
        getContentPane().add(ThirdRowSecCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 130, -1, -1));

        FourthRowSecCol.setText("empty");
        getContentPane().add(FourthRowSecCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 190, -1, -1));

        FifthRowSecCol.setText("empty");
        getContentPane().add(FifthRowSecCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 250, -1, -1));

        SixthRowSecCol.setText("empty");
        getContentPane().add(SixthRowSecCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 310, -1, -1));

        SeventhRowSecCol.setText("empty");
        getContentPane().add(SeventhRowSecCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 350, -1, -1));

        EighthRowSecCol.setText("empty");
        getContentPane().add(EighthRowSecCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 400, -1, -1));

        NinthRowSecCol.setText("empty");
        getContentPane().add(NinthRowSecCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 430, -1, -1));

        firstRowThirdCol.setText("empty");
        getContentPane().add(firstRowThirdCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, -1, -1));

        secondRowThirdCol.setText("empty");
        getContentPane().add(secondRowThirdCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 70, -1, -1));

        ThirdRowThirdCol.setText("empty");
        getContentPane().add(ThirdRowThirdCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 130, -1, -1));

        ForthRowLThirdCol.setText("empty");
        getContentPane().add(ForthRowLThirdCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 190, -1, -1));

        FifthRowThirdCol.setText("empty");
        getContentPane().add(FifthRowThirdCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 250, -1, -1));

        SixthRowThirdCol.setText("empty");
        getContentPane().add(SixthRowThirdCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 310, -1, -1));

        SeventhRowThirdCol.setText("empty");
        getContentPane().add(SeventhRowThirdCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 350, -1, -1));

        EightRowThirdCol.setText("empty");
        getContentPane().add(EightRowThirdCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 400, -1, -1));

        NinthRowThirdCol.setText("empty");
        getContentPane().add(NinthRowThirdCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 430, -1, -1));

        firstRowFourthCol.setText("empty");
        getContentPane().add(firstRowFourthCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 30, -1, -1));

        secondRowFourthCol.setText("empty");
        getContentPane().add(secondRowFourthCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 70, -1, -1));

        thirdRowFourthCol.setText("empry");
        getContentPane().add(thirdRowFourthCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 130, -1, -1));

        fourthRowFourthCol.setText("empty");
        getContentPane().add(fourthRowFourthCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 190, -1, -1));

        fifthRowFourthCol.setText("empty");
        getContentPane().add(fifthRowFourthCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 250, -1, -1));

        sixthRowFourthCol.setText("empty");
        getContentPane().add(sixthRowFourthCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 310, -1, -1));

        seventhRowFourthCol.setText("empty");
        getContentPane().add(seventhRowFourthCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 350, -1, -1));

        eighthRowFourthCol.setText("empty");
        getContentPane().add(eighthRowFourthCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 400, -1, -1));

        ninthRowFourthCol.setText("empty");
        getContentPane().add(ninthRowFourthCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 430, -1, -1));

        firstRowFifthCol.setText("empty");
        getContentPane().add(firstRowFifthCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 30, -1, -1));

        secondRowFifthCol.setText("emprt");
        getContentPane().add(secondRowFifthCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 70, -1, -1));

        thirdRowFifthCol.setText("empty");
        getContentPane().add(thirdRowFifthCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 130, -1, -1));

        fourthRowFifthCol.setText("empty");
        getContentPane().add(fourthRowFifthCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 190, -1, -1));

        fifthRowFifthCol.setText("empty");
        getContentPane().add(fifthRowFifthCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 250, -1, -1));

        sixthRowFifthCol.setText("empty");
        getContentPane().add(sixthRowFifthCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 310, -1, -1));

        seventhRowFifthCol.setText("emprt");
        getContentPane().add(seventhRowFifthCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 350, -1, -1));

        eigthRowFifthCol.setText("empty");
        getContentPane().add(eigthRowFifthCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 400, -1, -1));

        ninthRowFifthCol.setText("empty");
        getContentPane().add(ninthRowFifthCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 430, -1, -1));

        firstRowSixthCol.setText("empty");
        getContentPane().add(firstRowSixthCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 30, -1, -1));

        secondRowSixthCol.setText("empty");
        getContentPane().add(secondRowSixthCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 70, -1, -1));

        thirdRowSixthCol.setText("empty");
        getContentPane().add(thirdRowSixthCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 130, -1, -1));

        fourthRowSixthCol.setText("empty");
        getContentPane().add(fourthRowSixthCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 190, -1, -1));

        fifthRowSixthCol.setText("empty");
        getContentPane().add(fifthRowSixthCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 250, -1, -1));

        sixthRowSixthCol.setText("empty");
        getContentPane().add(sixthRowSixthCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 310, -1, -1));

        seventhRowSixthCol.setText("empty");
        getContentPane().add(seventhRowSixthCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 350, -1, -1));

        eighthRowSixthCol.setText("empty");
        getContentPane().add(eighthRowSixthCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 400, -1, -1));

        ninthRowSixthCol.setText("empty");
        getContentPane().add(ninthRowSixthCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 430, -1, -1));

        firstRowSeventhCol.setText("empty");
        getContentPane().add(firstRowSeventhCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 30, -1, -1));

        secondRowSeventhCol.setText("empty");
        getContentPane().add(secondRowSeventhCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 70, -1, -1));

        thirdRowSeventhCol.setText("empty");
        getContentPane().add(thirdRowSeventhCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 130, -1, -1));

        fourthRowSeventhCol.setText("empty");
        getContentPane().add(fourthRowSeventhCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 190, -1, -1));

        fifthRowSeventhCol.setText("empty");
        getContentPane().add(fifthRowSeventhCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 250, -1, -1));

        sixthRowSeventhCol.setText("empty");
        getContentPane().add(sixthRowSeventhCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 310, -1, -1));

        seventhRowSeventhCol.setText("empty");
        getContentPane().add(seventhRowSeventhCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 350, -1, -1));

        eightRowSeventhCol.setText("empty");
        getContentPane().add(eightRowSeventhCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 400, -1, -1));

        ninthRowSeventhCol.setText("empty");
        getContentPane().add(ninthRowSeventhCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 430, -1, -1));

        firstRowEighthCol.setText("empty");
        getContentPane().add(firstRowEighthCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 30, -1, -1));

        secondRowEighthCol.setText("empty");
        getContentPane().add(secondRowEighthCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 70, -1, -1));

        thirdRowEighthCol.setText("empty");
        getContentPane().add(thirdRowEighthCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 130, -1, -1));

        forthRowEightCol.setText("empty");
        getContentPane().add(forthRowEightCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 190, -1, -1));

        fifthRowEightCol.setText("empty");
        getContentPane().add(fifthRowEightCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 250, -1, -1));

        sixthRowEightCol.setText("empty");
        getContentPane().add(sixthRowEightCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 310, -1, -1));

        seventhRowEightCol.setText("empt");
        getContentPane().add(seventhRowEightCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 350, -1, -1));

        eighthRowEighthCol.setText("empty");
        getContentPane().add(eighthRowEighthCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 400, -1, -1));

        nighthRowEighthCol.setText("empty");
        getContentPane().add(nighthRowEighthCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 430, -1, -1));

        firstRowNinthCol.setText("empty");
        getContentPane().add(firstRowNinthCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 30, -1, -1));

        secondRowNinthCol.setText("empty");
        getContentPane().add(secondRowNinthCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 70, -1, -1));

        thirdRowNinthCol.setText("empty");
        getContentPane().add(thirdRowNinthCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 130, -1, -1));

        forthRowNinthCol.setText("empty");
        getContentPane().add(forthRowNinthCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 190, -1, -1));

        fifthRowNinthCol.setText("empty");
        getContentPane().add(fifthRowNinthCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 250, -1, -1));

        sixthRowNinthCol.setText("empty");
        getContentPane().add(sixthRowNinthCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 310, -1, -1));

        seventhRowNinthCol.setText("empty");
        getContentPane().add(seventhRowNinthCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 350, -1, -1));

        eighthRowNinthCol.setText("empty");
        getContentPane().add(eighthRowNinthCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 400, -1, -1));

        ninthRowNinthCol.setText("empty");
        getContentPane().add(ninthRowNinthCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 430, -1, -1));

        jButton1.setText("Pass Game");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 410, -1, -1));

        wallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/GamePanel.png"))); // NOI18N
        wallpaper.setText("jLabel1");
        getContentPane().add(wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 880, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed



Map<String, Integer> result = calculateTerritory(boardInfo);
System.out.println("Black Territory: " + result.get("BLACK"));
System.out.println("White Territory: " + result.get("WHITE"));



        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

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
    private javax.swing.JLabel PlayersAvaliableHeading;
    private javax.swing.JLabel SeventhRowSecCol;
    private javax.swing.JLabel SeventhRowThirdCol;
    private javax.swing.JLabel SixthRowSecCol;
    private javax.swing.JLabel SixthRowThirdCol;
    private javax.swing.JLabel StoneColor;
    private javax.swing.JLabel TeamColorLabel;
    private javax.swing.JLabel ThirdRowSecCol;
    private javax.swing.JLabel ThirdRowThirdCol;
    private javax.swing.JLabel VSlogo;
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
    private javax.swing.JList<String> jList1;
    private javax.swing.JButton leaveGameBtn;
    private javax.swing.JScrollPane listOfPlayers;
    private javax.swing.JLabel nighthRowEighthCol;
    private javax.swing.JLabel ninthRowFifthCol;
    private javax.swing.JLabel ninthRowFirstCol;
    private javax.swing.JLabel ninthRowFourthCol;
    private javax.swing.JLabel ninthRowNinthCol;
    private javax.swing.JLabel ninthRowSeventhCol;
    private javax.swing.JLabel ninthRowSixthCol;
    private javax.swing.JLabel player1Name;
    private javax.swing.JLabel player2Name;
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
