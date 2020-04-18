package edu.berkeley.aep;

// Understands how to create a tree structure with integers as root data
public class Tree {
    private final Integer rootData;

    public Tree(Integer data) {
        this.rootData = data;
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
