package org.obstacles.models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board(8);
        board.initBoard();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getFinishFieldInfo() {
        //given

        //when
        board.setBoardObjects();
        //then
        assertEquals("F", board.getFieldInfo(board.getFinishPosition().getRow(), board.getFinishPosition().getCol()));
    }

    @Test
    void setPlayerPosition() {
        //given

        //when
        board.setPlayerPosition(0, 0);
        //then
        assertEquals("X", board.getFieldInfo(0, 0));
    }

    @Test
    void initBoard() {
        //given

        //when
        board.initBoard();
        //then
        assertEquals("_", board.getFieldInfo(0, 0));
    }

    @Test
    void setBoardObjects() {
        //given

        //when
        board.setBoardObjects();
        //then
        assertTrue(List.of("X", "_", "M", "H", "L").contains(board.getFieldInfo(5, 5)));
    }
}