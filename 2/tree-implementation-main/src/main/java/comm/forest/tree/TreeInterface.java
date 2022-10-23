package comm.forest.tree;

import java.util.Set;

public interface TreeInterface {
    void grow(long x);

    void add(TreeComponent newTreeComponent);

    void remove(TreeComponent newTreeComponent);

    void displayColor();

    void setColor(String color);

    Set<TreeComponent> getTreeComponents();

    void setTreeComponents();
}