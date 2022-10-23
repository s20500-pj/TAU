package comm.forest.tree.component;

import comm.forest.tree.TreeComponent;
import comm.forest.tree.enums.LeafType;

public class Leaf extends TreeComponent {
    private String color;
    private LeafType leafType;

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

    public LeafType getLeafType() {
        return leafType;
    }

    public void setLeafType(LeafType leafType) {
        this.leafType = leafType;
    }
}