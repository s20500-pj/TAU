package org.obstacles.models;

import lombok.Getter;
import org.obstacles.exceptions.InvalidInputException;
import org.obstacles.exceptions.OutsideMapException;
import org.obstacles.exceptions.WrongMoveException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Player {
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    @Getter
    private final String name;
    @Getter
    private Board board;
    private Position finishPosition;
    private final List<String> obstacleList = List.of("M", "H", "L");
    private boolean finish = false;
    private int numberOfMoves = 0;

    public Player(String name) {
        this.name = name;
    }

    public void initTheGame(int boardSize) {
        this.board = new Board(boardSize);
        this.board.initBoard();
        this.board.setBoardObjects();
        this.finishPosition = this.board.getFinishPosition();
    }

    public void move(char direction) {
        int currentRow = this.board.getPlayerPosition().getRow();
        int currentCol = this.board.getPlayerPosition().getCol();
        switch (Character.toLowerCase(direction)) {
            case 'w' -> {
                if (currentRow - 1 < 0) {
                    throw new OutsideMapException("Can't move outside map");
                }
                if (obstacleList.contains(this.board.getFieldInfo(currentRow - 1, currentCol))) {
                    throw new WrongMoveException("Can't move, there is an obstacle");
                }
                currentRow--;
            }
            case 'a' -> {
                if (currentCol - 1 < 0) {
                    throw new OutsideMapException("Can't move outside map");
                }
                if (obstacleList.contains(this.board.getFieldInfo(currentRow, currentCol - 1))) {
                    throw new WrongMoveException("Can't move, there is an obstacle");
                }
                currentCol--;
            }
            case 's' -> {
                if (currentRow + 1 > board.getBoardSize() - 1) {
                    throw new OutsideMapException("Can't move outside map");
                }
                if (obstacleList.contains(this.board.getFieldInfo(currentRow + 1, currentCol))) {
                    throw new WrongMoveException("Can't move, there is an obstacle");
                }
                currentRow++;
            }
            case 'd' -> {
                if (currentCol + 1 > board.getBoardSize() - 1) {
                    throw new OutsideMapException("Can't move outside map");
                }
                if (obstacleList.contains(this.board.getFieldInfo(currentRow, currentCol + 1))) {
                    throw new WrongMoveException("Can't move, there is an obstacle");
                }
                currentCol++;
            }
            default -> throw new InvalidInputException("Invalid input, try again");
        }
        board.setPlayerPosition(currentRow, currentCol);
        numberOfMoves++;
        if (currentRow == this.finishPosition.getRow() && currentCol == this.finishPosition.getCol()) {
            System.out.println("YOU WON");
            System.out.println("Number of moves " + numberOfMoves);
            finish = true;
        }
    }

    public void play(int boardSize) throws IOException {
        initTheGame(boardSize);
        String readline;
        char key = 0;
        while (!this.finish) {
            board.printBoard();
            readline = reader.readLine();
            if (readline.length() > 0) {
                key = readline.charAt(0);
            }
            if (Character.toLowerCase(key) == 'q') {
                System.exit(-1);
            }
            try {
                move(key);
            } catch (OutsideMapException | WrongMoveException | InvalidInputException e) {
                System.out.println(e.getMessage());
                System.out.println();
            }
        }
    }
}
