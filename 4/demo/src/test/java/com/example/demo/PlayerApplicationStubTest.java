package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerApplicationStubTest {
    PlayerApplicationStub playerApplicationStub;

    @BeforeEach
    public void setUp(){
        playerApplicationStub = new PlayerApplicationStub();
    }

    @Test
    void attackPlayer() {
        playerApplicationStub.setHealth(100);
        int health = playerApplicationStub.attackPlayer(20);
        assertEquals(health, 80);
    }

    @Test
    void healthPlayer() {
        playerApplicationStub.setHealth(100);
        int health = playerApplicationStub.healthPlayer(150);
        assertEquals(health, 250);
    }

    @Test
    void doesPlayerExists() {
        assertTrue(playerApplicationStub.doesPlayerExists(1L));
    }

    @Test
    void getFullPowerOfPlayer() {
        assertEquals(playerApplicationStub.getFullPowerOfPlayer(), 300);
    }

    @Test
    void isPlayerDead() {
        assertFalse(playerApplicationStub.isPlayerDead());
    }

    @Test
    void testToString() {
        assertEquals(playerApplicationStub.toString(), "Player{" +
                "name='" + "name" + '\'' +
                ", age=" + 20 +
                ", health=" + 100 +
                ", attack=" + 100 +
                ", defense=" + 100 +
                ", level=" + 100 +
                '}');
    }

    @Test
    void shouldThrowError() {
        assertThrows(IllegalArgumentException.class, () -> playerApplicationStub.attackPlayer(-1));
    }

}
