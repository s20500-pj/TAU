package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class PlayerApplicationTest {

    @Mock
    PlayerApplication playerApplication;

    @Test
    void attackPlayer() {
        playerApplication.setHealth(100);
        when(playerApplication.attackPlayer(20)).thenReturn(80);
        int health = playerApplication.attackPlayer(20);
        assertEquals(health, 80);
    }

    @Test
    void healthPlayer() {
        playerApplication.setHealth(100);
        when(playerApplication.healthPlayer(150)).thenReturn(250);
        int health = playerApplication.healthPlayer(150);
        assertEquals(health, 250);
    }

    @Test
    void doesPlayerExists() {
        playerApplication.setId(1L);
        when(playerApplication.doesPlayerExists(1L)).thenReturn(true);
        assertTrue(playerApplication.doesPlayerExists(1L));
    }

    @Test
    void getFullPowerOfPlayer() {
        when(playerApplication.getFullPowerOfPlayer()).thenReturn(300);
        assertEquals(playerApplication.getFullPowerOfPlayer(), 300);
    }

    @Test
    void isPlayerDead() {
        when(playerApplication.isPlayerDead()).thenReturn(false);
        assertFalse(playerApplication.isPlayerDead());
    }

    @Test
    void testToString() {
        when(playerApplication.toString()).thenReturn("Player{" +
                "name='" + "name" + '\'' +
                ", age=" + 10 +
                ", health=" + 100 +
                ", attack=" + 10 +
                ", defense=" + 20 +
                ", level=" + 5 +
                '}');
        assertEquals(playerApplication.toString(), "Player{" +
                "name='" + "name" + '\'' +
                ", age=" + 10 +
                ", health=" + 100 +
                ", attack=" + 10 +
                ", defense=" + 20 +
                ", level=" + 5 +
                '}');
    }

    @Test
    void shouldThrowError() {
        when(playerApplication.attackPlayer(-1)).thenThrow(IllegalArgumentException.class);
        assertThrows(IllegalArgumentException.class, () -> playerApplication.attackPlayer(-1));
    }
}