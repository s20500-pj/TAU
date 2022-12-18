package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PlayerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlayerApplication.class, args);
    }

    private Long id;
    private String name;
    private int age;
    private int health;
    private int attack;
    private int defense;
    private int level;

    public int attackPlayer(int power) {
        checkPower(power);
        this.health -= power;
        return this.health;
    }

    public int healthPlayer(int healthPower) {
        checkPower(healthPower);
        this.health += healthPower;
        return health;
    }

    public void breakDefense(int attack) {
        checkPower(attack);
        this.defense -= attack;
    }

    public boolean doesPlayerExists(Long playerId) {
        return id.equals(playerId);
    }

    public int getFullPowerOfPlayer() {
        return getHealth() + getAttack() + getDefense();
    }

    public boolean isPlayerDead() {
        return health < 0;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", health=" + health +
                ", attack=" + attack +
                ", defense=" + defense +
                ", level=" + level +
                '}';
    }

    private void checkPower(int power) {
        if (power < 0) {
            throw new IllegalArgumentException("Power can't be less than null");
        }
    }
}
