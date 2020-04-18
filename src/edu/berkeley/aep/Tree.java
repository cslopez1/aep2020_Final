package edu.berkeley.aep;

import java.util.ArrayList;
import java.util.List;

// Understands how to create a tree structure with integers as root data
public class Tree {
    private final Integer rootData;
    private List<Tree> children;

    public Tree(Integer data) {
        this.rootData = data;
        this.children = new ArrayList<>();
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof Tree)) return false;
        return equals((Tree) other);
    }

    public int numChildren() {
        return children.size();
    }

    public boolean equals(Tree other) {
        try {
            return this.rootData == other.rootData;
        } catch (RuntimeException e) {
            return false;
        }
    }
}
