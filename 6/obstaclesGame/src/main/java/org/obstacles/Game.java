package org.obstacles;

import org.obstacles.models.Player;

import java.io.IOException;

public class Game {
    public static void main(String[] args) throws IOException {
        Player player = new Player("John");
        System.out.println("The player is marked as X, you have to reach F field to finish the game");
        System.out.println("Obstacles are marked as H,M,L (hill, mountain, lake), avoid them");
        System.out.println("Allowed moves: w,s,a,d");
        System.out.println("To quit the game press: q");
        System.out.println("You play as " + player.getName());
        System.out.println();
        player.play(8);
    }
}
