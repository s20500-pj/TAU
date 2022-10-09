package com.forest.tree.component;

import com.forest.tree.TreeComponent;

public class Leaf extends TreeComponent {
    private String color;

    public Leaf() {
    }

    public Leaf(String color) {
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
        System.out.println("Color of this leaf is " + getColor());
    }
}
