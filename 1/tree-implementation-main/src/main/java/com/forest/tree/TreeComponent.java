package com.forest.tree;

import java.util.Set;

public abstract class TreeComponent implements TreeInterface {
    private long size;

    public TreeComponent() {
    }

    @Override
    public void add(TreeComponent treeComponent) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(TreeComponent treeComponent) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void displayColor() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setColor(String color) {
        throw new UnsupportedOperationException();
    }
    @Override
    public Set<TreeComponent> getTreeComponents(){
        throw new UnsupportedOperationException();
    }
    @Override
    public void setTreeComponents(){
        throw new UnsupportedOperationException();
    }

    @Override
    public void grow(long x) {
        if  (x < 0) throw new IllegalArgumentException("Size cant be negative.");
        this.size += x;
    }

    public TreeComponent(long size) {
        this.size = size;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        if (size < 0) throw new IllegalArgumentException("Size cant be negative.");
        this.size = size;
    }


}
