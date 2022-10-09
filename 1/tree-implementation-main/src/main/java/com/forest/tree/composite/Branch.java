package com.forest.tree.composite;

import com.forest.tree.TreeComponent;

import java.util.LinkedHashSet;
import java.util.Set;

public class Branch extends TreeComponent {
    private Set<TreeComponent> treeComponents = new LinkedHashSet<>();

    public Branch() {
        super();
    }

    public Set<TreeComponent> getTreeComponents() {
        return treeComponents;
    }

    public void setTreeComponents(Set<TreeComponent> treeComponents) {
        this.treeComponents = treeComponents;
    }

    public void add(TreeComponent newTreeComponent) {
        if (newTreeComponent == null) throw new NullPointerException("TreeComponent cant be null.");
        treeComponents.add(newTreeComponent);
    }

    public void remove(TreeComponent newTreeComponent) {
        treeComponents.remove(newTreeComponent);
    }

    @Override
    public void displayColor() {
        System.out.println("Colors of all parts on this branch are: ");
        for (TreeComponent treeComponent : treeComponents) {
            treeComponent.displayColor();
        }
    }

}
