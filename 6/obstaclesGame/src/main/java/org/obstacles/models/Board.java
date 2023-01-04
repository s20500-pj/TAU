package org.obstacles.models;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.Random;

@NoArgsConstructor
public class Board {

    public static final String X = "X";
    public static final String M = "M";
    public static final String L = "L";
    public static final String H = "H";
    public static final String F = "F";
    public static final String UNDERSCORE = "_";

    private String[][] board;
    @Getter
    private int boardSize;
    private Position playerPosition;

    public Board(int boardSize) {
        this.boardSize = boardSize;
        initBoard();
        this.playerPosition = new Position();
    }

    private void initBoard() {
        board = new String[boardSize][boardSize];
        for (int i = 0; i < boardSize; i++) {
            Arrays.fill(board[i], UNDERSCORE);
        }
        setBoardObjects();
    }

    private void setBoardObjects() {
        board[0][0] = X;
        fillObstacles();
        board[boardSize - 1][boardSize - 1] = F;
    }

    private void fillObstacles() {
        for (int i = 1; i < boardSize; ++i) {
            for (int j = 0; j < boardSize; ++j) {
                board[i][j] = getRandomObstacle();
            }
        }
        board[0][1]=UNDERSCORE;
        board[1][0]=UNDERSCORE;
        board[boardSize-2][boardSize-1]=UNDERSCORE;
        board[boardSize-1][boardSize-2]=UNDERSCORE;
    }

    private String getRandomObstacle() {
        Random rand = new Random();
        if (rand.nextInt(8) == 0) {
            return H;
        } else if (rand.nextInt(8) == 1) {
            return L;
        } else if (rand.nextInt(8) == 2) {
            return M;
        } else {
            return UNDERSCORE;
        }
    }

    public void printBoard() {
        for (String[] i : board) {
            System.out.println(Arrays.toString(i));
        }
    }

    public String getFieldInfo(int row, int col) {
        return board[row][col];
    }

    public Position getPlayerPosition() {
        return this.playerPosition;
    }

    public void setPlayerPosition(int row, int col) {
        this.board[playerPosition.getRow()][playerPosition.getCol()] = UNDERSCORE;
        this.playerPosition.setRow(row);
        this.playerPosition.setCol(col);
        this.board[row][col] = X;
    }
}
