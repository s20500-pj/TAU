package comm;

import comm.forest.tree.LeafyTree;
import comm.forest.tree.TreeComponent;
import comm.forest.tree.component.Fruit;
import comm.forest.tree.composite.Branch;
import comm.forest.tree.component.Leaf;

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
        branch2.add(new Leaf("pink"));

        tree.getTreeTrunk().displayColor();
    }
}