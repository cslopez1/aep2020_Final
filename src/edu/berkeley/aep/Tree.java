package edu.berkeley.aep;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Understands how to create a non-binary tree structure with integers as root data
public class Tree {
    private final Integer rootData;
    private List<Tree> children;

    private enum Type { COUNT, SUM }

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
        return size(Type.COUNT);
    }

    public int sumTree() {
        return size(Type.SUM);
    }

    public int size(Type type) {
        Queue<Tree> queue = new LinkedList<>();
        queue.add(this);
        int count = 0;
        while (!queue.isEmpty()) {
            Tree temp = queue.poll();
            if (type == Type.COUNT) {
                count++;
            }
            else {
                count += temp.rootData;
            }
            queue.addAll(temp.children);
        }
        return count;
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
