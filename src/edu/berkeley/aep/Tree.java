package edu.berkeley.aep;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Understands how to create a non-binary tree structure with integers as root data, where each node is its own tree.
public class Tree {
    private final Integer rootData;
    private List<Tree> children;
    public final static Tree UNREACHABLE = new Tree(Integer.MAX_VALUE);

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
        return size((total, cost) -> total + 1, UNREACHABLE);
    }

    public int sumTree() {
        return size((total, cost) -> total + cost, UNREACHABLE);
    }

    public boolean contains(Tree other) {
        return size((total, cost) -> total + 1, other) == UNREACHABLE.rootData;
    }

    public int size(Strategy strategy, Tree other) {
        Queue<Tree> queue = new LinkedList<>();
        queue.add(this);
        int count = 0;
        while (!queue.isEmpty()) {
            Tree temp = queue.poll();
            if (temp.equals(other)) {
                count = UNREACHABLE.rootData;
                break; // if the node is in the tree, it returns count = UNREACHABLE.rootData
            }
            count = strategy.apply(count, temp.rootData);
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
