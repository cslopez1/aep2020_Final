package edu.berkeley.aep;

import java.util.ArrayList;
import java.util.List;

// Understands how to create a non-binary tree structure with integers as root data
public class Tree {
    private final Integer rootData;
    private List<Tree> children;

    public Tree(Integer data) {
        this.rootData = data;
        this.children = new ArrayList<>();
    }

    public int numChildren() {
        return children.size();
    }

    public void addChild(Tree child) {
        children.add(child);
    }

    public int size() {
        Integer count = 1;
        return size(count, this);
    }

    public int size(Integer count, Tree tree) {
        for (Tree node : tree.children) {
            return size(count + 1, node);
        }
        return count + 1;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof Tree)) return false;
        return equals((Tree) other);
    }

    public boolean equals(Tree other) {
        try {
            return this.rootData == other.rootData;
        } catch (RuntimeException e) {
            return false;
        }
    }
}
