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
    @Getter
    private Position playerPosition;
    @Getter
    private Position finishPosition;

    public Board(int boardSize) {
        this.boardSize = boardSize;
        this.playerPosition = new Position();
        this.finishPosition = new Position();
    }

    public void initBoard() {
        board = new String[boardSize][boardSize];
        for (int i = 0; i < boardSize; i++) {
            Arrays.fill(board[i], UNDERSCORE);
        }
    }

    public void setBoardObjects() {
        Random rand = new Random();
        fillObstacles();
        setFinishPosition(rand.nextInt(boardSize), boardSize - 1);
        setPlayerPosition(rand.nextInt(boardSize), 0);
        clearFieldsNextToFinishAndStart();
    }

    private void fillObstacles() {
        for (int i = 1; i < boardSize; ++i) {
            for (int j = 0; j < boardSize; ++j) {
                board[i][j] = getRandomObstacle();
            }
        }
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

    public void setPlayerPosition(int row, int col) {
        board[playerPosition.getRow()][playerPosition.getCol()] = UNDERSCORE;
        playerPosition.setPosition(row, col);
        board[row][col] = X;
    }

    private void setFinishPosition(int row, int col) {
        finishPosition.setPosition(row, col);
        board[row][col] = F;
    }

    private void clearFieldsNextToFinishAndStart() {
        board[playerPosition.getRow()][playerPosition.getCol() + 1] = UNDERSCORE;
        board[finishPosition.getRow()][finishPosition.getCol() - 1] = UNDERSCORE;
    }
}
