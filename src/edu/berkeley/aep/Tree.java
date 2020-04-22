package edu.berkeley.aep;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Understands how to create a non-binary tree structure with integers as root data, where each node is its own tree.
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
        return size((total, cost) -> total + 1);
    }

    public int sumTree() {
        return size((total, cost) -> total + cost);
    }

    public int size(Strategy strategy) {
        Queue<Tree> queue = new LinkedList<>();
        queue.add(this);
        int count = 0;
        while (!queue.isEmpty()) {
            Tree temp = queue.poll();
            count = strategy.apply(count, temp.rootData);
            queue.addAll(temp.children);
        }
        return count;
    }

    public boolean contains(Tree nodeTwo) {
        return true;
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
