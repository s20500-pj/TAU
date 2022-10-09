package com;

import com.forest.tree.LeafyTree;
import com.forest.tree.TreeComponent;
import com.forest.tree.component.Fruit;
import com.forest.tree.composite.Branch;
import com.forest.tree.component.Leaf;

public class Demo {

    public static void main(String[] args) {

        LeafyTree tree = new LeafyTree();

        TreeComponent branch = new Branch();

        branch.add(new Fruit("red"));

        tree.setTreeTrunk(branch);

        TreeComponent branch1 = new Branch();
        TreeComponent branch2 = new Branch();

        branch.add(branch1);
        branch.add(branch2);

        branch1.add(new Leaf("green"));
        branch1.add(new Leaf("red"));
        branch1.add(new Leaf("brown"));

        branch2.add(new Fruit("yellow"));
        branch2.add(new Leaf("yellow"));

        tree.getTreeTrunk().displayColor();


    }
}
