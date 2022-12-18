package comm.forest.tree;

import java.time.DateTimeException;
import java.util.Date;

public abstract class Tree {
    protected String name;
    protected long height;
    protected long root;
    protected Date plantingDate;
    protected TreeComponent treeTrunk; //base component

    public Tree() {
    }

    public TreeComponent getTreeTrunk() {
        return treeTrunk;
    }

    public void setTreeTrunk(TreeComponent treeTrunk) {
        if (treeTrunk == null) throw new IllegalArgumentException("TreeTrunk cant be null.");
        this.treeTrunk = treeTrunk;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null) throw new IllegalArgumentException("Name cant be null.");
        this.name = name;
    }

    public long getHeight() {
        return height;
    }

    public void setHeight(long height) {
        if (height < 0) throw new IllegalArgumentException("Height cant be negative.");
        this.height = height;
    }

    public long getRoot() {
        return root;
    }

    public void setRoot(long root) {
        if (root < 0) throw new IllegalArgumentException("Root cant be negative.");
        this.root = root;
    }

    public Date getPlantingDate() {
        return plantingDate;
    }

    public void setPlantingDate(Date plantingDate) {
        if (plantingDate.after(new Date())) {
            throw new DateTimeException("Planting date can't be in the future");
        }
        this.plantingDate = plantingDate;
    }
}