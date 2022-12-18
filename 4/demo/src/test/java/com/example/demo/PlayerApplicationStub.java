package com.example.demo;

public class PlayerApplicationStub extends PlayerApplication {
    private final PlayerApplication playerApplication = new PlayerApplication(1L, "name", 20, 100, 100, 100, 100);

    @Override
    public Long getId() {
        return playerApplication.getId();
    }

    @Override
    public String getName() {
        return playerApplication.getName();
    }

    @Override
    public int getAge() {
        return playerApplication.getAge();
    }

    @Override
    public int getHealth() {
        return playerApplication.getHealth();
    }

    @Override
    public int getAttack() {
        return playerApplication.getAttack();
    }

    @Override
    public int getDefense() {
        return playerApplication.getDefense();
    }

    @Override
    public int getLevel() {
        return playerApplication.getLevel();
    }

    @Override
    public void setId(Long id) {
        playerApplication.setId(id);
    }

    @Override
    public void setName(String name) {
        playerApplication.setName(name);
    }

    @Override
    public void setAge(int age) {
        playerApplication.setAge(age);
    }

    @Override
    public void setHealth(int health) {
        playerApplication.setHealth(health);
    }

    @Override
    public void setAttack(int attack) {
        playerApplication.setAttack(attack);
    }

    @Override
    public void setDefense(int defense) {
        playerApplication.setDefense(defense);
    }

    @Override
    public void setLevel(int level) {
        playerApplication.setLevel(level);
    }

    @Override
    public int attackPlayer(int power) {
        if (power < 0) {
            throw new IllegalArgumentException("Power can't be less than null");
        }
        return playerApplication.getHealth() - power;
    }

    @Override
    public int healthPlayer(int healthPower) {
        if (healthPower < 0) {
            throw new IllegalArgumentException("Power can't be less than null");
        }
        return playerApplication.getHealth() + healthPower;
    }


    @Override
    public boolean doesPlayerExists(Long playerId) {
        return playerApplication.getId().equals(playerId);
    }

    @Override
    public int getFullPowerOfPlayer() {
        return playerApplication.getHealth() + playerApplication.getAttack() + playerApplication.getDefense();
    }

    @Override
    public boolean isPlayerDead() {
        return playerApplication.getHealth() <0;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + playerApplication.getName() + '\'' +
                ", age=" + playerApplication.getAge() +
                ", health=" + playerApplication.getHealth() +
                ", attack=" + playerApplication.getAttack() +
                ", defense=" + playerApplication.getDefense() +
                ", level=" + playerApplication.getLevel() +
                '}';
    }
}
