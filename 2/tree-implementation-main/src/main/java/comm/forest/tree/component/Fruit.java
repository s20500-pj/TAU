package comm.forest.tree.component;

import comm.forest.tree.TreeComponent;

public class Fruit extends TreeComponent {
    private String color;

    public Fruit() {
    }

    public Fruit(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void displayColor() {
        System.out.println("Color of this fruit is " + getColor());
    }
}