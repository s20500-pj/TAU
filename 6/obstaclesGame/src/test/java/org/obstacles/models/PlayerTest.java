package org.obstacles.models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.obstacles.exceptions.OutsideMapException;
import org.obstacles.exceptions.WrongMoveException;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    private Player player;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        player = new Player("name");
        player.initTheGame(8);
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void moveLeftUntilTheEdge() {
        //given

        //when

        //then
        assertThrows(OutsideMapException.class, () -> player.move('a'));
    }

    @Test
    public void moveUpUntilTheEdge() {
        //given
        this.player.getBoard().setPlayerPosition(0, 0);
        //when

        //then
        assertThrows(OutsideMapException.class, () -> player.move('w'));
    }

    @Test
    void moveToFindObstacle() {
        //given
        Position obstaclePosition = new Position();
        List<String> obstacleList = List.of("M", "H", "L");
        //when
        for (int i = 1; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                if (obstacleList.contains(player.getBoard().getFieldInfo(i, j))) {
                    obstaclePosition.setPosition(i, j);
                    break;
                }
            }
        }
        player.getBoard().setPlayerPosition(obstaclePosition.getRow() - 1, obstaclePosition.getCol());
        //then
        assertThrows(WrongMoveException.class, () -> player.move('s'));
    }

    @Test
    void checkWinCondition() {
        //given
        player.getBoard().setPlayerPosition(player.getBoard().getFinishPosition().getRow(), player.getBoard().getFinishPosition().getCol() - 1);
        //when
        player.move('d');
        //then
        assertEquals("YOU WONNumber of moves 1", outContent.toString().replaceAll("\n", "").replaceAll("\r", ""));
    }
}